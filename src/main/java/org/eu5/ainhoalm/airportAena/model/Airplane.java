package org.eu5.ainhoalm.airportAena.model;

import java.io.Serializable;

public class Airplane implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private Long id;
	private String registration;
	private String model;
	private String msn;
	private int nSeats;
	private AirplaneState state;
	private Integer idCompany;
	
	public Long getId() {return id;}
	@SuppressWarnings("unused")
	private void setId(Long id) {this.id = id;}

	public String getRegistration() {return registration;}
	public void setRegistration(String registration) {this.registration = registration;}
	
	public String getModel() {return model;}
	public void setModel(String model) {this.model = model;}
	
	public String getMsn() {return msn;}
	public void setMsn(String msn) {this.msn = msn;}
	
	public int getnSeats() {return nSeats;}
	public void setnSeats(int nSeats) {this.nSeats = nSeats;}
	
	public AirplaneState getState() {return state;}
	public void setState(AirplaneState state) {this.state = state;}
	
	public Integer getIdCompany() {return idCompany;}
	public void setIdCompany(Integer idCompany) {this.idCompany = idCompany;}
		
	
	@Override
	public String toString() {
		return "Airplane [id=" + id + ", registration=" + registration
				+ ", model=" + model + ", msn=" + msn + ", nSeats=" + nSeats
				+ ", state=" + state + ", idCompany=" + idCompany + "]";
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result
				+ ((registration == null) ? 0 : registration.hashCode());
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
		Airplane other = (Airplane) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (idCompany == null) {
			if (other.idCompany != null)
				return false;
		} else if (!idCompany.equals(other.idCompany))
			return false;
		if (model == null) {
			if (other.model != null)
				return false;
		} else if (!model.equals(other.model))
			return false;
		if (msn == null) {
			if (other.msn != null)
				return false;
		} else if (!msn.equals(other.msn))
			return false;
		if (nSeats != other.nSeats)
			return false;
		if (registration == null) {
			if (other.registration != null)
				return false;
		} else if (!registration.equals(other.registration))
			return false;
		if (state == null) {
			if (other.state != null)
				return false;
		} else if (!state.equals(other.state))
			return false;
		return true;
	}
	
	
	
	
	
	
	
	

}
