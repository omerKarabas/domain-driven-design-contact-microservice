package com.example.contact.domain;

import java.util.Objects;

import com.example.contact.ddd.annotations.ValueObject;

@ValueObject
public final class Adrress {

	private final String city;
	private final String district;
	private final String neighborhood;
	private final String street;
	private final int buildingNo;
	private final int doorNumber;
	private final AdrressType adrressType;

	public static Adrress of(String city, String district, String neighborhood, String street, int buildingNo, int doorNumber,
			AdrressType adrressType) {
		return new Adrress(city,district,neighborhood,street,buildingNo,doorNumber,adrressType);
	}

	private Adrress(String city, String district, String neighborhood, String street, int buildingNo, int doorNumber,
			AdrressType adrressType) {
		super();
		this.city = city;
		this.district = district;
		this.neighborhood = neighborhood;
		this.street = street;
		this.buildingNo = buildingNo;
		this.doorNumber = doorNumber;
		this.adrressType = adrressType;
	}

	public String getCity() {
		return city;
	}

	public String getDistrict() {
		return district;
	}

	public String getNeighborhood() {
		return neighborhood;
	}

	public String getStreet() {
		return street;
	}

	public int getBuildingNo() {
		return buildingNo;
	}

	public int getDoorNumber() {
		return doorNumber;
	}

	public AdrressType getAdrressType() {
		return adrressType;
	}

	@Override
	public int hashCode() {
		return Objects.hash(adrressType, buildingNo, city, district, doorNumber, neighborhood, street);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Adrress other = (Adrress) obj;
		return adrressType == other.adrressType && buildingNo == other.buildingNo && Objects.equals(city, other.city)
				&& Objects.equals(district, other.district) && doorNumber == other.doorNumber
				&& Objects.equals(neighborhood, other.neighborhood) && Objects.equals(street, other.street);
	}

	@Override
	public String toString() {
		return "Adrress [city=" + city + ", district=" + district + ", neighborhood=" + neighborhood + ", street="
				+ street + ", buildingNo=" + buildingNo + ", doorNumber=" + doorNumber + ", adrressType=" + adrressType
				+ "]";
	}
	
}
