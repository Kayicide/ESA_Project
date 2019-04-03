/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Bean;

import DTO.*;
import java.io.Serializable;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

@Named(value = "bookingBean")
@RequestScoped
public class BookingBean implements Serializable {
    
    private FlightDTO flight;
    UserBean userbean = new UserBean();
    UserDTO user = userbean.getCurrentUser();
    
    
    
}
