package org.eu5.ainhoalm.airportAena.model;

import java.io.Serializable;

public class AirportGates implements Serializable{
	private static final long serialVersionUID = 1L;
	
	private Long id;
	private String code;
	private Boolean status;
	private Airport airport;
	private Long idAirplane;
	
	public Long getId() {return id;}
	@SuppressWarnings("unused")
	private void setId(Long id) {this.id = id;}
	
	public String getCode() {return code;}
	public void setCode(String code) {this.code = code;}
	
	public Boolean getStatus() {return status;}
	public void setStatus(Boolean status) {this.status = status;}
	
	protected Airport getAirport() {return airport;}
	protected void setAirport(Airport aiport) {this.airport = aiport;}
	
	public Long getIdAirplane() {return idAirplane;}
	public void setIdAirplane(Long idAirplane) {this.idAirplane = idAirplane;}
	
	public void addToAirport(Airport airport) {
		if (airport != null) {
			this.setAirport(airport);
			airport.getGates().add(this);
		}
	}
	
	public void removeFromAirport(Airport airport) {
		if (airport != null) {
			this.setAirport(null);
			airport.getGates().remove(airport);
		}
	}
	
	@Override
	public String toString() {
		return "AirportGates [id=" + id + ", code=" + code + ", status="
				+ status + ", airport=" + airport.getDescription() + "airplane=" + idAirplane+"]";
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
		return true;
	}
	
	
	

}
