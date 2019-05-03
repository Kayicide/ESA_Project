/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Bean;
import Command.CommandFactory;
import DTO.*;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

/**
 *
 * @author Jake
 */
@Named(value = "addBookingBean")
@RequestScoped
public class AddBookingBean {
    Timestamp bookTime = new Timestamp(System.currentTimeMillis());

    public String addBooking(int flightID, UserDTO user){
        FlightDTO flight = new FlightDTO(flightID,null,null,null,null);
        BookingDTO booking = new BookingDTO(0,user,flight,bookTime);
        CommandFactory.createCommand(CommandFactory.ADD_BOOKING, booking).execute();
        return "/bookings.xhtml";
    }
            
}
