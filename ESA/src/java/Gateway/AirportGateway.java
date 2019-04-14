/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Gateway;

import DTO.AirportDTO;
import static Gateway.GatewayAbstract.database;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
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
        int addressID = 0;
        boolean added = false;
        
        try
        {   
            conn = database.getConnection();
            PreparedStatement stmt = conn.prepareStatement("INSERT INTO ADDRESS (LINE1, LINE2, LINE3, LINE4, LINE5) VALUES (?, ?, ?, ?, ?)", Statement.RETURN_GENERATED_KEYS);
            stmt.setString(1, (airport.getLocation()[0]));
            stmt.setString(2, (airport.getLocation()[1]));
            stmt.setString(3, (airport.getLocation()[2]));
            stmt.setString(4, (airport.getLocation()[3]));
            stmt.setString(5, (airport.getLocation()[4]));
            if(stmt.executeUpdate() != 0){
                ResultSet rs = stmt.getGeneratedKeys();
                rs.next();
                addressID = rs.getInt(1);
                stmt = conn.prepareStatement("INSERT INTO AIRPORT (ID, NAME, ADDRESS_ID, TERMINALS, GATES) values (?,?,?,?,?)");
                stmt.setString(1, airport.getAirportID());
                stmt.setString(2, airport.getName());
                stmt.setInt(3, addressID);
                stmt.setInt(4, airport.getNoTerminals());
                stmt.setInt(5, airport.getNoGates());
            
                int rows = stmt.executeUpdate();
                if(rows == 0){
                    return false;
                }
            }else{
                return false;
            }
            stmt.close();
            finishSQL(conn); 
            return true;
        }
        catch (SQLException ex)
        {
            ex.printStackTrace();
            finishSQL(conn);
            return false;
        }
    }

    public boolean delete(String id) {
        
        boolean deleted = false;
        
        try
        {
            conn = database.getConnection();
            //Chain of deletes
            PreparedStatement stmt3 = conn.prepareStatement("DELETE FROM BOOKING WHERE FLIGHT_ID IN (SELECT ID FROM Flight WHERE ROUTE_ID IN (SELECT ID from Route WHERE STARTING_AIRPORT_ID = ? OR FINISHING_AIRPORT_ID = ?))");
            stmt3.setString(1, id);
            stmt3.setString(2, id);
            stmt3.executeUpdate();
            PreparedStatement stmt2 = conn.prepareStatement("DELETE FROM Flight WHERE ROUTE_ID IN (SELECT ID from Route WHERE STARTING_AIRPORT_ID = ? OR FINISHING_AIRPORT_ID = ?)");
            stmt2.setString(1, id);
            stmt2.setString(2, id);
            stmt2.executeUpdate();
            PreparedStatement stmt1 = conn.prepareStatement("DELETE FROM ROUTE WHERE STARTING_AIRPORT_ID = ? OR FINISHING_AIRPORT_ID = ?");
            stmt1.setString(1, id);
            stmt1.setString(2, id);
            stmt1.executeUpdate();
            PreparedStatement stmt = conn.prepareStatement("DELETE FROM AIRPORT WHERE ID = ?");
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
                airport.setLocation(getAddress(rs.getInt("ADDRESS_ID")));
                    
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
        AirportDTO airport = null;
        try
        {
            conn = database.getConnection();
            
            
            PreparedStatement stmt = conn.prepareStatement("SELECT * FROM AIRPORT WHERE AirportID = ?");
            stmt.setString(1, id); 
            
            ResultSet rs = stmt.executeQuery();
            
            if(rs.next())
            {
                airport = new AirportDTO(
                    rs.getString("ID"),
                    rs.getString("NAME"),
                    rs.getInt("TERMINALS"),
                    rs.getInt("GATES")
                );
                airport.setLocation(getAddress(rs.getInt("ADDRESS_ID")));
            }
            rs.close();
            stmt.close();
            finishSQL(conn);
        }
        catch(SQLException ex)
        {
            ex.printStackTrace();
            finishSQL(conn);
            return null;
        }
        
        return airport;
    }

}
