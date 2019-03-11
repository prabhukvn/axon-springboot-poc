package com.kvn.axonpoc.domain.commands;

import org.axonframework.commandhandling.TargetAggregateIdentifier;

public class PlaceOrderCommand {

	@TargetAggregateIdentifier
	private String aggregateIdentifier;
	private  String orderId;
	private  String productId;
	private String status;
	public PlaceOrderCommand() {
		// TODO Auto-generated constructor stub
	}
	
	public PlaceOrderCommand(String orderId, String productId) {
		super();
		this.orderId = orderId;
		this.productId = productId;
	}
	public PlaceOrderCommand(String orderId, String productId,String status) {
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

	public String getAggregateIdentifier() {
		return aggregateIdentifier;
	}

	public void setAggregateIdentifier(String aggregateIdentifier) {
		this.aggregateIdentifier = aggregateIdentifier;
	}
	
	
	
	

}
