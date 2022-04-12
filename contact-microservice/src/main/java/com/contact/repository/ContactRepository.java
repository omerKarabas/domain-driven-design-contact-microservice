package com.contact.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.contact.document.ContactDocument;

public interface ContactRepository extends MongoRepository<ContactDocument, Integer> {

}
