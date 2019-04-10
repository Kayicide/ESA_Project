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
        ArrayList<AirportDTO> list = (ArrayList<AirportDTO>)CommandFactory.createCommand(CommandFactory.GET_ALL_AIRPORTS).execute();
        System.out.println("Bean amount: " + list.size());
        return list;
    }
}
