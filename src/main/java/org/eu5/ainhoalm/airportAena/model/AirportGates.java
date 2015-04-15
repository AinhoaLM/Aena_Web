package org.eu5.ainhoalm.airportAena.model;

import java.io.Serializable;

public class AirportGates implements Serializable{
	private static final long serialVersionUID = 1L;
	
	private Long id;
	private String code;
	private Boolean status;
	private Airport airport;
	
	public Long getId() {return id;}
	@SuppressWarnings("unused")
	private void setId(Long id) {this.id = id;}
	
	public String getCode() {return code;}
	public void setCode(String code) {this.code = code;}
	
	public Boolean getStatus() {return status;}
	public void setStatus(Boolean status) {this.status = status;}
	
	protected Airport getAirport() {return airport;}
	protected void setAirport(Airport aiport) {this.airport = aiport;}
	
	
	
	@Override
	public String toString() {
		return "AirportGates [id=" + id + ", code=" + code + ", status="
				+ status + ", airport=" + airport.getDescription() + "]";
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((airport == null) ? 0 : airport.hashCode());
		result = prime * result + ((code == null) ? 0 : code.hashCode());
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
		AirportGates other = (AirportGates) obj;
		if (airport == null) {
			if (other.airport != null)
				return false;
		} else if (!airport.equals(other.airport))
			return false;
		if (code == null) {
			if (other.code != null)
				return false;
		} else if (!code.equals(other.code))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	
	
	

}
