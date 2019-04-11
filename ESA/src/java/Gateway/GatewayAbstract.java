/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Gateway;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author kayde
 */
public abstract class GatewayAbstract {
    protected static final DatabaseManager database = DatabaseManager.getInstance(); 
    protected void finishSQL(Connection conn){
        try{
            database.finishWithConnection(conn); 
        }catch(SQLException e){
            //do nothing I guess? This should never fail.
        }
    }
    
    protected String[] getAddress(int id){
        String[] address = new String[5];
        try{
            Connection conn = database.getConnection();
            PreparedStatement stmt = conn.prepareStatement("SELECT * FROM ADDRESS WHERE ID = ?");
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            rs.next();
            address[0] = rs.getString("LINE1");
            address[1] = rs.getString("LINE2");
            address[2] = rs.getString("LINE3");
            address[3] = rs.getString("LINE4");
            address[4] = rs.getString("LINE5");
            rs.close(); 
            return address;
        }catch(SQLException ex){
            ex.printStackTrace();
            return null;
        }
    }
}
