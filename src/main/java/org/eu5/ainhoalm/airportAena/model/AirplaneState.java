package org.eu5.ainhoalm.airportAena.model;

import java.io.Serializable;

public class AirplaneState implements Serializable{
	private static final long serialVersionUID = 1L;
	
	private Long id;
	private int code;
	private String description;
	
	public Long getId() {return id;}
	@SuppressWarnings("unused")
	private void setId(Long id) {this.id = id;}


	public int getCode() {return code;}
	public void setCode(int code) {this.code = code;}
	
	public String getDescription() {return description;}
	public void setDescription(String description) {this.description = description;}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + code;
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
		AirplaneState other = (AirplaneState) obj;
		if (code != other.code)
			return false;
		if (description == null) {
			if (other.description != null)
				return false;
		} else if (!description.equals(other.description))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "AirplaneState [id=" + id + ", code=" + code + ", description="
				+ description + "]";
	}
	
	
	

}
