/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Bean;

import Command.CommandFactory;
import DTO.FlightDTO;
import DTO.PlaneDTO;
import java.util.ArrayList;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

/**
 *
 * @author Kayde
 */
@Named(value = "planeBean")
@RequestScoped
public class PlaneBean {
    public ArrayList<PlaneDTO>getAllPlanes(){
        return (ArrayList<PlaneDTO>)CommandFactory.createCommand(CommandFactory.GET_ALL_PLANES).execute();
    }
    
    public void deletePlane(int id){
        CommandFactory.createCommand(CommandFactory.DELETE_PLANE, id).execute();
    }
}
