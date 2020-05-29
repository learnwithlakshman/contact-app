package com.lwl.contactbook.domain;

import org.springframework.data.annotation.Id;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Contact {

	@Id
	private String cid;

	private String name;
	private String mobile;
	private String email;
	private String city;

}