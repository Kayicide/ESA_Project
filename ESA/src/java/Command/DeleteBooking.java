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
    int id;
    BookingManager manager = new BookingManager();
    
    public DeleteBooking(int id){
        System.out.println("Deleting booking " + id);
        this.id = id;
    }
    
    @Override
    public Object execute(){
        return manager.delete(id);
    }
        
}
