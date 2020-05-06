package com.cts.onlineordering.userservice.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "authorities")
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor

public class Authorities implements Serializable {
	
	@Id
	@Column(insertable = true,length = 100)
	private String userName;
	
	@Id
	@Column(insertable = true,length = 100)
	private String authority;

}
