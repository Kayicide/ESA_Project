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
public class GetAllAirports implements Command{
    AirportManager manager = new AirportManager();
    @Override
    public Object execute() {
        return manager.getAll();
    }
}
