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
        try
        {
            conn = database.getConnection();
            PreparedStatement stmt = conn.prepareStatement("INSERT INTO ROUTE (STARTING_AIRPORT_ID, FINISHING_AIRPORT_ID, PLANE_ID) values (?,?, ?)");
            stmt.setString(1, route.getDepartureAirport().getAirportID());
            stmt.setString(2, route.getDestination().getAirportID());
            stmt.setInt(3, route.getPlane().getPlaneID());
            int rows = stmt.executeUpdate();
            if(rows == 0){
                System.out.println("Added failed, no exception?");
                return false;
            }
            
            stmt.close();
            finishSQL(conn);
        }
        catch(SQLException ex)
        {
            ex.printStackTrace();
            finishSQL(conn);
            return false;
        }
        
        return true;  
    }
     
    public boolean delete(int id){
        boolean deleted = false;
        
        try
        {
            conn = database.getConnection();
            
            PreparedStatement stmt = conn.prepareStatement("DELETE FROM Planes WHERE ID = ?");
            
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
            PreparedStatement stmt = conn.prepareStatement("SELECT ROUTE.ID, Airport.AirportID ,Airport.destination"
                 + " FROM ROUTE JOIN Airport on Route.AirportID = Airport.Airport"
                 + " WHERE Route.RouteID = ?");
            ResultSet rs = stmt.executeQuery();
            
            while(rs.next())
            {
                AirportDTO destination = new AirportDTO(rs.getString("airportID"), null, rs.getString("destination"), 0, 0);
                AirportDTO departureAirport = new AirportDTO(rs.getString("airportID"), null, rs.getString("destination"), 0, 0);
                RouteDTO route = new RouteDTO(
                        rs.getInt("routeID"),
                        destination,
                        departureAirport,
                        null); //not working yet
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
        RouteDTO route = new RouteDTO(id, null, null, null);
        
        try
        {
            conn = database.getConnection();
            String sqlSt = "// SQL //";
            PreparedStatement stmt = conn.prepareStatement("SELECT ROUTE.ID, Airport.AirportID ,Airport.destination"
                 + " FROM ROUTE JOIN Airport on Route.AirportID = Airport.Airport"
                 + " WHERE Route.RouteID = ?");
            stmt.setInt(1, id);
            
            ResultSet rs = stmt.executeQuery();
            
            if(rs.next())
            {
                AirportDTO destination = new AirportDTO(rs.getString("airportID"), null, rs.getString("destination"), 0, 0);
                AirportDTO departureAirport = new AirportDTO(rs.getString("airportID"), null, rs.getString("destination"), 0, 0);
                route = new RouteDTO(
                        rs.getInt("routeID"),
                        destination,
                        departureAirport, null);
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
