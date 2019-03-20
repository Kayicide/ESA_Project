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
            PreparedStatement stmt = conn.prepareStatement("INSERT INTO BOOKINGS (UserName, FightID) values (?,?)");
            
            
            stmt.setString(1, booking.getUser().getUsername());
            stmt.setInt(2, booking.getFlight().getFlightID());
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
            
            PreparedStatement stmt = conn.prepareStatement("DELETE FROM BOOKINGS WHERE ID = ?");
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
            
            
            PreparedStatement stmt = conn.prepareStatement("SELECT Bookings, Users.UserName ,Users.fullname, Users.passportNumber,"
                 + "Flight.FlightID, Flight.Status"
                 + " FROM BOOKINGS JOIN Users on Bookings.UserName = Users.UserName"
                 + " JOIN FLIGHT on Bookings.FlightID = Flight.FlightID"
                 + " WHERE Bookings.UserName = ?");
            ResultSet rs = stmt.executeQuery();
            
            while (rs.next())
            {
                Calendar cal = Calendar.getInstance();
                cal.setTime(rs.getDate("dateTimeBooked"));
                UserDTO user = new UserDTO(rs.getString("username"), null, rs.getString("fullname"), null, null, rs.getString("passportNumber"), false);
                FlightDTO flight = new FlightDTO(rs.getInt("flightID"), null, null, rs.getString("status"));
                BookingDTO booking = new BookingDTO(user, flight, cal);
                bookingList.add(booking);               
 
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
        
        BookingDTO booking = null;
        try
        {
            conn = database.getConnection();
            
            
            PreparedStatement stmt = conn.prepareStatement("SELECT Bookings.UserName ,Users.fullname, Users.passportNumber,"
                 + "Flight.FlightID, Flight.Status"
                 + " FROM BOOKINGS JOIN Users on Bookings.UserName = Users.UserName"
                 + " JOIN FLIGHT on Bookings.FlightID = Flight.FlightID"
                 + " WHERE Bookings.UserID = ?");
            ResultSet rs = stmt.executeQuery();
            
            while (rs.next())
            {
                Calendar cal = Calendar.getInstance();
                cal.setTime(rs.getDate("dateTimeBooked"));
                UserDTO user = new UserDTO(rs.getString("username"), null, rs.getString("fullname"), null, null, rs.getString("passportNumber"), false);
                FlightDTO flight = new FlightDTO(rs.getInt("flightID"), null, null, rs.getString("status"));
                booking = new BookingDTO(user, flight, cal);
                               
 
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
        
        return booking;
    }
        
}
