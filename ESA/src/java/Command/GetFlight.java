/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Command;

import Manager.FlightManager;

/**
 *
 * @author Kayde
 */
public class GetFlight implements Command{
    int id;
    FlightManager manager = new FlightManager();
    public GetFlight(int id){
        this.id = id;
    }

    @Override
    public Object execute() {
       return manager.getById(id);
    }
}
