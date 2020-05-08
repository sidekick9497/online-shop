package com.cts.onlineordering.cartservice.model;


import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class ProductModel {
	
	private Integer item_id;	
	private String item_name;	
	private Integer item_price;	
	private String item_description;
	private CategoryModel allCategory;

	
}
