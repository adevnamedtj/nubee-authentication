package com.tejio.oj.nubee.authentication.model;

import java.util.Objects;

public class Address {
	private String addressName;
	private String addressType;
	private String addressLine1;
	private String addressLine2;
	private String city;
	private String state;
	private String country;
	private String zipcode;
	private Boolean isAllowedToReachout;
	public Address() {

	}
	public Address(String addressName, String addressType, String addressLine1, String addressLine2, String city,
			String state, String country, String zipcode, Boolean isAllowedToReachout) {
		super();
		this.addressName = addressName;
		this.addressType = addressType;
		this.addressLine1 = addressLine1;
		this.addressLine2 = addressLine2;
		this.city = city;
		this.state = state;
		this.country = country;
		this.zipcode = zipcode;
		this.isAllowedToReachout = isAllowedToReachout;
	}
	public String getAddressName() {
		return addressName;
	}
	public void setAddressName(String addressName) {
		this.addressName = addressName;
	}
	public String getAddressType() {
		return addressType;
	}
	public void setAddressType(String addressType) {
		this.addressType = addressType;
	}
	public String getAddressLine1() {
		return addressLine1;
	}
	public void setAddressLine1(String addressLine1) {
		this.addressLine1 = addressLine1;
	}
	public String getAddressLine2() {
		return addressLine2;
	}
	public void setAddressLine2(String addressLine2) {
		this.addressLine2 = addressLine2;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public String getZipcode() {
		return zipcode;
	}
	public void setZipcode(String zipcode) {
		this.zipcode = zipcode;
	}
	public Boolean getIsAllowedToReachout() {
		return isAllowedToReachout;
	}
	public void setIsAllowedToReachout(Boolean isAllowedToReachout) {
		this.isAllowedToReachout = isAllowedToReachout;
	}
	@Override
	public int hashCode() {
		return Objects.hash(addressLine1, addressLine2, addressName, addressType, city, country, isAllowedToReachout,
				state, zipcode);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (!(obj instanceof Address)) {
			return false;
		}
		Address other = (Address) obj;
		return Objects.equals(addressLine1, other.addressLine1) && Objects.equals(addressLine2, other.addressLine2)
				&& Objects.equals(addressName, other.addressName) && Objects.equals(addressType, other.addressType)
				&& Objects.equals(city, other.city) && Objects.equals(country, other.country)
				&& Objects.equals(isAllowedToReachout, other.isAllowedToReachout) && Objects.equals(state, other.state)
				&& Objects.equals(zipcode, other.zipcode);
	}
	@Override
	public String toString() {
		return "Address [addressName=" + addressName + ", addressType=" + addressType + ", addressLine1=" + addressLine1
				+ ", addressLine2=" + addressLine2 + ", city=" + city + ", state=" + state + ", country=" + country
				+ ", zipcode=" + zipcode + ", isAllowedToReachout=" + isAllowedToReachout + "]";
	}
	
	
}
