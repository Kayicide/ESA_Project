/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Bean;

import Command.CommandFactory;
import DTO.AirportDTO;
import DTO.PlaneDTO;
import DTO.RouteDTO;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

/**
 *
 * @author Kayde
 */
@Named(value = "addRouteBean")
@RequestScoped
public class AddRouteBean {
    //private int routeID;
    //private AirportDTO destination;
    //private AirportDTO departureAirport;
    //private PlaneDTO plane;
    
    private String airport1ID, airport2ID;
    private int planeID;

    public String getAirport1ID() {
        return airport1ID;
    }

    public String getAirport2ID() {
        return airport2ID;
    }

    public int getPlaneID() {
        return planeID;
    }

    public void setAirport1ID(String airport1ID) {
        this.airport1ID = airport1ID;
    }

    public void setAirport2ID(String airport2ID) {
        this.airport2ID = airport2ID;
    }

    public void setPlaneID(int planeID) {
        this.planeID = planeID;
    }
    
    public String addRoute(){
        RouteDTO route = new RouteDTO(new AirportDTO(airport1ID), new AirportDTO(airport2ID), new PlaneDTO(planeID));
        CommandFactory.createCommand(CommandFactory.ADD_ROUTE, route).execute();
        return "index.xhtml";
    }
}
