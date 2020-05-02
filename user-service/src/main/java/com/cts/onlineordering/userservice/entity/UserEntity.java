package com.cts.onlineordering.userservice.entity;

import javax.persistence.*;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
@Table(name="user_table")

public class UserEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name= "user_id")
	private Integer userId;
	
	@Column(name= "user_password")
	private String userPassword;
	
	@Column(name= "user_name")
	private String userName;
	
	@Column(name= "user_mobile")
	private String userMobile;
	
	@Column(name= "user_role")
	private String userRole;
}
