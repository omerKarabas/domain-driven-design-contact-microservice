package com.example.contact.application.business;

import java.util.Optional;

import com.example.contact.application.ContactApplication;
import com.example.contact.domain.Contact;
import com.example.contact.repository.ContactRepository;

public class StandardContactApplication implements ContactApplication {
	
	private ContactRepository  contactRepository;
	
	@Override
	public Optional<Contact> addContact(Contact contact) {
		
		return Optional.of(contactRepository.addContact(contact));
	}

	@Override
	public Optional<Contact> removeContact(int identityNo) {
		
		Optional<Contact> removedContact = contactRepository.removeContact(identityNo);
		return removedContact;
	}

	@Override
	public Optional<Contact> findContactById(int identityNo) {
		Optional<Contact> foundContact = contactRepository.findContact(identityNo); 
		return foundContact;
	}

	@Override
	public Optional<Contact> updateContact(int identityNo, Contact contact) {
		Optional<Contact> updatedContact = contactRepository.updateContact(identityNo, contact);
		return updatedContact;
	}

}
