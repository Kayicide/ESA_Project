/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DTO;

/**
 *
 * @author Kayde
 */
public class PlaneDTO {
    int PlaneID, Capacity, noCrew;
    String planeModel;
    public PlaneDTO(int PlaneID, String planeModel, int Capacity, int noCrew){
        this.PlaneID = PlaneID;
        this.planeModel = planeModel;
        this.Capacity = Capacity;
        this.noCrew = noCrew;
    }

    public String getPlaneModel() {
        return planeModel;
    }

    public int getPlaneID() {
        return PlaneID;
    }

    public int getCapacity() {
        return Capacity;
    }

    public int getNoCrew() {
        return noCrew;
    }

    public void setPlaneModel(String planeModel) {
        this.planeModel = planeModel;
    }

    public void setPlaneID(int PlaneID) {
        this.PlaneID = PlaneID;
    }

    public void setCapacity(int Capacity) {
        this.Capacity = Capacity;
    }

    public void setNoCrew(int noCrew) {
        this.noCrew = noCrew;
    }
    
}
