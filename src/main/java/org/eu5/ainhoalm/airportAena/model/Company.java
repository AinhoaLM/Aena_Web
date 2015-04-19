package org.eu5.ainhoalm.airportAena.model;

import java.io.Serializable;
import java.util.Date;

public class Company implements Serializable{
	private static final long serialVersionUID = 1L;
	
	private Long id;
	private String licenseCode;
	private String name;
	private Date expirationDate;
	private Date concessionDate;
	public Long getId() {
		return id;
	}
	@SuppressWarnings("unused")
	private void setId(Long id) {
		this.id = id;
	}
	public String getLicenseCode() {
		return licenseCode;
	}
	public void setLicenseCode(String licenseCode) {
		this.licenseCode = licenseCode;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Date getExpirationDate() {
		return expirationDate;
	}
	public void setExpirationDate(Date expirationDate) {
		this.expirationDate = expirationDate;
	}
	public Date getConcessionDate() {
		return concessionDate;
	}
	public void setConcessionDate(Date concessionDate) {
		this.concessionDate = concessionDate;
	}
	
	
	@Override
	public String toString() {
		return "Company [id=" + id + ", licenseCode=" + licenseCode + ", name="
				+ name + ", expirationDate=" + expirationDate
				+ ", concessionDate=" + concessionDate + "]";
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Company other = (Company) obj;
		if (licenseCode == null) {
			if (other.licenseCode != null)
				return false;
		} else if (!licenseCode.equals(other.licenseCode))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}
	
	
	

}
