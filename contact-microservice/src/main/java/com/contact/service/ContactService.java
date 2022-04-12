package com.contact.service;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import com.contact.dto.request.ContactRequest;
import com.contact.dto.response.ContactResponse;
import com.example.contact.application.ContactApplication;
import com.example.contact.domain.Contact;

@Service
public class ContactService {

	private ContactApplication contactApplication;
	private ModelMapper modelMapper;
	
	private ContactService(ContactApplication contactApplication, ModelMapper modelMapper) {
		super();
		this.contactApplication = contactApplication;
		this.modelMapper = modelMapper;
	} 
	
	public ContactResponse addContact(ContactRequest contactRequest) {
		var newContact = modelMapper.map(contactRequest, Contact.class);
		var addContact = contactApplication.addContact(newContact);
		return modelMapper.map(addContact, ContactResponse.class);
	}
	
	public ContactResponse removeContact(int identityNo) {
		
		var deletedContact = contactApplication.removeContact(identityNo);
		return modelMapper.map(deletedContact, ContactResponse.class);
	}
	
	public ContactResponse findContactById(int identityNo) {
		
	     return modelMapper.map(contactApplication.findContactById(identityNo), ContactResponse.class);
	}
	
	public ContactResponse updateContactById(int identityNo, ContactRequest contactRequest) {
		
		var updatedContact = modelMapper.map(contactRequest, Contact.class);
		var foundContact = modelMapper.map(contactApplication.findContactById(identityNo),Contact.class);
			foundContact.setFullName(updatedContact.getFullName());
		    foundContact.setAdrress(updatedContact.getAdrress());
		    foundContact.setEmail(updatedContact.getEmail());
		    foundContact.setPhone(updatedContact.getPhone());
		    
	   return modelMapper.map(foundContact, ContactResponse.class);
		    
	}
	
}
