/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Gateway;

import DTO.FlightDTO;
import DTO.RouteDTO;
import java.sql.Connection;
import java.util.ArrayList;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Calendar;

/**
 *
 * @author Kayde
 */
public class FlightGateway extends GatewayAbstract{

    private Connection conn;
       
    public boolean insert(FlightDTO flight){
        boolean added = false;
        
        try
        {
            conn = database.getConnection();
            
            String sqlSt = "// SQL //";
            PreparedStatement stmt = conn.prepareStatement(sqlSt);
            
            stmt.setInt(1, flight.getFlightID());
            RouteDTO route = flight.getRoute();
            stmt.setObject(2, route);
            //stmt.setCalendar(3, flight.getDepartureDateTime()); *should i use stmt.setDate()?
            stmt.setString(4, flight.getStatus());
            
            stmt.close();
            finishSQL(conn);
        }
        catch(SQLException ex)
        {
            ex.printStackTrace();
            added = false;
            finishSQL(conn);
        }
        
        return added;  
    }
        
    public boolean delete(int id){
        boolean deleted = false;
        
        try
        {
            conn = database.getConnection();
            
            String sqlSt = "// SQL //";
            PreparedStatement stmt = conn.prepareStatement(sqlSt);
            stmt.setInt(1, id);
            
            int rows = stmt.executeUpdate();
            deleted = rows == 1;
            
            stmt.close();
            finishSQL(conn);
        }
        catch(SQLException ex)
        {
            ex.printStackTrace();
            deleted = false;
            finishSQL(conn);
        }
        
        return deleted; 
    }
    
    public ArrayList<Object> getAll(){
        ArrayList<Object> flightList = new ArrayList<>();
        
        try
        {
            conn = database.getConnection();
            
            String sqlSt = "// SQL //";
            PreparedStatement stmt = conn.prepareStatement(sqlSt);
            ResultSet rs = stmt.executeQuery();
            
            while(rs.next())
            {
                //unsure on how to go about added AirportDTOs for destinations so using null instead
                RouteDTO route = new RouteDTO(rs.getInt("routeID"), null, null);
                
                //date to calendar
                Calendar cal = Calendar.getInstance();
                cal.setTime(rs.getDate("departureDateTime"));
                
                FlightDTO flight = new FlightDTO(
                        rs.getInt("flightID"),
                        route,
                        cal,
                        rs.getString("status"));
                
                flightList.add(flight);
            }
            
            rs.close();
            stmt.close();
            finishSQL(conn);
            
        }
        catch(SQLException ex)
        {
            ex.printStackTrace();
            finishSQL(conn);
        }
        
        return flightList;
    }
    
        public Object getByID(int id){
        FlightDTO flight = new FlightDTO(id, null, null, null);
        
        try
        {
            conn = database.getConnection();
            
            String sqlSt = "// SQL //";
            PreparedStatement stmt = conn.prepareStatement(sqlSt);
            stmt.setInt(1, id); 
            
            ResultSet rs = stmt.executeQuery();
            
            if(rs.next())
            {
                //unsure on FlightDTOs so using null
                RouteDTO route = new RouteDTO(rs.getInt("routeID"), null, null);
                
                //date to calendar
                Calendar cal = Calendar.getInstance();
                cal.setTime(rs.getDate("departureDateTime"));
                
                flight = new FlightDTO(
                        rs.getInt("flightID"),
                        route,
                        cal,
                        rs.getString("status"));
            }
            
            rs.close();
            stmt.close();
            finishSQL(conn);
            
        }
        catch(SQLException ex)
        {
            ex.printStackTrace();
            finishSQL(conn);
        }
        
        return flight;
    }
}
