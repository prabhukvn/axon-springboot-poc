package com.kvn.axonpoc.controller;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

import org.axonframework.commandhandling.gateway.CommandGateway;
import org.axonframework.queryhandling.QueryGateway;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kvn.axonpoc.domain.commands.PlaceOrderCommand;
import com.kvn.axonpoc.domain.queries.FindAllOrderedProductsQuery;
import com.kvn.axonpoc.domain.vo.OrderedProduct;

@RestController
@RequestMapping("/orders")
public class OrderController {

	@Autowired
	private CommandGateway commandGateway;
	@Autowired
	private QueryGateway queryGateway;
	public static AtomicInteger aggregateGenerator = new AtomicInteger();

	@PostMapping("/create")
	public ResponseEntity<String> placeOrder(@RequestBody PlaceOrderRequest placeOrderRequest) {
		if (placeOrderRequest != null) {

			PlaceOrderCommand placeOrderCommand = new PlaceOrderCommand(placeOrderRequest.getOrderId(),
					placeOrderRequest.getProductId(), placeOrderRequest.getStatus());
			placeOrderCommand.setAggregateIdentifier(aggregateGenerator.getAndIncrement()+"");
			commandGateway.send(placeOrderCommand);
		}

		return new ResponseEntity<>("Success", HttpStatus.CREATED);
	}

	@GetMapping("/all-orders")
	public List<OrderedProduct> findAllOrderedProducts(FindAllOrderedProductsQuery findAllOrderedProductsQuery) {
		return queryGateway.query(findAllOrderedProductsQuery,
				org.axonframework.queryhandling.responsetypes.ResponseTypes.multipleInstancesOf(OrderedProduct.class))
				.join();
	}
}
