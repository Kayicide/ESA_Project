/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Command;

import DTO.FlightDTO;
import Manager.FlightManager;

/**
 *
 * @author Kayde
 */
public class InsertFlight implements Command{
    FlightDTO flight;
    FlightManager manager = new FlightManager();
    public InsertFlight(FlightDTO flight){
        this.flight = flight;
    }

    @Override
    public Object execute() {
       return manager.add(flight);
    }
}
