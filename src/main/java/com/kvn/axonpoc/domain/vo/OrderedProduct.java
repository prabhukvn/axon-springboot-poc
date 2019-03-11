package com.kvn.axonpoc.domain.vo;

public class OrderedProduct {

	
	
	private final String orderId;
    private final String product;
    private String orderStatus;
 
    public OrderedProduct(String orderId, String product,String status) {
        this.orderId = orderId;
        this.product = product;
        orderStatus = status;
    }

	public String getOrderId() {
		return orderId;
	}

	public String getProduct() {
		return product;
	}

	public String getOrderStatus() {
		return orderStatus;
	}

	public void setOrderStatus(String orderStatus) {
		this.orderStatus = orderStatus;
	}
    
    
    
}
