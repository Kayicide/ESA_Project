/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DTO;

import java.sql.Timestamp;
import java.util.Calendar;

/**
 *
 * @author kayde
 */
public class BookingDTO {
    private int bookingID;
    private UserDTO user;
    private FlightDTO flight;
    private Timestamp dateTimeBooked;
    private String status;
    public BookingDTO(int bookingID, UserDTO user, FlightDTO flight, Timestamp dateTimeBooked){
        this.bookingID = bookingID;
        this.user = user;
        this.flight = flight;
        this.dateTimeBooked = dateTimeBooked;
    }

    public int getBookingID() {
        return bookingID;
    }

    public void setBookingID(int bookingID) {
        this.bookingID = bookingID;
    }
    

    public String getStatus(){
        return status;
    }

    public UserDTO getUser() {
        return user;
    }

    public FlightDTO getFlight() {
        return flight;
    }

    public Timestamp getDateTimeBooked() {
        return dateTimeBooked;
    }
    
    public void setStatusCancelled(){
        this.status = "cancelled";
    }
    
    public void setStatusExpired(){ //for when the flight has departed. I doubt this will be needed tbh.
        this.status = "expired";
    }

    public void setUser(UserDTO user) {
        this.user = user;
    }

    public void setFlight(FlightDTO flight) {
        this.flight = flight;
    }

    public void setDateTimeBooked(Timestamp dateTimeBooked) {
        this.dateTimeBooked = dateTimeBooked;
    }
    
}
