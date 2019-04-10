/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Gateway;

import DTO.AirportDTO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Kayde
 */
public class AirportGateway extends GatewayAbstract {

    private Connection conn;

    public boolean insert(AirportDTO airport) {
        
        boolean added = false;
        
        try
        {
            conn = database.getConnection();
            PreparedStatement stmt = conn.prepareStatement("INSERT INTO AIRPORT (AirportID, Name, Location, NoTerminla, NoGates) values (?,?,?,?,?)");
            stmt.setString(1, airport.getAirportID());
            stmt.setString(2, airport.getName());
            stmt.setString(3, airport.getLocation());
            stmt.setInt(4, airport.getNoTerminals());
            stmt.setInt(5, airport.getNoGates());
            
            int rows = stmt.executeUpdate();
            added = rows == 1;
            
            stmt.close();
            finishSQL(conn);
            
        }
        catch (SQLException ex)
        {
            ex.printStackTrace();
            added = false;
            finishSQL(conn);
        }

        return added;
    }

    public boolean delete(String id) {
        
        boolean deleted = false;
        
        try
        {
            conn = database.getConnection();
            
            
            PreparedStatement stmt = conn.prepareStatement("DELETE FROM AIRPORT WHERE AirportID = ?");
            stmt.setString(1, id);
            
            int rows = stmt.executeUpdate();
            deleted = rows == 1;
            
            stmt.close();
            finishSQL(conn);
            
        }
        catch (SQLException ex)
        {
            ex.printStackTrace();
            deleted = false;
            finishSQL(conn);
        }
        
        return deleted;
    }

    public ArrayList<Object> getAll() {
        ArrayList<Object> airportList = new ArrayList<>();
            int addressID;
            String[] address = new String[5];
        try
        {
            conn = database.getConnection();
            
            
            PreparedStatement stmt = conn.prepareStatement("SELECT * FROM AIRPORT"); 
            ResultSet rs = stmt.executeQuery();
            
            while (rs.next())
            {
                AirportDTO airport = new AirportDTO(
                    rs.getString("ID"),
                    rs.getString("NAME"),
                    rs.getInt("TERMINALS"),
                    rs.getInt("GATES")
                );
                addressID = rs.getInt("ADDRESS_ID");
                    
                //gets the address information
                PreparedStatement stmt2 = conn.prepareStatement("SELECT * FROM ADDRESS WHERE ID = ?");
                stmt2.setInt(1, addressID);
                ResultSet rs2 = stmt2.executeQuery();
                rs2.next();
                address[0] = rs2.getString("LINE1");
                address[1] = rs2.getString("LINE2");
                address[2] = rs2.getString("LINE3");
                address[3] = rs2.getString("LINE4");
                address[4] = rs2.getString("LINE5");
                airport.setLocation(address);
                rs2.close();
                
                airportList.add(airport);
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
        for(Object a: airportList){
            System.out.println(((AirportDTO) a).getName());
        }
        System.out.println(airportList.size());
        return airportList;
    }

    public Object getByID(String id) {
        AirportDTO airport = new AirportDTO(null, null, null, 0, 0);
        
        try
        {
            conn = database.getConnection();
            
            
            PreparedStatement stmt = conn.prepareStatement("SELECT * FROM AIRPORT WHERE AirportID = ?");
            stmt.setString(1, id); 
            
            ResultSet rs = stmt.executeQuery();
            
            if(rs.next())
            {
                airport = new AirportDTO(
                        rs.getString("airportID"),
                        rs.getString("name"),
                        rs.getString("location"),
                        rs.getInt("noTerminals"),
                        rs.getInt("noGates"));
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
        
        return airport;
    }

}
