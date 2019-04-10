/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Bean;

import Command.CommandFactory;
import DTO.FlightDTO;
import DTO.RouteDTO;
import java.util.Calendar;
import javax.enterprise.context.RequestScoped;
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
    private Calendar departureDateTime;
    private String status;

    public void setRouteID(int routeID) {
        this.routeID = routeID;
    }

    public void setDepartureDateTime(Calendar departureDateTime) {
        this.departureDateTime = departureDateTime;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public int getRouteID() {
        return routeID;
    }

    public Calendar getDepartureDateTime() {
        return departureDateTime;
    }

    public String getStatus() {
        return status;
    }
    
    public String addFlight(){
        FlightDTO flight = new FlightDTO(new RouteDTO(routeID), departureDateTime, status);
        CommandFactory.createCommand(CommandFactory.ADD_FLIGHT, flight).execute();
        return "home";
    }
}
