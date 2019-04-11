/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Command;

import Manager.AirportManager;

/**
 *
 * @author Kayde
 */
public class DeleteAirport implements Command{
    String id;
    AirportManager manager = new AirportManager();
    public DeleteAirport(String id){
        this.id = id;
    }

    @Override
    public Object execute() {
        return manager.delete(id);
    }
    
}
