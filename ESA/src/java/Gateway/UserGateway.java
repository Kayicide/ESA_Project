/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Gateway;

import DTO.UserDTO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author Kayde
 */
public class UserGateway extends GatewayAbstract {

    private Connection conn;

    public boolean login(UserDTO user) {
        try {
            conn = database.getConnection();
            int addressID;
            String[] address = new String[4];
            PreparedStatement stmt = conn.prepareStatement("SELECT * FROM Users WHERE username = ?");
            stmt.setString(1, user.getUsername());
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                if (rs.getString("password").equals(user.getPassword())) {
                    //gets the user information
                    user.setFullname(rs.getString("fullname"));
                    user.setPassword(rs.getString("password"));
                    addressID = rs.getInt("ADDRESS_ID");
                    user.setAge(rs.getInt("age"));
                    user.setPassportNumber(rs.getString("passportNumber"));
                    user.setIsAdmin(rs.getBoolean("admin"));
                    
                    //gets the address information
                    stmt = conn.prepareStatement("SELECT * FROM ADDRESS WHERE ID = ?");
                    stmt.setInt(1, addressID);
                    rs = stmt.executeQuery();
                    address[0] = rs.getString("LINE1");
                    address[1] = rs.getString("LINE2");
                    address[2] = rs.getString("LINE3");
                    address[3] = rs.getString("LINE4");
                    user.setAddress(address);
                    
                    finishSQL(conn);
                    return true;
                } else {
                    //incorrect password
                    finishSQL(conn);
                    return false;
                }
            } else {
                //no matching username
                finishSQL(conn);
                return false;
            }
        } catch (SQLException e) {
            //SQL ERROR
            e.printStackTrace();
            return false;
        }
    }

    public boolean register(UserDTO user) {
        try {
            conn = database.getConnection();
            PreparedStatement stmt = conn.prepareStatement("INSERT INTO ADDRESS (LINE1, LINE2, LINE3, LINE4) VALUES (?, ?, ?, ?)", Statement.RETURN_GENERATED_KEYS);
            stmt.setString(1, (user.getAddress()[0]));
            stmt.setString(2, (user.getAddress()[1]));
            stmt.setString(3, (user.getAddress()[2]));
            stmt.setString(4, (user.getAddress()[3]));
            if(stmt.executeUpdate() != 0){
                ResultSet rs = stmt.getGeneratedKeys();
                rs.next();
                int ADDRESS_ID = rs.getInt(1);
                stmt = conn.prepareStatement("INSERT INTO USER (USERNAME, PASSWORD, FIRSTNAME, SURNAME, ADDRESS_ID, ADMIN) VALUES (?, ?, ?, ?, ?, ?)");
                stmt.setString(1, user.getUsername());
                stmt.setString(2, user.getFirstName());
                stmt.setString(3, user.getSurname());
                
                //not finished yet
                
                
            }else{
                //failed to add address
                finishSQL(conn);
                return false;
            }

            
            
            
            
            
            
            
            
            database.finishWithConnection(conn);
            return true;
        } catch (SQLException e) {
            //idk if we should do anything here or not.
            e.printStackTrace();
            return false;
        }
    }
        
    public boolean delete(int id){
       return true; 
    }
        
    public ArrayList<Object> getAll(){
        ArrayList<Object> userList = new ArrayList<>();
        return userList;
    }
    
        public Object getByID(int id){
        UserDTO dto = new UserDTO(null);
        return dto;
    }
    //this is me testing the committ stuff
}
