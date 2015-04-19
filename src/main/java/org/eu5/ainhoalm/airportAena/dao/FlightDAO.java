package org.eu5.ainhoalm.airportAena.dao;

import java.util.List;

import org.eu5.ainhoalm.airportAena.model.BoardingPass;
import org.eu5.ainhoalm.airportAena.model.Flight;



public interface FlightDAO extends GenericDAO<Flight, Long> {
	public abstract List<BoardingPass> reservedSeats(Long idAirplane);
	public abstract List<BoardingPass> boardedSeats(Long idAirplane);
	public abstract Integer numberOfReservedSeats(Long idAirplane);
	public abstract Integer numberOfBoardedSeats(Long idAirplane);
	

}
