/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Gateway;

import DTO.BookingDTO;
import DTO.UserDTO;
import DTO.FlightDTO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;

/**
 *
 * @author Kayde
 */
public class BookingGateway extends GatewayAbstract{

    private Connection conn;
        
    public boolean insert(BookingDTO booking){
        boolean added = false;
        
        try
        {
            conn = database.getConnection();
            String sqlSt = "// SQL //";
            PreparedStatement stmt = conn.prepareStatement(sqlSt);
            
            UserDTO user = booking.getUser();
            FlightDTO flight = booking.getFlight();
            stmt.setObject(1, user);
            stmt.setObject(2, flight);
            //stmt.setDate(3, booking.getDateTimeBooked()); cannot use .setCalendar
            
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
        ArrayList<Object> bookingList = new ArrayList<>();
        
        try
        {
            conn = database.getConnection();
            
            String sqlSt = "// SQL //";
            PreparedStatement stmt = conn.prepareStatement(sqlSt);
            ResultSet rs = stmt.executeQuery();
            
            while (rs.next())
            {
                UserDTO user = new UserDTO(rs.getString("username"), null, rs.getString("fullname"), null, 0, rs.getString("passportNumber"), false);
                FlightDTO flight = new FlightDTO(rs.getInt("flightID"), null, null, rs.getString("status"));
                
                //BookingDTO booking = new BookingDTO(user, flight, date? )
                //bookingList.add(booking);
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
        
        return bookingList;
    }
      
    public Object getByID(int id){
        BookingDTO booking = new BookingDTO(null, null, null);
        
        try
        {
            conn = database.getConnection();
            
            String sqlSt = "// SQL //";
            PreparedStatement stmt = conn.prepareStatement(sqlSt);
            //unsure on how we find booking by ID?
            //stmt.setInt(1, id);
            
            ResultSet rs = stmt.executeQuery();
            
            if(rs.next())
            {
                UserDTO user = new UserDTO(rs.getString("username"), null, rs.getString("fullname"), null, 0, rs.getString("passportNumber"), false);
                FlightDTO flight = new FlightDTO(rs.getInt("flightID"), null, null, rs.getString("status"));
                //booking = new BookingDTO(user, flight, date? );
            }
            
        }
        catch(SQLException ex)
        {
            ex.printStackTrace();
            finishSQL(conn);
        }
        
        return booking;
    }
        
}
