package org.eu5.ainhoalm.airportAena.model;

import java.io.Serializable;
import java.util.List;
import java.util.Set;

import org.eu5.ainhoalm.airportAena.model.annotation.Company;




public class Airport implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	private Long id;
	private String icao;
	private String description;
	private Integer nGates;
	private List<AirportGates> gates;
	
	
	public Long getId() {return id;}
	@SuppressWarnings("unused")
	private void setId(Long id) {this.id = id;}
	
	public String getIcao() {return icao;}
	public void setIcao(String icao) {this.icao = icao;}
	
	public String getDescription() {return description;}
	public void setDescription(String description) {this.description = description;}
	
	public Integer getnGates() {return nGates;}
	public void setnGates(Integer nGates) {this.nGates = nGates;}
	
	protected List<AirportGates> getGates() {return gates;}
	protected void setGates(List<AirportGates> gates) {this.gates = gates;}
	

	@Override
	public String toString() {
		return "Airport [id=" + id + ", icao=" + icao + ", description="
				+ description + ", nGates=" + nGates + ", gates=" + gates + "]";
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((icao == null) ? 0 : icao.hashCode());
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
		if (description == null) {
			if (other.description != null)
				return false;
		} else if (!description.equals(other.description))
			return false;
		if (gates == null) {
			if (other.gates != null)
				return false;
		} else if (!gates.equals(other.gates))
			return false;
		if (icao == null) {
			if (other.icao != null)
				return false;
		} else if (!icao.equals(other.icao))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (nGates == null) {
			if (other.nGates != null)
				return false;
		} else if (!nGates.equals(other.nGates))
			return false;
		return true;
	}
	
	
	
	

}
