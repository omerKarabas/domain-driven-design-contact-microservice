package com.example.contact.domain;

import java.util.Objects;

import com.example.contact.ddd.annotations.ValueObject;

@ValueObject
public final  class IdentityNo {

	private final int identityNo;

	public static IdentityNo of(int identityNo) {
		
		return new IdentityNo(identityNo);
	}
	private IdentityNo(int identityNo) {
		this.identityNo = identityNo;
	}

	public int getIdentityNo() {
		return identityNo;
	}

	@Override
	public int hashCode() {
		return Objects.hash(identityNo);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		IdentityNo other = (IdentityNo) obj;
		return identityNo == other.identityNo;
	}

	@Override
	public String toString() {
		return "IdnetityNo [identityNo=" + identityNo + "]";
	}
	
	
	
}
