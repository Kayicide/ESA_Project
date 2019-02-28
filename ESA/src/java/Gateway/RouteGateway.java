/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Gateway;

import DTO.RouteDTO;
import java.util.ArrayList;

/**
 *
 * @author Kayde
 */
public class RouteGateway extends GatewayAbstract{
 
        
    public boolean insert(RouteDTO dto){
        return true;  
    }
     
    public boolean delete(int id){
       return true; 
    }
       
    public ArrayList<Object> getAll(){
        ArrayList<Object> routeList = new ArrayList<>();
        return routeList;
    }
    
    public Object getByID(int id){
        RouteDTO dto = new RouteDTO(id, null, null);
        return dto;
    }
}
