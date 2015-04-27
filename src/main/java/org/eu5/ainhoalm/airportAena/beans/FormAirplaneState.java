package org.eu5.ainhoalm.airportAena.beans;

import java.io.Serializable;
import java.util.List;



import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import org.eu5.ainhoalm.airportAena.model.AirplaneState;
import org.eu5.ainhoalm.airportAena.service.AirplaneStateService;
import org.springframework.context.ApplicationContext;
import org.springframework.web.jsf.FacesContextUtils;


@ManagedBean
@SessionScoped
public class FormAirplaneState implements Serializable {
	
	private static final long serialVersionUID = 1L;
	private int code;
	private String description;
	private List<AirplaneState> listOfAriplaneState;
	
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
	
	@PostConstruct
	public void iniciar() {
	listOfAriplaneState = getServiceAirplaneSate().findAllAirplaneState();
	}
	
	public AirplaneStateService getServiceAirplaneSate() {
		ApplicationContext contexto = FacesContextUtils.getWebApplicationContext(FacesContext.getCurrentInstance());
		return (AirplaneStateService) contexto.getBean("airplaneStateSERVICE");
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
		getServiceAirplaneSate().airplaneStateSave(as);
		setListOfAriplaneState(getServiceAirplaneSate().findAllAirplaneState());
		return "airplanestateShow";
	}
	
	public void moveToDeleteAction(AirplaneState airplaneState){
		getServiceAirplaneSate().airplaneStateDelete(airplaneState);
		setListOfAriplaneState(getServiceAirplaneSate().findAllAirplaneState());
		
	}
	
	public void moveToEditAction(AirplaneState airplaneState){
		getServiceAirplaneSate().airplaneStateDelete(airplaneState);
		setListOfAriplaneState(getServiceAirplaneSate().findAllAirplaneState());
		
	}

}