
package Bean;

import Command.CommandFactory;
import static Command.CommandFactory.DELETE_FLIGHT;
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
        
    public ArrayList<FlightDTO>getAllFlights(){
        return (ArrayList<FlightDTO>)CommandFactory.createCommand(Factory.GET_ALL_FLIGHTS).execute();
    }
    
    public void deleteFlight(int id){
        CommandFactory.createCommand(Factory.DELETE_FLIGHT, id).execute();
    }
}
