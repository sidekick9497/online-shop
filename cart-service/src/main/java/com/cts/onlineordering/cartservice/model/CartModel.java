package com.cts.onlineordering.cartservice.model;

import java.util.List;

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

public class CartModel<Item> {
	
	private Integer user_id;
	private Integer item_id;
	private Integer item_quantity;
	private List<ItemModel> ltemlist;

}
