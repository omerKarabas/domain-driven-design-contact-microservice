package com.contact.dto.request;

import java.util.Date;
import java.util.Objects;

import com.example.contact.domain.Adrress;
import com.example.contact.domain.Email;
import com.example.contact.domain.Phone;

public class ContactRequest {

	private int identityNo;
	private String firstName;
	private String lastName;
	private Date birthYear;
	private Adrress adrress;
	private Email email;
	private Phone phone;
	
	public ContactRequest() {
		
	}

	public int getIdentityNo() {
		return identityNo;
	}

	public void setIdentityNo(int identityNo) {
		this.identityNo = identityNo;
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
		return Objects.hash(adrress, birthYear, email, firstName, identityNo, lastName, phone);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ContactRequest other = (ContactRequest) obj;
		return Objects.equals(adrress, other.adrress) && Objects.equals(birthYear, other.birthYear)
				&& Objects.equals(email, other.email) && Objects.equals(firstName, other.firstName)
				&& identityNo == other.identityNo && Objects.equals(lastName, other.lastName)
				&& Objects.equals(phone, other.phone);
	}

	@Override
	public String toString() {
		return "ContactRequest [identityNo=" + identityNo + ", firstName=" + firstName + ", lastName=" + lastName
				+ ", birthYear=" + birthYear + ", adrress=" + adrress + ", email=" + email + ", phone=" + phone + "]";
	}
	
}
