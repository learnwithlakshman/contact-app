package com.lwl.contactbook.domain;

import org.springframework.data.annotation.Id;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;

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