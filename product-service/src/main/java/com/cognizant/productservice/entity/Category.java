package com.cognizant.productservice.entity;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
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
@ToString
@Data
@Entity
@Table(name="category_table")

public class Category {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
//	private Integer id;
	@Column
	private Integer category_id;
	@Column 
	private String category_name;
	@Column
	private String category_brief;
	@OneToMany(mappedBy = "allCategory")
	Set<Product> allItems;

}
