/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Bean;

import Command.CommandFactory;
import DTO.FlightDTO;
import DTO.RouteDTO;
import java.sql.Timestamp;
import java.util.Calendar;
import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Named;

/**
 *
 * @author Kayde
 */
@Named(value = "addFlightBean")
@RequestScoped
public class AddFlightBean {
    //private int flightID;
    //private RouteDTO route;
    //private Calendar departureDateTime;
    //private String status;
    private int routeID;
    private Timestamp departureDateTime, arrivalDateTime;
    private String status;

    public void setRouteID(int routeID) {
        this.routeID = routeID;
    }

    public void setDepartureDateTime(Timestamp departureDateTime) {
        this.departureDateTime = departureDateTime;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public int getRouteID() {
        return routeID;
    }

    public Timestamp getDepartureDateTime() {
        return departureDateTime;
    }

    public String getStatus() {
        return status;
    }

    public Timestamp getArrivalDateTime() {
        return arrivalDateTime;
    }

    public void setArrivalDateTime(Timestamp arrivalDateTime) {
        this.arrivalDateTime = arrivalDateTime;
    }

    public String addFlight(){
        
        if(arrivalDateTime.before(departureDateTime)){
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Arrival is before Departure!"));
            return "";
        }
        
        FlightDTO flight = new FlightDTO(new RouteDTO(routeID), departureDateTime, arrivalDateTime, status);
        CommandFactory.createCommand(CommandFactory.ADD_FLIGHT, flight).execute();
        return "/index.xhtml";
    }
}
