/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Manager;

import Gateway.GatewayAbstract;

/**
 *
 * @author kayde
 */
public class ManagerFactory {
    public static final int AIRPORT_MANAGER = 1;
    public static final int BOOKING_MANAGER = 2;
    public static final int FLIGHT_MANAGER = 3;
    public static final int PLANE_MANAGER = 4;
    public static final int ROUTE_MANAGER = 5;
    public static final int USER_MANAGER = 6;
    
                    
    public ManagerAbstract create(int type){
        switch(type){
            case AIRPORT_MANAGER: 
               return new AirportManager();
            case BOOKING_MANAGER: 
               return new BookingManager();
            case FLIGHT_MANAGER: 
               return new FlightManager();
            case PLANE_MANAGER: 
               return new PlaneManager();
            case ROUTE_MANAGER: 
               return new RouteManager();
            case USER_MANAGER: 
               return new UserManager();
            default:
               break;
        }
        return null;
    }
}
