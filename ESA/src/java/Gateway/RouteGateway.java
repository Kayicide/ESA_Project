/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Gateway;

import DTO.RouteDTO;
import DTO.AirportDTO;
import DTO.PlaneDTO;
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
            PreparedStatement stmt = conn.prepareStatement("SELECT * FROM ROUTE WHERE STARTING_AIRPORT_ID = ? AND FINISHING_AIRPORT_ID = ? AND PLANE_ID = ?");
            stmt.setString(1, route.getDepartureAirport().getAirportID());
            stmt.setString(2, route.getDestination().getAirportID());
            stmt.setInt(3, route.getPlane().getPlaneID());
            ResultSet rs = stmt.executeQuery();
            if(!rs.next()){
                stmt = conn.prepareStatement("INSERT INTO ROUTE (STARTING_AIRPORT_ID, FINISHING_AIRPORT_ID, PLANE_ID) values (?,?, ?)");
                stmt.setString(1, route.getDepartureAirport().getAirportID());
                stmt.setString(2, route.getDestination().getAirportID());
                stmt.setInt(3, route.getPlane().getPlaneID());
                int rows = stmt.executeUpdate();
                if(rows == 0){
                    System.out.println("Added failed, no exception?");
                    return false;
                }  
            }else{
                //duplicate
                return false;
            }
            stmt.close();
            finishSQL(conn);
            return true;
        }
        catch(SQLException ex)
        {
            ex.printStackTrace();
            finishSQL(conn);
            return false;
        }
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
        String[] address = new String[5];
        try
        {
            conn = database.getConnection();
            String sqlSt = "// SQL //";
            PreparedStatement stmt = conn.prepareStatement("SELECT Route.ID, Plane.ID as PlaneID, Plane.\"TYPE\", Plane.CAPACITY, Plane.CREW, a.ID as aID, a.\"NAME\" as aNAME, a.ADDRESS_ID as aAddress_ID, a.TERMINALS as aTERMINALS, a.GATES as aGATES, b.ID as bID, b.\"NAME\" as bNAME, b.ADDRESS_ID as bADDRESS_ID, b.TERMINALS as bTERMINALS, b.GATES as bGATES FROM ROUTE"
                    + " JOIN Airport a on STARTING_AIRPORT_ID = a.ID"
                    + " JOIN Airport b on FINISHING_AIRPORT_ID = b.ID"
                    + " JOIN Plane on Route.PLANE_ID = Plane.ID");
            ResultSet rs = stmt.executeQuery();
            
            while(rs.next())
            {
                AirportDTO departureAirport = new AirportDTO(rs.getString("aID"), rs.getString("aNAME"), rs.getInt("aTERMINALS"), rs.getInt("aGATES"));
                AirportDTO destination = new AirportDTO(rs.getString("bID"), rs.getString("bNAME"), rs.getInt("bTERMINALS"), rs.getInt("bGATES"));
                
                //Airport Address
                departureAirport.setLocation(getAddress(rs.getInt("aADDRESS_ID")));
                destination.setLocation(getAddress(rs.getInt("bADDRESS_ID")));

                
                PlaneDTO plane = new PlaneDTO(rs.getInt("PlaneID"), rs.getString("TYPE"), rs.getInt("CAPACITY"), rs.getInt("CREW"));
                RouteDTO route = new RouteDTO(
                        rs.getInt("ID"),
                        departureAirport,
                        destination,
                        plane);
                routeList.add(route);
                
                System.out.println("Line2 of airport departure airport " + route.getDepartureAirport().getLocation()[2]);
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
            PreparedStatement stmt = conn.prepareStatement("SELECT Route.ID, Plane.ID as PlaneID, Plane.\"TYPE\", Plane.CAPACITY, Plane.CREW, a.ID as aID, a.\"NAME\" as aNAME, a.ADDRESS_ID as aAddress_ID, a.TERMINALS as aTERMINALS, a.GATES as aGATES, b.ID as bID, b.\"NAME\" as bNAME, b.ADDRESS_ID as bADDRESS_ID, b.TERMINALS as bTERMINALS, b.GATES as bGATES FROM ROUTE"
                    + " JOIN Airport a on STARTING_AIRPORT_ID = a.ID"
                    + " JOIN Airport b on FINISHING_AIRPORT_ID = b.ID"
                    + " JOIN Plane on Route.PLANE_ID = Plane.ID"
                    + " WHERE ID = ?");
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            
            
            if(rs.next())
            {
                AirportDTO departureAirport = new AirportDTO(rs.getString("aID"), rs.getString("aNAME"), rs.getInt("aTERMINALS"), rs.getInt("aGATES"));
                AirportDTO destination = new AirportDTO(rs.getString("bID"), rs.getString("bNAME"), rs.getInt("bTERMINALS"), rs.getInt("bGATES"));
                departureAirport.setLocation(getAddress(rs.getInt("aADDRESS_ID")));
                destination.setLocation(getAddress(rs.getInt("bADDRESS_ID")));
                PlaneDTO plane = new PlaneDTO(rs.getInt("PlaneID"), rs.getString("TYPE"), rs.getInt("CAPACITY"), rs.getInt("CREW"));
                route = new RouteDTO(
                        rs.getInt("routeID"),
                        destination,
                        departureAirport, plane);
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
