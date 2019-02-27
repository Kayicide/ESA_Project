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
               break;
            case BOOKING_MANAGER: 
               break;
            case FLIGHT_MANAGER: 
               break;
            case PLANE_MANAGER: 
               break;
            case ROUTE_MANAGER: 
               break;
            case USER_MANAGER: 
               break;
            default:
               break;
        }
        return null;
    }
}
