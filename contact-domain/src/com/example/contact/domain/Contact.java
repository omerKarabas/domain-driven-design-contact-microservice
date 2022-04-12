package com.example.contact.domain;

import java.util.Date;

import com.example.contact.ddd.annotations.Aggregate;

@Aggregate()
public class Contact {

	private final IdentityNo identityNo;
	private FullName fullName;
	private final BirthYear birthYear;
	private Adrress adrress;
	private Email email;
	private Phone phone;

	public Contact(Builder builder) {
		this.identityNo=builder.identityNo;
		this.fullName=builder.fullName;
		this.birthYear=builder.birthYear;
		this.adrress = builder.adrress;
		this.email = builder.email;
		this.phone = builder.phone;
	}
	
	
	public IdentityNo getIdentityNo() {
		return identityNo;
	}

	public FullName getFullName() {
		return fullName;
	}

	public void setFullName(FullName fullName) {
		this.fullName = fullName;
	}

	public Adrress getAdrress() {
		return adrress;
	}

	public void setAdrress(Adrress adrress) {
		this.adrress = adrress;
	}

	public Email getEmail() {
		return email;
	}

	public void setEmail(Email email) {
		this.email = email;
	}

	public Phone getPhone() {
		return phone;
	}

	public void setPhone(Phone phone) {
		this.phone = phone;
	}

	public BirthYear getBirthYear() {
		return birthYear;
	}

	public static class Builder {

		private IdentityNo identityNo;
		private FullName fullName;
		private BirthYear birthYear;
		private Adrress adrress;
		private Email email;
		private Phone phone;

		public Builder identityNo(int identityNo) {
			this.identityNo = IdentityNo.of(identityNo);
			return this;
		}

		public Builder fullname(String firstName, String lastName) {
			this.fullName = FullName.of(firstName, lastName);
			return this;
		}

		public Builder birthYear(Date brithYear) {
			this.birthYear = BirthYear.of(brithYear);
			return this;
		}

		public Builder adrress(String city, String district, String neighborhood, String street, int buildingNo,
				int doorNumber, AdrressType adrressType) {
			this.adrress = Adrress.of(city, district, neighborhood, street, buildingNo, doorNumber, adrressType);
			return this;
		}

		public Builder email(String email, EmailType emailType) {
			this.email = Email.of(email, emailType);
			return this;
		}

		public Builder phone(String phoneNumber, PhoneType phoneType) {
			this.phone = Phone.of(phoneNumber, phoneType);
			return this;
		}

		public Contact build() {
			// validation
			// business rule
			// constraint
			// invariance
			return new Contact(this);
		}

	}
}
