/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DTO;

/**
 *
 * @author Kayde
 */
public class RouteDTO {
    private int routeID;
    private AirportDTO destination;
    private AirportDTO departureAirport;
    private PlaneDTO plane;
    public RouteDTO(int routeID, AirportDTO destination, AirportDTO departureAirport, PlaneDTO plane){
        this.routeID = routeID;
        this.destination = destination;
        this.departureAirport = departureAirport;
        this.plane = plane;
    }
    
    public RouteDTO(AirportDTO destination, AirportDTO departureAirport, PlaneDTO plane){
        this.routeID = routeID;
        this.destination = destination;
        this.departureAirport = departureAirport;
        this.plane = plane;
    }
    
    public RouteDTO(int routeID){
        this.routeID = routeID;
    }

    public int getRouteID() {
        return routeID;
    }

    public AirportDTO getDestination() {
        return destination;
    }

    public AirportDTO getDepartureAirport() {
        return departureAirport;
    }

    public void setRouteID(int routeID) {
        this.routeID = routeID;
    }

    public void setDestination(AirportDTO destination) {
        this.destination = destination;
    }

    public void setDepartureAirport(AirportDTO departureAirport) {
        this.departureAirport = departureAirport;
    }

    public PlaneDTO getPlane() {
        return plane;
    }

    public void setPlane(PlaneDTO plane) {
        this.plane = plane;
    }
    
}