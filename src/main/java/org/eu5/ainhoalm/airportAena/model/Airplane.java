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
	
	@Override
	public String toString() {
		return "Airplane [id=" + id + ", registration=" + registration
				+ ", model=" + model + ", msn=" + msn + ", nSeats=" + nSeats
				+ ", state=" + state + "]";
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
		Airplane other = (Airplane) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	
	
	
	
	

}
