package com.lwl.contactbook.web;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lwl.contactbook.domain.Contact;
import com.lwl.contactbook.dto.ContactDTO;
import com.lwl.contactbook.service.ContactService;

@RestController
@RequestMapping("api/capp/")
public class ContactController {

	@Autowired
	private ContactService contactService;

	@PostMapping("add")
	public Contact addContact(@RequestBody ContactDTO contactDTO) {
		ModelMapper mapper = new ModelMapper();
		Contact contact = mapper.map(contactDTO, Contact.class);
		return contactService.addContact(contact);
	}

	@GetMapping("getall")
	public List<Contact> getAllContacts() {
		return contactService.getContacts();
	}

	@GetMapping("search/{name}")
	public List<Contact> search(@PathVariable String name) {
		return contactService.search(name);
	}

	@PutMapping("update")
	public Contact updateContact(@RequestBody Contact contact) {
		return contactService.updateContact(contact);
	}

	@DeleteMapping("delete/{cid}")
	public Contact deleteById(@PathVariable String cid) {
		return contactService.delete(cid);
	}

	@GetMapping("get/{cid}")
	public Contact getContactById(@PathVariable String cid) {
		return contactService.getContactById(cid);
	}

}
