/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Bean;

import Command.CommandFactory;
import DTO.PlaneDTO;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

/**
 *
 * @author Kayde
 */
@Named(value = "addPlaneBean")
@RequestScoped
public class AddPlaneBean {
    private int Capacity, noCrew;
    private String planeModel;


    public int getCapacity() {
        return Capacity;
    }

    public int getNoCrew() {
        return noCrew;
    }

    public String getPlaneModel() {
        return planeModel;
    }

    public void setCapacity(int Capacity) {
        this.Capacity = Capacity;
    }

    public void setNoCrew(int noCrew) {
        this.noCrew = noCrew;
    }

    public void setPlaneModel(String planeModel) {
        this.planeModel = planeModel;
    }
    
    public String addPlane(){
        PlaneDTO plane = new PlaneDTO(planeModel, Capacity, noCrew);
        CommandFactory.createCommand(CommandFactory.ADD_PLANE, plane).execute();
        return "index.xhtml";
    }
}
