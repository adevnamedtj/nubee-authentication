package com.tejio.oj.nubee.authentication.model;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;

public class Package {
	
	private String packageId;
	private String name;
	private List<String> policyIds;
	private LocalDateTime created;
	
	public Package() {
		super();
	}

	
	public Package(String packageId, String name, List<String> policyIds, LocalDateTime created) {
		super();
		this.packageId = packageId;
		this.name = name;
		this.policyIds = policyIds;
		this.created = created;
	}


	public Package(String packageId, String name, List<String> policyIds,String arg) {
		super();
		this.packageId = packageId;
		this.name = name;
		this.policyIds = policyIds;
		this.created = LocalDateTime.now();
	}


	public String getPackageId() {
		return packageId;
	}


	public void setPackageId(String packageId) {
		this.packageId = packageId;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public List<String> getPolicyIds() {
		return policyIds;
	}


	public void setPolicyIds(List<String> policyIds) {
		this.policyIds = policyIds;
	}


	public LocalDateTime getCreated() {
		return created;
	}


	public void setCreated(LocalDateTime created) {
		this.created = created;
	}


	@Override
	public int hashCode() {
		return Objects.hash(created, name, packageId, policyIds);
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (!(obj instanceof Package)) {
			return false;
		}
		Package other = (Package) obj;
		return Objects.equals(created, other.created) && Objects.equals(name, other.name)
				&& Objects.equals(packageId, other.packageId) && Objects.equals(policyIds, other.policyIds);
	}


	@Override
	public String toString() {
		return "Package [packageId=" + packageId + ", name=" + name + ", policyIds=" + policyIds + ", created="
				+ created + "]";
	}
	
	
	

}
