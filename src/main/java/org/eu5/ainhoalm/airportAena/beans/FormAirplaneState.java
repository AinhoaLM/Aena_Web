package org.eu5.ainhoalm.airportAena.beans;

import java.io.Serializable;
import java.util.List;








import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;




import org.eu5.ainhoalm.airportAena.model.AirplaneState;
import org.eu5.ainhoalm.airportAena.service.AirplaneStateService;



@ManagedBean
@SessionScoped
public class FormAirplaneState implements Serializable {
	
	private static final long serialVersionUID = 1L;
	private int code;
	private String description;
	private List<AirplaneState> listOfAriplaneState;
	
	//Inyectar el servicio Spring con anotación
	@ManagedProperty("#{airplaneStateSERVICE}")
	private AirplaneStateService airplaneStateService;
	

	public AirplaneStateService getAirplaneStateService() {
		return airplaneStateService;
	}
	public void setAirplaneStateService(AirplaneStateService airplaneStateService) {
		this.airplaneStateService = airplaneStateService;
	}
	
	public int getCode() {
		return code;
	}
	public void setCode(int code) {
		this.code = code;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public List<AirplaneState> getListOfAriplaneState() {
		return listOfAriplaneState;
	}
	public void setListOfAriplaneState(List<AirplaneState> listOfAriplaneState) {
		this.listOfAriplaneState = listOfAriplaneState;
	}
	
	//Método a ejecutar una vez iniciado el ManageBean
	@PostConstruct
	public void iniciar() {
	listOfAriplaneState = airplaneStateService.findAllAirplaneState();
	}
	
	
	public String moveToAddAction() {	
		this.code=0;
		this.description="";
		return "airplanestateInsert";
	}
	
	public String insert(){
		AirplaneState as= new AirplaneState();
		as.setCode(code);
		as.setDescription(description);
		airplaneStateService.airplaneStateSave(as);
		setListOfAriplaneState(airplaneStateService.findAllAirplaneState());
		return "airplanestateShow";
	}
	
	public void moveToDeleteAction(AirplaneState airplaneState){
		airplaneStateService.airplaneStateDelete(airplaneState);
		setListOfAriplaneState(airplaneStateService.findAllAirplaneState());
		
	}
	
	public void moveToEditAction(AirplaneState airplaneState){
		airplaneStateService.airplaneStateDelete(airplaneState);
		setListOfAriplaneState(airplaneStateService.findAllAirplaneState());
		
	}

}
