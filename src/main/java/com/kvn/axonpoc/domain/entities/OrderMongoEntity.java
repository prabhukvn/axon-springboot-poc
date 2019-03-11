/**
 * 
 */
package com.kvn.axonpoc.domain.entities;

import java.util.ArrayList;
import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * @author prabhu
 *
 */
@Document("Orders")
public class OrderMongoEntity {

	@Id
	public String orderId;
	public String status;
	public List<OrderItemMongoEntity> orderItems = new ArrayList<>();
	public String getOrderId() {
		return orderId;
	}
	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}
	public List<OrderItemMongoEntity> getOrderItems() {
		return orderItems;
	}
	public void setOrderItems(List<OrderItemMongoEntity> orderItems) {
		this.orderItems = orderItems;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	
	
	
	
}


