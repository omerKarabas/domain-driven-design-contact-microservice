package com.example.contact.domain;

import java.util.Objects;

import com.example.contact.ddd.annotations.ValueObject;

@ValueObject
public final class Phone {

	private final String phoneNumber;
	private final PhoneType phoneType;

	public static Phone of (String phoneNumber, PhoneType phoneType) {
		return new Phone(phoneNumber, phoneType);
	}
	private Phone(String phoneNumber, PhoneType phoneType) {
		super();
		this.phoneNumber = phoneNumber;
		this.phoneType = phoneType;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public PhoneType getPhoneType() {
		return phoneType;
	}

	@Override
	public int hashCode() {
		return Objects.hash(phoneNumber, phoneType);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Phone other = (Phone) obj;
		return Objects.equals(phoneNumber, other.phoneNumber) && phoneType == other.phoneType;
	}

	@Override
	public String toString() {
		return "Phone [phoneNumber=" + phoneNumber + ", phoneType=" + phoneType + "]";
	}

}
