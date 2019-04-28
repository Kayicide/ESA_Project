/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Bean;

import Command.CommandFactory;
import DTO.*;
import java.io.Serializable;
import java.util.ArrayList;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

@Named(value = "bookingBean")
@RequestScoped
public class BookingBean implements Serializable {
    
    
    UserBean userbean = new UserBean();
    UserDTO user = userbean.getCurrentUser();
    
    public ArrayList<BookingDTO>getAllBookings(String username){
        System.out.println("Getting all bookings for " + username);
        return (ArrayList<BookingDTO>)CommandFactory.createCommand(CommandFactory.GET_ALL_BOOKINGS, username).execute();
    }
    
    public void deleteBooking(int id){
        System.out.println("deleting booking " + id);
        CommandFactory.createCommand(CommandFactory.DELETE_BOOKING, id).execute();
    }
    
   
    
    
    
}
