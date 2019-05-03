package Manager;

import java.sql.Timestamp;
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
public class FlightManagerTest
{
    
    public FlightManagerTest()
    {
    }
    

    @Test
    public void testAdd()
    {
        System.out.println("test add");
        String text = "2020-10-02 18:48:05.123";
        Timestamp ts = Timestamp.valueOf(text);
        RouteDTO route = new RouteDTO(1, new AirportDTO("test"), new AirportDTO("test"), new PlaneDTO(1,"test",  1 ,1) );
        FlightDTO user = new FlightDTO(1, route, ts, ts, "test");
        UserManager instance = new UserManager();
        boolean result = instance.add(user);
        assertTrue(result);
    }

 

    @Test
    public void testGetAll()
    {
        System.out.println("getAllUsers");
        UserManager instance = new UserManager();
        ArrayList<Object> result = instance.getAll();
        assertTrue(!result.isEmpty());
    }
}
