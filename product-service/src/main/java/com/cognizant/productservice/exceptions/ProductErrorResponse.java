package com.cognizant.productservice.exceptions;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor


public class ProductErrorResponse {
	
	private String message;
	private Integer errorCode;
	private Long timeStamp;

}
