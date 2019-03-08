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
        boolean added = false;
        
        try
        {
            conn = database.getConnection();
            
            String sqlSt = "// SQL //";
            PreparedStatement stmt = conn.prepareStatement(sqlSt);
            stmt.setInt(1, plane.getPlaneID());
            stmt.setInt(2, plane.getCapacity());
            stmt.setInt(3, plane.getNoCrew());
            stmt.setString(4, plane.getPlaneModel());
            
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
        ArrayList<Object> PlaneList = new ArrayList<>();
        
        try
        {
            conn = database.getConnection();
            
            String sqlSt = "// SQL //";
            PreparedStatement stmt = conn.prepareStatement(sqlSt);
            ResultSet rs = stmt.executeQuery();
            
            while(rs.next())
            {
                PlaneDTO plane = new PlaneDTO(
                        rs.getInt("planeID"),
                        rs.getString("planeModel"),
                        rs.getInt("capacity"),
                        rs.getInt("noCrew"));
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
        PlaneDTO plane = new PlaneDTO(id, null, id, id);
        
        try
        {
            conn = database.getConnection();
            
            String sqlSt = "// SQL //";
            PreparedStatement stmt = conn.prepareStatement(sqlSt);
            stmt.setInt(1, id);
            
            ResultSet rs = stmt.executeQuery();
            
            if(rs.next())
            {
                plane = new PlaneDTO(
                        rs.getInt("planeId"),
                        rs.getString("planeModel"),
                        rs.getInt("capacity"),
                        rs.getInt("noCrew"));
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
        
        return plane;
    }
    
}
