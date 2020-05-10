package com.cts.onlineordering.cartservice.model;

import lombok.*;

import java.util.Date;

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
	private String itemId; //store the ids of  the items as string, later can be extrated by splitting them.
}
