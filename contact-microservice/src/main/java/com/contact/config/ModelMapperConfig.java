package com.contact.config;

import org.modelmapper.Converter;
import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.contact.document.ContactDocument;
import com.contact.dto.request.ContactRequest;
import com.contact.dto.response.ContactResponse;
import com.example.contact.domain.Contact;

@Configuration
public class ModelMapperConfig {

	private static final  Converter<ContactRequest, Contact>
		CONTACT_REQUEST_TO_CONTACT_CONVERTER = (context) ->{
			
			var request = context.getSource();
			return new Contact.Builder()
							 .identityNo(request.getIdentityNo())
							 .fullname(request.getFirstName(),request.getLastName())
							 .birthYear(request.getBirthYear())
							 .adrress(request.getAdrress().getCity(),
									 request.getAdrress().getDistrict(), 
									 request.getAdrress().getNeighborhood(), 
									 request.getAdrress().getStreet(), 
									 request.getAdrress().getBuildingNo(), 
									 request.getAdrress().getDoorNumber(), 
									 request.getAdrress().getAdrressType())
							 .email(request.getEmail().getEmail(), request.getEmail().getEmailType())
							 .phone(request.getPhone().getPhoneNumber(), request.getPhone().getPhoneType())
							 .build();
		};
		
	private static final Converter<ContactDocument,Contact>
		CONTACT_DOCUMENT_TO_CONTACT_CONVERTER = (context) -> {
			var document = context.getSource();
			return new Contact.Builder()
							  .identityNo(document.getIdentity())
							  .fullname(document.getFirstName(),document.getLastName())
							  .birthYear(document.getBirthYear())
							  .adrress(document.getAdrress().getCity(),
									  document.getAdrress().getDistrict(), 
									  document.getAdrress().getNeighborhood(), 
									  document.getAdrress().getStreet(), 
									  document.getAdrress().getBuildingNo(), 
									  document.getAdrress().getDoorNumber(), 
									  document.getAdrress().getAdrressType())
							  .email(document.getEmail().getEmail(), document.getEmail().getEmailType())
							  .phone(document.getPhone().getPhoneNumber(), document.getPhone().getPhoneType())
							  .build();
		};
		
	private static final Converter<Contact,ContactResponse>
		CONTACT_TO_CONTACT_RESPONSE_CONVERTER = (context) -> {
			var contact = context.getSource();
			var response = new ContactResponse();
			response.setIdentityNo(contact.getIdentityNo().getIdentityNo());
			response.setFirstName(contact.getFullName().getFirstName());
			response.setLastName(contact.getFullName().getLastName());
			response.setBirthYear(contact.getBirthYear().getBirthYear());
			response.setAdrress(contact.getAdrress());
			response.setEmail(contact.getEmail());
			response.setPhone(contact.getPhone());
			return response;
				
		};
		
	private static final Converter<Contact,ContactDocument>
		CONTACT_TO_CONTACT_DOCUMENT_DOCUMENT = (context) -> {
			var contact = context.getSource();
			var document = new ContactDocument();
			document.setIdentity(contact.getIdentityNo().getIdentityNo());
			document.setFirstName(contact.getFullName().getFirstName());
			document.setLastName(contact.getFullName().getLastName());
			document.setAdrress(contact.getAdrress());
			document.setEmail(contact.getEmail());
			document.setPhone(contact.getPhone());
			return document;
		};
	@Bean
	public ModelMapper modelMapper() {
		
		var modelMapper = new ModelMapper();
		
		modelMapper.addConverter(CONTACT_REQUEST_TO_CONTACT_CONVERTER, 
				ContactRequest.class, Contact.class);
		
		modelMapper.addConverter(CONTACT_DOCUMENT_TO_CONTACT_CONVERTER, 
				ContactDocument.class, Contact.class);
		
		modelMapper.addConverter(CONTACT_TO_CONTACT_RESPONSE_CONVERTER, 
				Contact.class, ContactResponse.class);
		
		modelMapper.addConverter(CONTACT_TO_CONTACT_DOCUMENT_DOCUMENT, 
				Contact.class, ContactDocument.class);
		
		return modelMapper;
	}
}
