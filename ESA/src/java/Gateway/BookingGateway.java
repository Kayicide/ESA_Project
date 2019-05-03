/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Gateway;

import DTO.AirportDTO;
import DTO.BookingDTO;
import DTO.UserDTO;
import DTO.FlightDTO;
import DTO.PlaneDTO;
import DTO.RouteDTO;
import static Gateway.GatewayAbstract.database;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

/**
 *
 * @author Kayde
 */
public class BookingGateway extends GatewayAbstract{

    private Connection conn;
        
    public boolean insert(BookingDTO booking){
        try
        {
            conn = database.getConnection();
            //check if the user has already booked it
            PreparedStatement stmt3 = conn.prepareStatement("SELECT * FROM BOOKING WHERE USERNAME = ? AND FLIGHT_ID = ?");
            stmt3.setString(1, booking.getUser().getUsername());
            stmt3.setInt(2, booking.getFlight().getFlightID());
            ResultSet rs2 = stmt3.executeQuery();
            if(rs2.next()){
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("You have already booked this flight"));
                return false;
            }
            
            
            //since the user hasn't booked it then book it
            PreparedStatement stmt = conn.prepareStatement("INSERT INTO BOOKING (USERNAME,FLIGHT_ID, TIME_BOOKED) values (?,?,?)");
            stmt.setString(1, booking.getUser().getUsername());
            stmt.setInt(2, booking.getFlight().getFlightID());
            stmt.setTimestamp(3, booking.getDateTimeBooked());
            
            int rows = stmt.executeUpdate();
            
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
        System.out.println("Gateway - Deleting booking");
        boolean deleted = false;
        
        try
        {
            conn = database.getConnection();
            
            PreparedStatement stmt = conn.prepareStatement("DELETE FROM BOOKING WHERE ID = ?");
            stmt.setInt(1, id);
            
            
            
            if(stmt.executeUpdate() == 0){
                
                stmt.close();
                finishSQL(conn);
                return false;
            }
            
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
       
    public ArrayList<Object> getAll(String username){
        ArrayList<Object> bookingList = new ArrayList<>();
        
        try
        {
            conn = database.getConnection();
            PreparedStatement stmt = conn.prepareStatement(
                    "SELECT FLIGHT.DEPART_TIME, FLIGHT.ARRIVAL_TIME, FLIGHT.ID, FLIGHT.ROUTE_ID, Route.ID, Plane.ID as PlaneID, Plane.TYPE, Plane.CAPACITY, Plane.CREW, a.ID as aID, a.NAME as aNAME, a.ADDRESS_ID as aAddress_ID, a.TERMINALS as aTERMINALS, a.GATES as aGATES, b.ID as bID, b.NAME as bNAME, b.ADDRESS_ID as bADDRESS_ID, b.TERMINALS as bTERMINALS, b.GATES as bGATES, USER_INFO.USERNAME, USER_INFO.FIRSTNAME, USER_INFO.SURNAME, USER_INFO.PASSPORT_NUMBER, BOOKING.ID, BOOKING.USERNAME, BOOKING.FLIGHT_ID, BOOKING.TIME_BOOKED FROM BOOKING"
                    + " JOIN FLIGHT on booking.FLIGHT_ID = flight.ID"
                    + " JOIN ROUTE on flight.ROUTE_ID = ROUTE.ID"
                    + " JOIN Airport a on STARTING_AIRPORT_ID = a.ID"
                    + " JOIN Airport b on FINISHING_AIRPORT_ID = b.ID"
                    + " JOIN Plane on Route.PLANE_ID = Plane.ID"
                    + " JOIN USER_INFO on booking.username = user_info.username"
                    + " WHERE USER_INFO.USERNAME = ?");
            stmt.setString(1, username);
            ResultSet rs = stmt.executeQuery();
            
            while(rs.next())
            {
                AirportDTO departureAirport = new AirportDTO(rs.getString("aID"), rs.getString("aNAME"), rs.getInt("aTERMINALS"), rs.getInt("aGATES"));
                AirportDTO destination = new AirportDTO(rs.getString("bID"), rs.getString("bNAME"), rs.getInt("bTERMINALS"), rs.getInt("bGATES"));
                departureAirport.setLocation(getAddress(rs.getInt("aADDRESS_ID")));
                destination.setLocation(getAddress(rs.getInt("bADDRESS_ID")));
                PlaneDTO plane = new PlaneDTO(rs.getInt("PlaneID"), rs.getString("TYPE"), rs.getInt("CAPACITY"), rs.getInt("CREW"));
                RouteDTO route = new RouteDTO(
                        rs.getInt("ROUTE_ID"),
                        destination,
                        departureAirport,
                        plane);
                
                FlightDTO flight = new FlightDTO(
                        rs.getInt("ID"),
                        route,
                        rs.getTimestamp("DEPART_TIME"),
                        rs.getTimestamp("ARRIVAL_TIME"));
                
                UserDTO user = new UserDTO(
                        rs.getString("USERNAME"),
                        null,
                        rs.getString("FIRSTNAME"),
                        rs.getString("SURNAME"),
                        null,
                        rs.getString("PASSPORT_NUMBER"),
                        false      
                );
                
                BookingDTO booking = new BookingDTO(
                        rs.getInt("ID"),
                        user,
                        flight,
                        rs.getTimestamp("TIME_BOOKED"));
                
                System.out.println(booking.getUser().getUsername());
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
    
    public ArrayList<Object> getAll(){
        ArrayList<Object> bookingList = new ArrayList<>();
        
        try
        {
            conn = database.getConnection();
            PreparedStatement stmt = conn.prepareStatement("SELECT * FROM USER_INFO"
                    + "SELECT * FROM BOOKING"
                    + "SELECT FLIGHT.DEPART_TIME, FLIGHT.ARRIVAL_TIME, FLIGHT.ID, FLIGHT.ROUTE_ID, Route.ID, Plane.ID as PlaneID, Plane.TYPE, Plane.CAPACITY, Plane.CREW, a.ID as aID, a.NAME as aNAME, a.ADDRESS_ID as aAddress_ID, a.TERMINALS as aTERMINALS, a.GATES as aGATES, b.ID as bID, b.NAME as bNAME, b.ADDRESS_ID as bADDRESS_ID, b.TERMINALS as bTERMINALS, b.GATES as bGATES FROM FLIGHT"
                    + " JOIN ROUTE on flight.ROUTE_ID = ROUTE.ID"
                    + " JOIN Airport a on STARTING_AIRPORT_ID = a.ID"
                    + " JOIN Airport b on FINISHING_AIRPORT_ID = b.ID"
                    + " JOIN Plane on Route.PLANE_ID = Plane.ID"
                    + " JOIN USER_INFO on booking.username = USER_INFO.USERNAME"
                    + " JOIN FLIGHT on booking.FLIGHT_ID = FLIGHT.ID");
            ResultSet rs = stmt.executeQuery();
            
            while(rs.next())
            {
                AirportDTO departureAirport = new AirportDTO(rs.getString("aID"), rs.getString("aNAME"), rs.getInt("aTERMINALS"), rs.getInt("aGATES"));
                AirportDTO destination = new AirportDTO(rs.getString("bID"), rs.getString("bNAME"), rs.getInt("bTERMINALS"), rs.getInt("bGATES"));
                departureAirport.setLocation(getAddress(rs.getInt("aADDRESS_ID")));
                destination.setLocation(getAddress(rs.getInt("bADDRESS_ID")));
                PlaneDTO plane = new PlaneDTO(rs.getInt("PlaneID"), rs.getString("TYPE"), rs.getInt("CAPACITY"), rs.getInt("CREW"));
                RouteDTO route = new RouteDTO(
                        rs.getInt("ROUTE_ID"),
                        destination,
                        departureAirport,
                        plane);
                
                FlightDTO flight = new FlightDTO(
                        rs.getInt("ID"),
                        route,
                        rs.getTimestamp("DEPART_TIME"),
                        rs.getTimestamp("ARRIVAL_TIME"));
                
                UserDTO user = new UserDTO(
                        rs.getString("USERNAME"),
                        rs.getString("PASSWORD"),
                        rs.getString("FIRSTNAME"),
                        rs.getString("SURNAME"),
                        null,
                        rs.getString("PASSPORT_NUMBER"),
                        rs.getBoolean("ADMIN")      
                );
                
                BookingDTO booking = new BookingDTO(
                        rs.getInt("ID"),
                        user,
                        flight,
                        rs.getTimestamp("TIME_BOOKED"));
                
                
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
      
//    public Object getByID(int id){
//        
//        BookingDTO booking = null;
//        try
//        {
//            conn = database.getConnection();
//            
//            
//            PreparedStatement stmt = conn.prepareStatement("SELECT Bookings.UserName ,Users.fullname, Users.passportNumber,"
//                 + "Flight.FlightID, Flight.Status"
//                 + " FROM BOOKINGS JOIN Users on Bookings.UserName = Users.UserName"
//                 + " JOIN FLIGHT on Bookings.FlightID = Flight.FlightID"
//                 + " WHERE Bookings.UserID = ?");
//            ResultSet rs = stmt.executeQuery();
//            
//            while (rs.next())
//            {
//                Calendar cal = Calendar.getInstance();
//                cal.setTime(rs.getDate("dateTimeBooked"));
//                UserDTO user = new UserDTO(rs.getString("username"), null, rs.getString("fullname"), null, null, rs.getString("passportNumber"), false);
//                FlightDTO flight = new FlightDTO(rs.getInt("flightID"),null, null, null, rs.getString("status"));
//                booking = new BookingDTO(user, flight, cal);
//                               
// 
//            }
//            
//            
//            rs.close();
//            stmt.close();
//            finishSQL(conn);
//            
//        }
//        catch(SQLException ex)
//        {
//            ex.printStackTrace();
//            finishSQL(conn);
//        }
//        
//        return booking;
//    }
        
}
