/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Command;

import DTO.AirportDTO;
import Manager.AirportManager;

/**
 *
 * @author Kayde
 */
public class InsertAirport implements Command{
    AirportDTO airport;
    AirportManager manager = new AirportManager();
    
    public InsertAirport(AirportDTO airport){
        this.airport = airport;
    }

    @Override
    public Object execute() {
        return manager.add(airport);
    }
}
