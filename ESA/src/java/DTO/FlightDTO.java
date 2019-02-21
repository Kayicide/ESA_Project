/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DTO;

import java.util.Calendar;

/**
 *
 * @author Kayde
 */
public class FlightDTO {
    private int flightID;
    private RouteDTO route;
    private Calendar departureDateTime;
    private String status;
    
    public FlightDTO(int flightID, RouteDTO route, Calendar departureDateTime, String status){
        this.flightID = flightID;
        this.route = route;
        this.departureDateTime = departureDateTime;
        this.status = status;
    }

    public int getFlightID() {
        return flightID;
    }

    public RouteDTO getRoute() {
        return route;
    }

    public Calendar getDepartureDateTime() {
        return departureDateTime;
    }

    public String getStatus() {
        return status;
    }

    public void setFlightID(int flightID) {
        this.flightID = flightID;
    }

    public void setRoute(RouteDTO route) {
        this.route = route;
    }

    public void setDepartureDateTime(Calendar departureDateTime) {
        this.departureDateTime = departureDateTime;
    }

    public void setStatus(String status) {
        this.status = status;
    }   
}
