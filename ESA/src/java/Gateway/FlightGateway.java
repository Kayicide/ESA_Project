/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Gateway;

import DTO.FlightDTO;
import java.util.ArrayList;

/**
 *
 * @author Kayde
 */
public class FlightGateway extends GatewayAbstract{

       
    public boolean insert(FlightDTO dto){
        return true;  
    }
        
    public boolean delete(int id){
       return true; 
    }
    
    public ArrayList<Object> getAll(){
        ArrayList<Object> flightList = new ArrayList<>();
        return flightList;
    }
    
        public Object getByID(int id){
        FlightDTO dto = new FlightDTO(id, null, null, null);
        return dto;
    }
}
