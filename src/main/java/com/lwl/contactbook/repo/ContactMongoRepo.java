package com.lwl.contactbook.repo;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import com.lwl.contactbook.domain.Contact;

public interface ContactMongoRepo extends MongoRepository<Contact, String> {

	@Query(value = "{'name': {$regex : ?0, $options: 'i'}}")
	List<Contact> findAllByName(String name);

	List<Contact> findByMobileStartingWith(String number);

	List<Contact> findByOrderByNameAsc();

}
