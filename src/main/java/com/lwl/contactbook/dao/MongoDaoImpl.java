package com.lwl.contactbook.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;

import com.lwl.contactbook.domain.Contact;
import com.lwl.contactbook.repo.ContactMongoRepo;
import com.mongodb.client.result.UpdateResult;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class MongoDaoImpl implements Dao {

	@Autowired
	private MongoOperations mongoOperations;

	@Autowired
	private ContactMongoRepo repo;

	@Override
	public Contact addContact(Contact contact) {
		return repo.save(contact);
	}

	@Override
	public List<Contact> getContacts() {
		return repo.findByOrderByNameAsc();
	}

	@Override
	public List<Contact> search(String search) {
		String numberRegex = "\\d+";
		search = search.trim();
		if (search.matches(numberRegex)) {
			return repo.findByMobileStartingWith(search);
		}
		return repo.findAllByName(search);
	}

	@Override
	public Contact updateContact(Contact contact) {
		Query query = new Query();
		query.addCriteria(Criteria.where("_id").is(contact.getCid()));
		Update update = new Update();

		Contact existingContact = getContactById(contact.getCid());

		if (existingContact != null) {
			update.set("name", contact.getName());
			update.set("mobile", contact.getMobile());
			update.set("email", contact.getEmail());
			update.set("city", contact.getCity());
			UpdateResult response = mongoOperations.upsert(query, update, Contact.class);
			if (response != null) {
				log.info("Modified {} records ", response.getModifiedCount());
			} else {
				log.info("Update failed");
			}
			return getContactById(contact.getCid());
		}
		return null;
	}

	@Override
	public Contact delete(String cid) {
		Contact contact = getContactById(cid);
		if (contact != null) {
			repo.deleteById(cid);
		}
		return contact;
	}

	@Override
	public Contact getContactById(String cid) {
		Optional<Contact> contact = repo.findById(cid);
		if (contact.isPresent()) {
			return contact.get();
		}
		return null;
	}

}
