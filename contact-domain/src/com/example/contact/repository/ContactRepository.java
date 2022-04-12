package com.example.contact.repository;

import java.util.Optional;

import com.example.contact.domain.Contact;

public interface ContactRepository {

	Contact addContact(Contact contact);
	Optional<Contact> removeContact(int identityNo);
	Optional<Contact> updateContact(int identityNo, Contact contact);
	Optional<Contact> findContact(int identityNo);
}
