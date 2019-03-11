package com.kvn.axonpoc.domain.queries;

public class FindAllOrderedProductsQuery {
	
	private String orderId;
	
	public FindAllOrderedProductsQuery() {
		// TODO Auto-generated constructor stub
	}

	public FindAllOrderedProductsQuery(String orderId) {
		super();
		this.orderId = orderId;
	}

	public String getOrderId() {
		return orderId;
	}

	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}
	
	

	
}
