package com.cognizant.orderservice.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Data
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
	
	@Column(name = "item_quantity")
	private String itemQuantity;
	
		
	
}
