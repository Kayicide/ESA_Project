/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Gateway;

import DTO.PlaneDTO;
import java.util.ArrayList;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Kayde
 */
public class PlaneGateway extends GatewayAbstract{
    
    private Connection conn;
       
    public boolean insert(PlaneDTO plane){
        try
        {
            conn = database.getConnection();
            
            PreparedStatement stmt = conn.prepareStatement("INSERT INTO PLANE (CAPACITY, CREW, TYPE) values (?,?,?)");
            stmt.setInt(1, plane.getCapacity());
            stmt.setInt(2, plane.getNoCrew());
            stmt.setString(3, plane.getPlaneModel());
            
            int rows = stmt.executeUpdate();
            if(rows == 0){
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
        try
        {
            conn = database.getConnection();
            
           
            PreparedStatement stmt3 = conn.prepareStatement("DELETE FROM BOOKING WHERE FLIGHT_ID IN (SELECT ID FROM Flight WHERE ROUTE_ID IN (SELECT ID from Route WHERE PLANE_ID = ?))");
            stmt3.setInt(1, id);
            stmt3.executeUpdate();
            PreparedStatement stmt2 = conn.prepareStatement("DELETE FROM Flight WHERE ROUTE_ID IN (SELECT ID from Route WHERE PLANE_ID = ?)");
            stmt2.setInt(1, id);
            stmt2.executeUpdate();
            PreparedStatement stmt1 = conn.prepareStatement("DELETE FROM ROUTE WHERE PLANE_ID = ?");
            stmt1.setInt(1, id);
            stmt1.executeUpdate();
            PreparedStatement stmt = conn.prepareStatement("DELETE FROM PLANE WHERE ID = ?");
            stmt.setInt(1, id);
            
            int rows = stmt.executeUpdate();
            if(rows == 0){
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
        
    public ArrayList<Object> getAll(){
        ArrayList<Object> PlaneList = new ArrayList<>();
        
        try
        {
            conn = database.getConnection();
            
            
            PreparedStatement stmt = conn.prepareStatement("SELECT * FROM PLANE");
            ResultSet rs = stmt.executeQuery();
            
            while(rs.next())
            {
                PlaneDTO plane = new PlaneDTO(
                        rs.getInt("ID"),
                        rs.getString("TYPE"),
                        rs.getInt("CAPACITY"),
                        rs.getInt("CREW"));
                PlaneList.add(plane);
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
        
        return PlaneList;
    }
    
    public Object getByID(int id){
        PlaneDTO plane = null;
        
        try
        {
            conn = database.getConnection();
            
            
            PreparedStatement stmt = conn.prepareStatement("SELECT * FROM PLANE WHERE ID = ?");
            stmt.setInt(1, id);
            
            ResultSet rs = stmt.executeQuery();
            
            if(rs.next())
            {
                plane = new PlaneDTO(
                        rs.getInt("ID"),
                        rs.getString("TYPE"),
                        rs.getInt("CAPACITY"),
                        rs.getInt("CREW"));
            }
            
            rs.close();
            stmt.close();
            finishSQL(conn); 
            return plane;
        }
        catch(SQLException ex)
        {
            ex.printStackTrace();
            finishSQL(conn);
        }
        
        return null;
    }
    
}
