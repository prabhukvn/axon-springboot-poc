package com.kvn.axonpoc.domain.events;

import org.axonframework.commandhandling.TargetAggregateIdentifier;

public class OrderPlacedEvent {

	@TargetAggregateIdentifier
	private  String orderId;
	private  String productId;
	private String status;
	public OrderPlacedEvent() {
		// TODO Auto-generated constructor stub
	}
	
	public OrderPlacedEvent(String orderId, String productId) {
		super();
		this.orderId = orderId;
		this.productId = productId;
	}
	public OrderPlacedEvent(String orderId, String productId,String status) {
		super();
		this.orderId = orderId;
		this.productId = productId;
		this.status=status;
	}

	public String getOrderId() {
		return orderId;
	}

	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}

	public String getProductId() {
		return productId;
	}

	public void setProductId(String productId) {
		this.productId = productId;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
	
	
	
	

}
