package com.cognizant.orderservice.model;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString

public class OrderModel {
	
	private Integer orderId;
	private Integer userId;
	private String orderType;
	private Date orderDate;
	private Integer orderAmount;
	private String orderStatus;
	
}
