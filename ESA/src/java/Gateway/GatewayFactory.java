/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Gateway;

/**
 *
 * @author kayde
 */
public class GatewayFactory {
    public static final int AIRPORT_GATEWAY = 1;
    public static final int BOOKING_GATEWAY = 2;
    public static final int FLIGHT_GATEWAY = 3;
    public static final int PLANE_GATEWAY = 4;
    public static final int ROUTE_GATEWAY = 5;
    public static final int USER_GATEWAY = 6;
                    
    public GatewayAbstract create(int type){
        switch(type){
            case AIRPORT_GATEWAY: 
               return new AirportGateway();
            case BOOKING_GATEWAY: 
               return new BookingGateway();
            case FLIGHT_GATEWAY: 
               return new FlightGateway();
            case PLANE_GATEWAY: 
               return new PlaneGateway();
            case ROUTE_GATEWAY: 
               return new RouteGateway();
            case USER_GATEWAY: 
               return new UserGateway();
            default:
               return null;
        }
    }
}
