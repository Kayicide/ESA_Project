/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DTO;

import java.io.Serializable;

/**
 *
 * @author Kayde
 */
public class AirportDTO implements Serializable {
    private String airportID; //Example: LHR for Heathrow
    private String name;
    private String[] location;
    private int noTerminals;
    private int noGates;
    
    public AirportDTO(String airportID, String name, int noTerminals, int noGates){
        this.airportID = airportID;
        this.name = name;
        this.noTerminals = noTerminals;
        this.noGates = noGates;
    }
    
    public AirportDTO(String airportID){
        this.airportID = airportID;
    }

    public String getAirportID() {
        return airportID;
    }

    public String getName() {
        return name;
    }

    public String[] getLocation() {
        return location;
    }

    public int getNoTerminals() {
        return noTerminals;
    }

    public int getNoGates() {
        return noGates;
    }

    public void setAirportID(String airportID) {
        this.airportID = airportID;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setLocation(String[] location) {
        this.location = location;
    }

    public void setNoTerminals(int noTerminals) {
        this.noTerminals = noTerminals;
    }

    public void setNoGates(int noGates) {
        this.noGates = noGates;
    }
    
    
}
