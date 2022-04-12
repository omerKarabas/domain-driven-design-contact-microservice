package com.example.contact.application;

import java.util.Optional;

import com.example.contact.domain.Contact;

public interface ContactApplication {

	Optional<Contact> addContact (Contact contact);
	Optional<Contact> removeContact(int identityNo);
	Optional<Contact> findContactById(int identityNo);
	Optional<Contact> updateContact(int identityNo,Contact contact);
	
}
