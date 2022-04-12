package com.contact.document;

import java.util.Date;
import java.util.Objects;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import com.example.contact.domain.Adrress;
import com.example.contact.domain.Email;
import com.example.contact.domain.Phone;

@Document(collection = "contacts")
public class ContactDocument {

	@Id
	private int identity;
	@NotBlank
	@Min(3)
	@Max(20)
	@Field("first_name")
	private String firstName;
	@NotBlank
	@Min(2)
	@Max(20)
	@Field("last_name")
	private String lastName;
	@Field("birth_year")
	private Date birthYear;
	@NotBlank
	@Field("adrress")
	private Adrress adrress;
	@NotBlank
	@Field("email")
	private Email email;
	@NotBlank
	@Field("phone")
	private Phone phone;

	public ContactDocument() {

	}

	public int getIdentity() {
		return identity;
	}

	public void setIdentity(int identity) {
		this.identity = identity;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public Date getBirthYear() {
		return birthYear;
	}

	public void setBirthYear(Date birthYear) {
		this.birthYear = birthYear;
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

	@Override
	public int hashCode() {
		return Objects.hash(adrress, birthYear, email, firstName, identity, lastName, phone);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ContactDocument other = (ContactDocument) obj;
		return Objects.equals(adrress, other.adrress) && Objects.equals(birthYear, other.birthYear)
				&& Objects.equals(email, other.email) && Objects.equals(firstName, other.firstName)
				&& Objects.equals(identity, other.identity) && Objects.equals(lastName, other.lastName)
				&& Objects.equals(phone, other.phone);
	}

	@Override
	public String toString() {
		return "ContactDocument [identity=" + identity + ", firstName=" + firstName + ", lastName=" + lastName
				+ ", birthYear=" + birthYear + ", adrress=" + adrress + ", email=" + email + ", phone=" + phone + "]";
	}

}
