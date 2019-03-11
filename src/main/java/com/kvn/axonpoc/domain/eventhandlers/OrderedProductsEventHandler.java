package com.kvn.axonpoc.domain.eventhandlers;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.axonframework.eventhandling.EventHandler;
import org.axonframework.eventsourcing.SequenceNumber;
import org.axonframework.queryhandling.QueryHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kvn.axonpoc.domain.entities.OrderItemMongoEntity;
import com.kvn.axonpoc.domain.entities.OrderMongoEntity;
import com.kvn.axonpoc.domain.events.OrderPlacedEvent;
import com.kvn.axonpoc.domain.queries.FindAllOrderedProductsQuery;
import com.kvn.axonpoc.domain.vo.OrderedProduct;
import com.kvn.axonpoc.repositories.OrderMongoRepository;

@Service
public class OrderedProductsEventHandler {

	private final Map<String, OrderedProduct> orderedProducts = new HashMap<>();
	@Autowired
	OrderMongoRepository orderMongoRepository;

	@EventHandler
	public void on(OrderPlacedEvent event,@SequenceNumber Long version) {
		String orderId = event.getOrderId();
		orderedProducts.put(orderId, new OrderedProduct(orderId, event.getProductId(), event.getStatus()));
		OrderMongoEntity order = new OrderMongoEntity();
		OrderItemMongoEntity orderItem = new OrderItemMongoEntity();
		orderItem.setProductId(event.getProductId());
		orderItem.setQuantity(1);
		order.setStatus(event.getStatus());
		
		order.getOrderItems().add(orderItem);
		order.setOrderId(event.getOrderId());
		orderMongoRepository.save(order);
		// here we can also send a command to trigger further changes.
	}
	

	@QueryHandler
	public List<OrderedProduct> handle(FindAllOrderedProductsQuery query) {
		if (query.getOrderId() != null) {
			List<OrderedProduct> listOfOrderedProduct = new ArrayList<>();
			listOfOrderedProduct.add(orderedProducts.get(query.getOrderId()));
			return listOfOrderedProduct;
		} else {
			return new ArrayList<>(orderedProducts.values());
		}
	}
}