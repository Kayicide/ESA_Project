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
public class GetAirport implements Command{
    private String id;
    private AirportManager manager = new AirportManager();
    public GetAirport(String id){
        this.id = id;
    }
    
    @Override
    public Object execute() {
        return manager.getById(id);
    }  
}
