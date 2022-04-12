package com.example.contact.domain;

import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.ConcurrentHashMap;

import com.example.contact.ddd.annotations.ValueObject;

@ValueObject
public final class Email {

	private final String email;
	private final EmailType emailType;

	public static Email of(String email, EmailType emailType) {

		return new Email(email, emailType);
	}

	private Email(String email, EmailType emailType) {
		super();
		this.email = email;
		this.emailType = emailType;
	}

	public String getEmail() {
		return email;
	}

	public EmailType getEmailType() {
		return emailType;
	}

	@Override
	public int hashCode() {
		return Objects.hash(email, emailType);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Email other = (Email) obj;
		return Objects.equals(email, other.email) && emailType == other.emailType;
	}

	@Override
	public String toString() {
		return "Email [email=" + email + ", emailType=" + emailType + "]";
	}

}
