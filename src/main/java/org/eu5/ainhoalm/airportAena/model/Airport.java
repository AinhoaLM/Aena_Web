package org.eu5.ainhoalm.airportAena.model;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;


public class Airport implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	private Long id;
	private String icao;
	private String description;
	private Integer nGates;
	private Set<AirportGates> gates;
	private String country;
	
	
	
	public Airport() {
		this.gates= new HashSet<AirportGates>();
	}
	
	public Long getId() {return id;}
	@SuppressWarnings("unused")
	private void setId(Long id) {this.id = id;}
	
	public String getIcao() {return icao;}
	public void setIcao(String icao) {this.icao = icao;}
	
	public String getDescription() {return description;}
	public void setDescription(String description) {this.description = description;}
	
	public Integer getnGates() {return nGates;}
	public void setnGates(Integer nGates) {this.nGates = nGates;}
	
	protected Set<AirportGates> getGates() {return gates;}
	protected void setGates(Set<AirportGates> gates) {this.gates = gates;}
	
	public void addToGates(AirportGates gates) {
		if (gates != null) {
			this.gates.add(gates);
			gates.setAirport(this);
		}
	}
	
	public void removeFromGates(AirportGates gates) {
		if (gates != null) {
			this.gates.remove(gates);
			gates.setAirport(null);
		}
	}
	
	public Set<AirportGates> obtainGates() {return gates;}
	
	public String getCountry() {return country;}
	public void setCountry(String country) {this.country = country;}
	
	
	
	@Override
	public String toString() {
		return "Airport [id=" + id + ", icao=" + icao + ", description="
				+ description + ", nGates=" + nGates + ", gates=" + gates
				+ ", country=" + country + "]";
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
		Airport other = (Airport) obj;
		if (icao == null) {
			if (other.icao != null)
				return false;
		} else if (!icao.equals(other.icao))
			return false;
		return true;
	}
	
	
	
	
	
	
	
	
	

}
