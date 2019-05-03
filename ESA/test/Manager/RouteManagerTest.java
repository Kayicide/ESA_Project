package Manager;

import java.util.ArrayList;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import DTO.FlightDTO;
import DTO.RouteDTO;
import DTO.AirportDTO;
import DTO.PlaneDTO;

/**
 *
 * @author c015678g
 */
public class RouteManagerTest
{
    
    public RouteManagerTest()
    {
    }
    
    @Test
    public void testAdd()
    {
        System.out.println("add");
        AirportDTO airport = new AirportDTO("test", "test", 1, 1);
        PlaneDTO plane = new PlaneDTO(1,"test",1 ,1);
        RouteDTO route = new RouteDTO(1, airport, airport, plane);
        RouteManager instance = new RouteManager();
        boolean result = instance.add(route); 
        assertTrue(result);

    }

    @Test
    public void testGetAll()
    {
        System.out.println("getAllRoutes");
        RouteManager instance = new RouteManager();
        ArrayList<Object> result = instance.getAll();
        assertTrue(!result.isEmpty());
    }

    
}
