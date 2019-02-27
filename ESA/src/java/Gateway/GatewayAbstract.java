/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Gateway;

import java.sql.Connection;
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
}
