package com.cognizant.orderservice.entity;

import java.util.Date;

import javax.persistence.*;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
@Table(name="order_table")

public class OrderEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name= "order_id")
	private Integer orderId;
	
	@Column(name= "user_id")
	private Integer userId;
	
	@Column(name= "order_type")
	private String orderType;
	
	@Column(name= "order_date")
	private Date orderDate;
	
	@Column(name= "order_amount")
	private Integer orderAmount;
	
	@Column(name= "order_status")
	private String orderStatus;
	
	@Column(name = "item_id")
	private String  itemId; //store item ids as string
	
	@Column(name = "item_qunatity")
	private String itemQuantity;
	
		
	
}
