/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DTO;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Calendar;

/**
 *
 * @author Kayde
 */
public class FlightDTO implements Serializable {
    private int flightID;
    private RouteDTO route;
    private Timestamp departureDateTime, arrivalDateTime;
    private String status;
    
    public FlightDTO(int flightID, RouteDTO route, Timestamp departureDateTime, Timestamp arrivalDateTime, String status){
        this.flightID = flightID;
        this.route = route;
        this.departureDateTime = departureDateTime;
        this.arrivalDateTime = arrivalDateTime;
        this.status = status;
    }
    public FlightDTO(int flightID, RouteDTO route, Timestamp departureDateTime, Timestamp arrivalDateTime){
        this.flightID = flightID;
        this.route = route;
        this.departureDateTime = departureDateTime;
        this.arrivalDateTime = arrivalDateTime;
    }
    public FlightDTO(RouteDTO route, Timestamp departureDateTime, Timestamp arrivalDateTime, String status){
        this.route = route;
        this.departureDateTime = departureDateTime;
        this.arrivalDateTime = arrivalDateTime;
        this.status = status;
    }

    public int getFlightID() {
        return flightID;
    }

    public RouteDTO getRoute() {
        return route;
    }

    public Timestamp getDepartureDateTime() {
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

    public void setDepartureDateTime(Timestamp departureDateTime) {
        this.departureDateTime = departureDateTime;
    }

    public void setStatus(String status) {
        this.status = status;
    }   

    public Timestamp getArrivalDateTime() {
        return arrivalDateTime;
    }

    public void setArrivalDateTime(Timestamp arrivalDateTime) {
        this.arrivalDateTime = arrivalDateTime;
    }
    
    
}
