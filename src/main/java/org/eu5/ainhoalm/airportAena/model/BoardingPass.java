package org.eu5.ainhoalm.airportAena.model;

import java.io.Serializable;
import java.util.Date;

public class BoardingPass implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private Long id;
	private String code;
	private Long idFlight;
	private Integer seat;
	private String dni;
	private String name;
	private String firstname;
	private Date birthday;
	private Boolean boarded;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public Long getIdFlight() {
		return idFlight;
	}
	public void setIdFlight(Long idFlight) {
		this.idFlight = idFlight;
	}
	public Integer getSeat() {
		return seat;
	}
	public void setSeat(Integer seat) {
		this.seat = seat;
	}
	public String getDni() {
		return dni;
	}
	public void setDni(String dni) {
		this.dni = dni;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getFirstname() {
		return firstname;
	}
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}
	public Date getBirthday() {
		return birthday;
	}
	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}
	public Boolean getBoarded() {
		return boarded;
	}
	public void setBoarded(Boolean boarded) {
		this.boarded = boarded;
	}
	@Override
	public String toString() {
		return "BoardingPass [id=" + id + ", code=" + code + ", idFlight="
				+ idFlight + ", seat=" + seat + ", dni=" + dni + ", name="
				+ name + ", firstname=" + firstname + ", birthday=" + birthday
				+ ", boarded=" + boarded + "]";
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
		BoardingPass other = (BoardingPass) obj;
		if (code == null) {
			if (other.code != null)
				return false;
		} else if (!code.equals(other.code))
			return false;
		if (dni == null) {
			if (other.dni != null)
				return false;
		} else if (!dni.equals(other.dni))
			return false;
		return true;
	}
	
	
	
	
}
