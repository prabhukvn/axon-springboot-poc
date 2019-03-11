package com.kvn.axonpoc.domain.aggregate;

import java.util.HashMap;
import java.util.Map;

import org.axonframework.commandhandling.CommandHandler;
import org.axonframework.commandhandling.model.AggregateIdentifier;
import org.axonframework.commandhandling.model.AggregateLifecycle;
import org.axonframework.eventsourcing.EventSourcingHandler;
import org.axonframework.eventsourcing.SequenceNumber;
import org.axonframework.spring.stereotype.Aggregate;

import com.kvn.axonpoc.domain.commands.PlaceOrderCommand;
import com.kvn.axonpoc.domain.events.OrderPlacedEvent;
import com.kvn.axonpoc.domain.events.SendStatusMailEvent;

@Aggregate

public class OrderAggregate {

	@AggregateIdentifier
	private String aggregateIdentifier;
	private String orderId;

	private String orderConfirmed;
	public static Map<String, String> ordersMap = new HashMap<>();

	@CommandHandler
	public OrderAggregate(PlaceOrderCommand command) {
		System.out.println("Order Placed:"+command.getOrderId());
		// initialize aggregate identifier. this has to be handled in @EventSourcingHandler method
		if(aggregateIdentifier==null) {
			aggregateIdentifier=command.getAggregateIdentifier();
		}
		ordersMap.put(command.getOrderId(), command.getProductId());
		AggregateLifecycle.apply(new OrderPlacedEvent(command.getOrderId(), command.getProductId(),command.getStatus()));
		AggregateLifecycle.apply(new SendStatusMailEvent(command.getOrderId()));
	}

	/**
	 * Aggregate identifier always has to be set in events sourcing handler method.
	 * @param event
	 * @param version
	 */
	@EventSourcingHandler
	public void on(OrderPlacedEvent event,@SequenceNumber Long version) {
		
		orderConfirmed = event.getStatus();
		orderId = event.getOrderId();
	}
}
