package com.tejio.oj.nubee.authentication.model;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection="usermetadata")
public class User {

	@Id
	private String userId;
	private String firstName;
	private String lastName;
	private String passwordHash;
	private String email;
	private List<String> phoneNumbers;
	private LocalDateTime created;
	private List<Package> packages;
	private Address address;
	private Address billingAddress;
	public User() {
		super();
		// TODO Auto-generated constructor stub
	}
	public User(String userId, String firstName, String lastName, String passwordHash, String email,
			List<String> phoneNumbers, LocalDateTime created, List<Package> packages, Address address,
			Address billingAddress) {
		super();
		this.userId = userId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.passwordHash = passwordHash;
		this.email = email;
		this.phoneNumbers = phoneNumbers;
		this.created = created;
		this.packages = packages;
		this.address = address;
		this.billingAddress = billingAddress;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
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
	public String getPasswordHash() {
		return passwordHash;
	}
	public void setPasswordHash(String passwordHash) {
		this.passwordHash = passwordHash;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public List<String> getPhoneNumbers() {
		return phoneNumbers;
	}
	public void setPhoneNumbers(List<String> phoneNumbers) {
		this.phoneNumbers = phoneNumbers;
	}
	public LocalDateTime getCreated() {
		return created;
	}
	public void setCreated(LocalDateTime created) {
		this.created = created;
	}
	public List<Package> getPackages() {
		return packages;
	}
	public void setPackages(List<Package> packages) {
		this.packages = packages;
	}
	public Address getAddress() {
		return address;
	}
	public void setAddress(Address address) {
		this.address = address;
	}
	public Address getBillingAddress() {
		return billingAddress;
	}
	public void setBillingAddress(Address billingAddress) {
		this.billingAddress = billingAddress;
	}
	@Override
	public int hashCode() {
		return Objects.hash(address, billingAddress, created, email, firstName, lastName, packages, passwordHash,
				phoneNumbers, userId);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (!(obj instanceof User)) {
			return false;
		}
		User other = (User) obj;
		return Objects.equals(address, other.address) && Objects.equals(billingAddress, other.billingAddress)
				&& Objects.equals(created, other.created) && Objects.equals(email, other.email)
				&& Objects.equals(firstName, other.firstName) && Objects.equals(lastName, other.lastName)
				&& Objects.equals(packages, other.packages) && Objects.equals(passwordHash, other.passwordHash)
				&& Objects.equals(phoneNumbers, other.phoneNumbers) && Objects.equals(userId, other.userId);
	}
	@Override
	public String toString() {
		return "User [userId=" + userId + ", firstName=" + firstName + ", lastName=" + lastName + ", passwordHash="
				+ passwordHash + ", email=" + email + ", phoneNumbers=" + phoneNumbers + ", created=" + created
				+ ", packages=" + packages + ", address=" + address + ", billingAddress=" + billingAddress + "]";
	}
	
	
	
	
	
	

}
