package com.example.rabbitmq.demo.dto;

public class OrderStatusDTO {

	private OrderDTO orderDTO;
	private String status;
	private String message;
	public OrderDTO getOrderDTO() {
		return orderDTO;
	}
	public void setOrderDTO(OrderDTO orderDTO) {
		this.orderDTO = orderDTO;
	}
	public String getStatus() {
		return status;
	}
	public OrderStatusDTO(OrderDTO orderDTO, String status, String message) {
		super();
		this.orderDTO = orderDTO;
		this.status = status;
		this.message = message;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	@Override
	public String toString() {
		return "OrderStatusDTO [orderDTO=" + orderDTO + ", status=" + status + ", message=" + message + "]";
	}
	public OrderStatusDTO() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
}
