package com.contact.controller;

import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.annotation.RequestScope;

import com.contact.dto.request.ContactRequest;
import com.contact.dto.response.ContactResponse;
import com.contact.service.ContactService;

@RestController
@RequestMapping("contacts")
@RequestScope
@Validated
@CrossOrigin
public class ContactController {

	private ContactService contactService;
	
	private ContactController(ContactService contactService) {
		super();
		this.contactService = contactService;
	}

	@GetMapping("{identityNo}")
	public ContactResponse findContactById(int identityNo) {
		return contactService.findContactById(identityNo); 
	}
	
	@PostMapping
	public ContactResponse addContact (ContactRequest contactRequest) {
		return contactService.addContact(contactRequest);
	}
	
	@DeleteMapping
	public ContactResponse removeContact(int identityNo) {
		return contactService.removeContact(identityNo);
	}
	
	@PutMapping
	public ContactResponse updateContact(int identityNo, ContactRequest contactRequest) {
		return contactService.updateContactById(identityNo, contactRequest);
	}
	
}
