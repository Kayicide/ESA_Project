/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Gateway;

import DTO.BookingDTO;
import java.util.ArrayList;

/**
 *
 * @author Kayde
 */
public class BookingGateway extends GatewayAbstract{

        
    public boolean insert(BookingDTO dto){
        return true;  
    }
        
    public boolean delete(int id){
       return true; 
    }
       
    public ArrayList<Object> getAll(){
        ArrayList<Object> bookingList = new ArrayList<>();
        return bookingList;
    }
      
    public Object getByID(int id){
        BookingDTO dto = new BookingDTO(null, null, null);
        return dto;
    }
        
}
