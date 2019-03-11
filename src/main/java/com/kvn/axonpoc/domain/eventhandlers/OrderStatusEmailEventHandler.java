package com.kvn.axonpoc.domain.eventhandlers;

import org.axonframework.eventhandling.EventHandler;
import org.axonframework.eventsourcing.SequenceNumber;
import org.springframework.stereotype.Service;

import com.kvn.axonpoc.domain.events.SendStatusMailEvent;
@Service
public class OrderStatusEmailEventHandler {
	
	@EventHandler
	public void on(SendStatusMailEvent event,@SequenceNumber Long version) {
		String orderId = event.getOrderId();
		System.out.println("Email has been to update order "+orderId);
		
	}

}
