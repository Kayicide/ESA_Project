
package Bean;

import DTO.FlightDTO;
import Manager.FlightManager;
import java.io.Serializable;
import java.util.ArrayList;
import javax.faces.bean.RequestScoped;
import javax.inject.Named;

@Named(value = "flightBean")
@RequestScoped
public class FlightBean implements Serializable {
    
    private FlightManager flightManager = new FlightManager();
    
    private FlightDTO flightdetails = null;
    
    public FlightDTO getFlightDetails(){
        return flightdetails;
    }
        
    public ArrayList<Object>getAllFlights(){
        ArrayList<Object> allFlights = flightManager.getAll();
        return allFlights;
    }
}
