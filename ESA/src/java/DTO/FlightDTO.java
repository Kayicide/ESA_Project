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
    
    public FlightDTO(int FlightID, RouteDTO route, Calendar depatureDateTime, String status){
        
    }
    
}
