/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Command;

import DTO.FlightDTO;
import DTO.UserDTO;
import Manager.ManagerFactory;

/**
 *
 * @author Kayde
 */
public class CommandFactory {
    static final ManagerFactory managerFactory = new ManagerFactory();
    //Basic
    public static final int REGISTER_USER = 1;
    public static final int LOGIN = 2;
    public static final int GET_ALL_FLIGHTS = 3;
    public static final int GET_FLIGHT = 4;
    public static final int DELETE_FLIGHT = 12;
    public static final int GET_ALL_ROUTES = 13;

    //User only
    public static final int BOOK_FLIGHT = 5;
    public static final int UPDATE_BOOKING = 6;
    public static final int CANCEL_FLIGHT = 7;
    public static final int VIEW_BOOKINGS = 8;

    //Admin only
    public static final int VIEW_USERS = 9;
    public static final int SEARCH_USERS = 10;
    public static final int ADD_FLIGHT = 11;

    public static Command createCommand(int commandType) {
        switch (commandType) {
            case GET_ALL_FLIGHTS:
                return new GetAllFlights();
            case GET_ALL_ROUTES:
                return new GetAllRoutes();
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
}
