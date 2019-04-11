/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Bean;

import Command.CommandFactory;
import DTO.AirportDTO;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

/**
 *
 * @author Kayde
 */
@Named(value = "addAirportBean")
@RequestScoped
public class AddAirportBean {
    private String airportID;
    private String name;
    private String line1, line2, line3, line4, line5;
    private int noTerminals;
    private int noGates;

    public String getAirportID() {
        return airportID;
    }

    public String getName() {
        return name;
    }

    public String getLine1() {
        return line1;
    }

    public String getLine2() {
        return line2;
    }

    public String getLine3() {
        return line3;
    }

    public String getLine4() {
        return line4;
    }

    public String getLine5() {
        return line5;
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

    public void setLine1(String line1) {
        this.line1 = line1;
    }

    public void setLine2(String line2) {
        this.line2 = line2;
    }

    public void setLine3(String line3) {
        this.line3 = line3;
    }

    public void setLine4(String line4) {
        this.line4 = line4;
    }

    public void setLine5(String line5) {
        this.line5 = line5;
    }

    public void setNoTerminals(int noTerminals) {
        this.noTerminals = noTerminals;
    }

    public void setNoGates(int noGates) {
        this.noGates = noGates;
    }
    
    public String addAirport(){
        String[] address = new String[5];
        address[0] = line1;
        address[1] = line2;
        address[2] = line3;
        address[3] = line4;
        address[4] = line5;
        
        AirportDTO airport = new AirportDTO(airportID, name, noTerminals, noGates);
        airport.setLocation(address);
        CommandFactory.createCommand(CommandFactory.ADD_AIRPORT, airport).execute();
        return "airports.xhtml";
    }
}
