/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Gateway;

import DTO.AirportDTO;
import DTO.FlightDTO;
import DTO.PlaneDTO;
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
        try
        {
            conn = database.getConnection();
            
            
            PreparedStatement stmt = conn.prepareStatement("INSERT INTO FLIGHT (Route_ID, DEPART_TIME, ARRIVAL_TIME) values (?,?,?)");
            
            stmt.setInt(1, flight.getRoute().getRouteID());
            stmt.setTimestamp(2, flight.getDepartureDateTime());
            stmt.setTimestamp(3, flight.getArrivalDateTime());

            if(stmt.executeUpdate() == 0){
                stmt.close();
                finishSQL(conn);
                return false;
            }
            
            stmt.close();
            finishSQL(conn);
        }
        catch(SQLException ex)
        {
            ex.printStackTrace();
            finishSQL(conn);
        }
        return true;
    }
        
    public boolean delete(int id){
        boolean deleted = false;
        
        try
        {
            conn = database.getConnection();
            
            
            PreparedStatement stmt = conn.prepareStatement("DELETE FROM FLIGHT WHERE FlightID = ?");
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
            PreparedStatement stmt = conn.prepareStatement("SELECT FLIGHT.DEPART_TIME, FLIGHT.ARRIVAL_TIME, FLIGHT.ID, FLIGHT.ROUTE_ID, Route.ID, Plane.ID as PlaneID, Plane.TYPE, Plane.CAPACITY, Plane.CREW, a.ID as aID, a.NAME as aNAME, a.ADDRESS_ID as aAddress_ID, a.TERMINALS as aTERMINALS, a.GATES as aGATES, b.ID as bID, b.NAME as bNAME, b.ADDRESS_ID as bADDRESS_ID, b.TERMINALS as bTERMINALS, b.GATES as bGATES FROM FLIGHT"
                    + " JOIN ROUTE on flight.ROUTE_ID = ROUTE.ID"
                    + " JOIN Airport a on STARTING_AIRPORT_ID = a.ID"
                    + " JOIN Airport b on FINISHING_AIRPORT_ID = b.ID"
                    + " JOIN Plane on Route.PLANE_ID = Plane.ID");
            ResultSet rs = stmt.executeQuery();
            
            while(rs.next())
            {
                AirportDTO departureAirport = new AirportDTO(rs.getString("aID"), rs.getString("aNAME"), rs.getInt("aTERMINALS"), rs.getInt("aGATES"));
                AirportDTO destination = new AirportDTO(rs.getString("bID"), rs.getString("bNAME"), rs.getInt("bTERMINALS"), rs.getInt("bGATES"));
                departureAirport.setLocation(getAddress(rs.getInt("aADDRESS_ID")));
                destination.setLocation(getAddress(rs.getInt("bADDRESS_ID")));
                PlaneDTO plane = new PlaneDTO(rs.getInt("PlaneID"), rs.getString("TYPE"), rs.getInt("CAPACITY"), rs.getInt("CREW"));
                RouteDTO route = new RouteDTO(
                        rs.getInt("ROUTE_ID"),
                        destination,
                        departureAirport,
                        plane);
                
                FlightDTO flight = new FlightDTO(
                        rs.getInt("ID"),
                        route,
                        rs.getTimestamp("DEPART_TIME"),
                        rs.getTimestamp("ARRIVAL_TIME"));
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
            PreparedStatement stmt = conn.prepareStatement("SELECT Flight.flightID, Flight.status,Flight.departureDateTime,Route.RouteID"
                 + " FROM FLIGHT JOIN ROUTE on Flight.flightID = Route.RouteID"
                 + " WHERE Flight.FlightID = ?");
            stmt.setInt(1, id); 
            
            ResultSet rs = stmt.executeQuery();
            
            if(rs.next())
            {

                //date to calendar
                Calendar cal = Calendar.getInstance();
                cal.setTime(rs.getDate("departureDateTime"));
                
                
                RouteDTO route = new RouteDTO(rs.getInt("routeID"));
                flight = new FlightDTO(rs.getInt("flightID"),route,cal,rs.getString("status"));
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
