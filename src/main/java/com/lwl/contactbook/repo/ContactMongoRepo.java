package com.lwl.contactbook.repo;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.lwl.contactbook.domain.Contact;

public interface ContactMongoRepo extends MongoRepository<Contact, String> {

	List<Contact> findAllByName(String name);
	
}
