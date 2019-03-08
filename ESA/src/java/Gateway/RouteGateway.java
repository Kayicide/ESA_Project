/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Gateway;

import DTO.RouteDTO;
import DTO.AirportDTO;
import java.sql.Connection;
import java.util.ArrayList;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Kayde
 */
public class RouteGateway extends GatewayAbstract{
 
    private Connection conn;
        
    public boolean insert(RouteDTO route){
        boolean added = false;
        
        try
        {
            conn = database.getConnection();
            String sqlSt = "// SQL //";
            PreparedStatement stmt = conn.prepareStatement(sqlSt);
            
            AirportDTO destination = route.getDestination();
            AirportDTO departureAirport = route.getDepartureAirport();
            stmt.setInt(1, route.getRouteID());
            stmt.setObject(2, destination);
            stmt.setObject(3, departureAirport);
            
            int rows = stmt.executeUpdate();
            added = rows == 1;
            
            stmt.close();
            finishSQL(conn);
        }
        catch(SQLException ex)
        {
            ex.printStackTrace();
            added = false;
            finishSQL(conn);
        }
        
        return true;  
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
        
       return true; 
    }
       
    public ArrayList<Object> getAll(){
        ArrayList<Object> routeList = new ArrayList<>();
        
        try
        {
            conn = database.getConnection();
            String sqlSt = "// SQL //";
            PreparedStatement stmt = conn.prepareStatement(sqlSt);
            ResultSet rs = stmt.executeQuery();
            
            while(rs.next())
            {
                AirportDTO destination = new AirportDTO(rs.getString("airportID"), null, rs.getString("destination"), 0, 0);
                AirportDTO departureAirport = new AirportDTO(rs.getString("airportID"), null, rs.getString("destination"), 0, 0);
                RouteDTO route = new RouteDTO(
                        rs.getInt("routeID"),
                        destination,
                        departureAirport);
                routeList.add(route);
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
        
        return routeList;
    }
    
    public Object getByID(int id){
        RouteDTO route = new RouteDTO(id, null, null);
        
        try
        {
            conn = database.getConnection();
            String sqlSt = "// SQL //";
            PreparedStatement stmt = conn.prepareStatement(sqlSt);
            stmt.setInt(1, id);
            
            ResultSet rs = stmt.executeQuery();
            
            if(rs.next())
            {
                AirportDTO destination = new AirportDTO(rs.getString("airportID"), null, rs.getString("destination"), 0, 0);
                AirportDTO departureAirport = new AirportDTO(rs.getString("airportID"), null, rs.getString("destination"), 0, 0);
                route = new RouteDTO(
                        rs.getInt("routeID"),
                        destination,
                        departureAirport);
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
        
        return route;
    }
}
