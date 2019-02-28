/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Gateway;

import DTO.PlaneDTO;
import java.util.ArrayList;

/**
 *
 * @author Kayde
 */
public class PlaneGateway extends GatewayAbstract{
       
    public boolean insert(PlaneDTO dto){
        return true;  
    }
     
    public boolean delete(int id){
       return true; 
    }
        
    public ArrayList<Object> getAll(){
        ArrayList<Object> PlaneList = new ArrayList<>();
        return PlaneList;
    }
    
    public Object getByID(int id){
        PlaneDTO dto = new PlaneDTO(id, null, id, id);
        return dto;
    }
    
}
