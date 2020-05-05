package com.cognizant.productservice.model;



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
public class ProductModel {
	
	private Integer item_id;	
	private String item_name;	
	private Integer item_price;	
	private String item_description;
	private CategoryModel allCategory;

	
}
