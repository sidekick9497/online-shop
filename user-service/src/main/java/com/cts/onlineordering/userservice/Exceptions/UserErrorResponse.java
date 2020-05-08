package com.cts.onlineordering.userservice.Exceptions;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UserErrorResponse {
	
	private String message;
	private Integer errorCode;
	private Long timeStamp;

}
