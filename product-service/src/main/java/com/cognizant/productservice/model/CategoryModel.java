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
public class CategoryModel {

	private Integer category_id;
	private String category_name;
	private String category_brief;
	
	
}
