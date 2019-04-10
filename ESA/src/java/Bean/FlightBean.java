
package Bean;

import Command.CommandFactory;
import DTO.FlightDTO;
import java.io.Serializable;
import java.util.ArrayList;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

@Named(value = "flightBean")
@SessionScoped
public class FlightBean implements Serializable {
    public FlightDTO getFlightDetails(int id){
        return (FlightDTO)CommandFactory.createCommand(CommandFactory.GET_FLIGHT, id).execute();
    }
        
    public ArrayList<FlightDTO>getAllFlights(){
        return (ArrayList<FlightDTO>)CommandFactory.createCommand(CommandFactory.GET_ALL_FLIGHTS).execute();
    }
    
    public void deleteFlight(int id){
        CommandFactory.createCommand(CommandFactory.DELETE_FLIGHT, id).execute();
    }
}
