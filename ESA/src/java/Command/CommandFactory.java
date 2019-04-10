/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Command;

import DTO.FlightDTO;
import DTO.RouteDTO;
import DTO.UserDTO;
import Manager.ManagerFactory;

/**
 *
 * @author Kayde
 */
public class CommandFactory {
    static final ManagerFactory managerFactory = new ManagerFactory();
    //Login/Register
    public static final int REGISTER_USER = 1;
    public static final int LOGIN = 2;
    
    //Flight
    public static final int GET_ALL_FLIGHTS = 3;
    public static final int GET_FLIGHT = 4;
    public static final int ADD_FLIGHT = 5;
    public static final int DELETE_FLIGHT = 6;
    
    //Route
    public static final int GET_ALL_ROUTES = 7;
    public static final int GET_ROUTE = 8;
    public static final int ADD_ROUTE = 9;
    public static final int DELETE_ROUTE = 10;
    
    //Airport
    public static final int GET_ALL_AIRPORTS = 11;
    
    //Plane
    public static final int GET_ALL_PLANES = 12;

    public static Command createCommand(int commandType) {
        switch (commandType) {
            case GET_ALL_FLIGHTS:
                return new GetAllFlights();
            case GET_ALL_ROUTES:
                return new GetAllRoutes();
            case GET_ALL_PLANES:
                return new GetAllPlanes();
            case GET_ALL_AIRPORTS:
                return new GetAllAirports();
            default:
                return null;
        }
    }
    
    public static Command createCommand(int commandType, int id) {
        switch (commandType) {
            case GET_FLIGHT:
                return new GetFlight(id);
            case DELETE_FLIGHT:
                return new DeleteFlight(id);
            case GET_ROUTE:
                return new GetRoute(id);
            default:
                return null;
        }
    }
    
    public static Command createCommand(int commandType, UserDTO user) {
        switch (commandType) {
            case LOGIN:
                return new Login(user);
            case REGISTER_USER:
                return new Register(user);
            default:
                return null;
        }
    }
    
    public static Command createCommand(int commandType, FlightDTO flight) {
        switch (commandType) {
            case ADD_FLIGHT:
                return new InsertFlight(flight);
            default:
                return null;
        }
    }
    public static Command createCommand(int commandType, RouteDTO route) {
        switch (commandType) {
            case ADD_ROUTE:
                return new InsertRoute(route);
            default:
                return null;
        }
    }
}
