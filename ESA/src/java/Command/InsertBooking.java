/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Command;

import DTO.BookingDTO;
import Manager.BookingManager;

/**
 *
 * @author Jake
 */
public class InsertBooking implements Command {
    BookingDTO booking;
    BookingManager manager = new BookingManager();
    
    public InsertBooking(BookingDTO booking){
        this.booking = booking;
    }    
    
    @Override
    public Object execute(){
        return manager.add(booking);
    }
}
