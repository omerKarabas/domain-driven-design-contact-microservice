package com.example.contact.domain;

import java.util.Date;
import java.util.Objects;

import com.example.contact.ddd.annotations.ValueObject;

@ValueObject
public final class BirthYear {

	private final Date birthYear;

	public static BirthYear of (Date birthYear) {
		return new BirthYear(birthYear);
	}
	private BirthYear(Date birthYear) {
		super();
		this.birthYear = birthYear;
	}

	public Date getBirthYear() {
		return birthYear;
	}

	@Override
	public int hashCode() {
		return Objects.hash(birthYear);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		BirthYear other = (BirthYear) obj;
		return Objects.equals(birthYear, other.birthYear);
	}

	@Override
	public String toString() {
		return "BirthYear [birthYear=" + birthYear + "]";
	}
	
	
}
