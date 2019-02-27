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

/**
 *
 * @author Kayde
 */
public class UserGateway extends GatewayAbstract {

    private Connection conn;

    public boolean login(UserDTO user) {
        try {
            conn = database.getConnection();
            PreparedStatement stmt = conn.prepareStatement("SELECT * FROM Users WHERE username = ?");
            stmt.setString(1, user.getUsername());
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                if (rs.getString("password").equals(user.getPassword())) {
                    user.setFullname(rs.getString("fullname"));
                    user.setPassword(rs.getString("password"));
                    user.setAddress(rs.getString("address"));
                    user.setAge(rs.getInt("age"));
                    user.setPassportNumber(rs.getString("passportNumber"));
                    user.setIsAdmin(rs.getBoolean("admin"));
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
            //do the stuff inside of this
            database.finishWithConnection(conn);
            return true;
        } catch (SQLException e) {
            //idk if we should do anything here or not.
            e.printStackTrace();
            return false;
        }
    }
}
