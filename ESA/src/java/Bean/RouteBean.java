/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Bean;

import Command.CommandFactory;
import DTO.FlightDTO;
import DTO.RouteDTO;
import java.io.Serializable;
import java.util.ArrayList;
import javax.enterprise.context.RequestScoped;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

/**
 *
 * @author Kayde
 */
@Named(value = "routeBean")
@SessionScoped
public class RouteBean implements Serializable{
    public RouteDTO getRouteDetails(int id){
        return (RouteDTO)CommandFactory.createCommand(CommandFactory.GET_ROUTE, id).execute();
    }
        
    public ArrayList<RouteDTO>getAllRoutes(){
        return (ArrayList<RouteDTO>)CommandFactory.createCommand(CommandFactory.GET_ALL_ROUTES).execute();
    }
    
    public void deleteRoute(int id){
        CommandFactory.createCommand(CommandFactory.DELETE_ROUTE, id).execute();
    }
}
