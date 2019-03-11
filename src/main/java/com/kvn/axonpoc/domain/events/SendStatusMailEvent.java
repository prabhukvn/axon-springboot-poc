/**
 * 
 */
package com.kvn.axonpoc.domain.events;

/**
 * @author prabhu
 *
 */
public class SendStatusMailEvent {
	
	private String orderId;

	public SendStatusMailEvent() {
		// TODO Auto-generated constructor stub
	}
	public SendStatusMailEvent(String orderId) {
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
