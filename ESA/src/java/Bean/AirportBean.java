/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Bean;

import Command.CommandFactory;
import DTO.AirportDTO;
import java.util.ArrayList;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

/**
 *
 * @author Kayde
 */
@Named(value = "airportBean")
@RequestScoped
public class AirportBean {
    public ArrayList<AirportDTO>getAllAirports(){
        return (ArrayList<AirportDTO>)CommandFactory.createCommand(CommandFactory.GET_ALL_AIRPORTS).execute();
    }
    
    public void deleteAirport(String id){
        CommandFactory.createCommand(CommandFactory.DELETE_AIRPORT, id).execute(); 
    }
    
    public String[] getGates(String id){ //Not used yet, might never be
        ArrayList<String> test = new ArrayList<>();
        int gates = ((AirportDTO)CommandFactory.createCommand(CommandFactory.DELETE_AIRPORT, id).execute()).getNoGates();
        int terminals = ((AirportDTO)CommandFactory.createCommand(CommandFactory.DELETE_AIRPORT, id).execute()).getNoTerminals();
        
        for(int i = 0; i < terminals; i++){
            for(int j = 0; j < gates; j++){
                test.add("T: " + i + " G: " + j);
            }
        }
        return test.toArray(new String[test.size()]);
    }
}
