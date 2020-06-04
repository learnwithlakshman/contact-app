package com.lwl.contactbook.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import com.lwl.contactbook.dao.Dao;
import com.lwl.contactbook.domain.Contact;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class ContactServiceMongo implements ContactService {

	@Autowired
	private Dao dao;

	@Override
	public Contact addContact(Contact contact) {
		Assert.notNull(contact, "This can't be null");
		contact = dao.addContact(contact);
		if (contact != null) {
			log.info("New Contact added to DB with CID : {} ", contact.getCid());
		} else {
			log.info("Something went wrong while adding new contact");
		}
		return contact;
	}

	@Override
	public List<Contact> getContacts() {
		List<Contact> list = dao.getContacts();
		log.info("Total Contacts found are : {} ", list != null ? list.size() : 0);
		return list;
	}

	@Override
	public List<Contact> search(String name) {
		Assert.notNull(name, "This can't be null");
		List<Contact> list = dao.search(name);
		log.info("Total Search Contacts found are : {} for searchstring {} ", list != null ? list.size() : 0, name);
		return list;
	}

	@Override
	public Contact updateContact(Contact contact) {
		Assert.notNull(contact, "This can't be null");
		Assert.notNull(contact.getCid(), "CID can't be null for updating");
		contact = dao.updateContact(contact);
		if (contact != null) {
			log.info("update successfull for cid {} ", contact.getCid());
		} else {
			log.info("Something went wrong while updating");
		}
		return contact;
	}

	@Override
	public Contact delete(String cid) {
		Assert.notNull(cid, "CID Can't be null");
		Contact contact = dao.delete(cid);
		if (contact != null) {
			log.info("Contact with name: {} and cid : {} deleted successfully ", contact.getName(), cid);
		} else {
			log.info("Couldn't delete contact with cid : {} ", cid);
		}
		return contact;
	}

	@Override
	public Contact getContactById(String cid) {
		Assert.notNull(cid, "CID Can't be null");
		Contact contact = dao.getContactById(cid);
		if (contact != null) {
			log.info("Contact found for id {} is {} ", cid, contact.getName());
		} else {
			log.info("No contact found for id {} ", cid);
		}
		return contact;
	}

}
