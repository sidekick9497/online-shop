package com.cts.onlineordering.userservice.entity;

import javax.persistence.*;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
@Table(name="users")

public class UserEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name= "user_id")
	private Integer userId;
	
	@Column(name= "password")
	private String userPassword;
	@Column(name="enabled")
	private Boolean enabled;

	@Column(name= "username")
	private String userName;
	
	@Column(name= "user_mobile")
	private String userMobile;
	

}
