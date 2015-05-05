package org.eu5.ainhoalm.airportAena.model.annotation;


import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.NaturalId;

@Entity
@Table
public class Company implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private String name;
	@NaturalId
	private String licenseCode;
	private Date concessionDate;
	private Date expirationDate;

	public Long getId() {return id;}
	@SuppressWarnings("unused")
	private void setId(Long id) {this.id = id;}
	
	public String getName() {return name;}
	public void setName(String name) {this.name = name;}
	
	public String getLicenseCode() {return licenseCode;}
	public void setLicenseCode(String licenseCode) {this.licenseCode = licenseCode;}
	
	public Date getConcessionDate() {return concessionDate;}
	public void setConcessionDate(Date concessionDate) {this.concessionDate = concessionDate;}
	
	public Date getExpirationDate() {return expirationDate;}
	public void setExpirationDate(Date expirationDate) {this.expirationDate = expirationDate;}
	@Override
	public String toString() {
		return "Company [id=" + id + ", name=" + name + ", licenseCode="
				+ licenseCode + ", concessionDate=" + concessionDate
				+ ", expirationDate=" + expirationDate + "]";
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result
				+ ((licenseCode == null) ? 0 : licenseCode.hashCode());
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
		if (concessionDate == null) {
			if (other.concessionDate != null)
				return false;
		} else if (!concessionDate.equals(other.concessionDate))
			return false;
		if (expirationDate == null) {
			if (other.expirationDate != null)
				return false;
		} else if (!expirationDate.equals(other.expirationDate))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
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
