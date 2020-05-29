package com.lwl.contactbook.dao;

import java.util.List;

import com.lwl.contactbook.domain.Contact;

public interface Dao {

	public Contact addContact(Contact contact);

	public List<Contact> getContacts();

	public List<Contact> search(String name);

	public Contact updateContact(Contact contact);

	public Contact delete(String cid);

	public Contact getContactById(String cid);
}