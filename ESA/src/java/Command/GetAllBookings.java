/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Command;

import Manager.BookingManager;

/**
 *
 * @author Jake
 */
public class GetAllBookings implements Command {
    String username;
    BookingManager manager = new BookingManager();
   
    
    public GetAllBookings(String username){
        this.username = username;
    }
    
    @Override
    public Object execute(){
        return manager.getAll(username);
    }
}
