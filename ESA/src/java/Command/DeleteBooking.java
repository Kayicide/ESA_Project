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
public class DeleteBooking implements Command {
    String id;
    BookingManager manager = new BookingManager();
    
    public DeleteBooking(String id){
        this.id = id;
    }
    
    @Override
    public Object execute(){
        return manager.delete(id);
    }
        
}
