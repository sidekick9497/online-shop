package com.cts.onlineordering.cartservice.model;

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
public class ItemModel {
	
	private Integer item_id;
	private Integer item_name;
	private Integer item_price;
	private Integer item_descrption;
	private Integer item_quantity;
	

}
