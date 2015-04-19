package org.eu5.ainhoalm.airportAena.model;

import java.io.Serializable;
import java.util.Date;
import java.util.Set;

public class Flight implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private Long id;
	private String Code;
	private Long idAirportO;
	private Long idAirportD;
	private Long idAirplane;
	private Long idCompany;
	private Date date;
	private Date DepartureTime;
	private Date ArrivalTime;
	private Set<BoardingPass> boardingPass;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getCode() {
		return Code;
	}
	public void setCode(String code) {
		Code = code;
	}
	public Long getIdAirportO() {
		return idAirportO;
	}
	public void setIdAirportO(Long idAirportO) {
		this.idAirportO = idAirportO;
	}
	public Long getIdAirportD() {
		return idAirportD;
	}
	public void setIdAirportD(Long idAirpotD) {
		this.idAirportD = idAirpotD;
	}
	public Long getIdAirplane() {
		return idAirplane;
	}
	public void setIdAirplane(Long idAirplane) {
		this.idAirplane = idAirplane;
	}
	public Long getIdCompany() {
		return idCompany;
	}
	public void setIdCompany(Long idCompany) {
		this.idCompany = idCompany;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public Date getDepartureTime() {
		return DepartureTime;
	}
	public void setDepartureTime(Date departureTime) {
		DepartureTime = departureTime;
	}
	public Date getArrivalTime() {
		return ArrivalTime;
	}
	public void setArrivalTime(Date arrivalTime) {
		ArrivalTime = arrivalTime;
	}
	
	
	public Set<BoardingPass> getBoardingPass() {
		return boardingPass;
	}
	public void setBoardingPass(Set<BoardingPass> boardingPass) {
		this.boardingPass = boardingPass;
	}
	
	@Override
	public String toString() {
		return "Flight [id=" + id + ", Code=" + Code + ", idAirportO="
				+ idAirportO + ", idAirportD=" + idAirportD + ", idAirplane="
				+ idAirplane + ", idCompany=" + idCompany + ", date=" + date
				+ ", DepartureTime=" + DepartureTime + ", ArrivalTime="
				+ ArrivalTime + ", boardingPass=" + boardingPass + "]";
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
		Flight other = (Flight) obj;
		if (Code == null) {
			if (other.Code != null)
				return false;
		} else if (!Code.equals(other.Code))
			return false;
		return true;
	}
	
	
	
	

}
