/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Gateway;

import DTO.AirportDTO;
import java.util.ArrayList;

/**
 *
 * @author Kayde
 */
public class AirportGateway extends GatewayAbstract {
    
    public boolean insert(AirportDTO dto){
        return true;  
    }
    
    public boolean delete(int id){
       return true; 
    }
    
    public ArrayList<Object> getAll(){
        ArrayList<Object> airportList = new ArrayList<>();
        return airportList;
    }
    
    public Object getByID(int id){
        AirportDTO dto = new AirportDTO(null, null, null, id, id);
        return dto;
    }
    
}
