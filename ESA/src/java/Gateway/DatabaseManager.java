/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Gateway;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author Kayde
 */
public class DatabaseManager
{
    private static final DatabaseManager INSTANCE = new DatabaseManager(); //could change the singleton into dependency injection
    
    public static final DatabaseManager getInstance()
    {
        return INSTANCE;
    }

    public Connection getConnection() throws SQLException //currently set up to use JavaDB this can be changed
    {
        String dbaseURL = "";
        DriverManager.registerDriver(
                new org.apache.derby.jdbc.ClientDriver());
        return DriverManager.getConnection(dbaseURL, "Username", "Password");
    }

    public void finishWithConnection(Connection conn) throws SQLException
    {
        if (conn != null)
        {
            conn.close();
        }
    }
}
