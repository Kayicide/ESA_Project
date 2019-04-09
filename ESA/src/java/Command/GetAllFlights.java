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
public class GetAllFlights implements Command{
    FlightManager manager = new FlightManager();
    @Override
    public Object execute() {
        return manager.getAll();
    }
    
}
