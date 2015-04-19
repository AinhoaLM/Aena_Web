package org.eu5.ainhoalm.airportAena.service;

import java.util.Date;


public interface FlightManagementService {
	public void createFlight(Long idAirplane,Long idCompany, Date fecha, Date departureTime, Date arrivalTime);
	public void purchaseBoardingPass(Long idFlight, String dni, String name, String firstName, Date birthday);
	public void ship();
	public void land();

}


