
package Manager;
import DTO.UserDTO;
import DTO.FlightDTO;
import DTO.BookingDTO;
import DTO.RouteDTO;
import DTO.AirportDTO;
import DTO.PlaneDTO;
import java.sql.Timestamp;
import java.util.ArrayList;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author c015678g
 */
public class BookingManagerTest
{
    
    public BookingManagerTest()
    {
    }
    @Test
    public void testAdd()
    {
        System.out.println("add");
        
        
        String text = "2020-10-02 18:48:05.123";
        Timestamp ts = Timestamp.valueOf(text);
        BookingDTO booking = new BookingDTO(1, new UserDTO("test"), new FlightDTO(1, new RouteDTO(new AirportDTO("test"), new AirportDTO("test"), new PlaneDTO(1)), ts, ts, "test"), ts);
        BookingManager instance = new BookingManager();
        assertTrue(instance.add(booking));
    }
    

    /**
   
     * Test of delete method, of class BookingManager.
     */
 
    @Test
    public void testGetAll()
    {
        System.out.println("getAll");
        String text = "2020-10-02 18:48:05.123";
        Timestamp ts = Timestamp.valueOf(text);
        BookingManager instance = new BookingManager();
        ArrayList<Object> result = instance.getAll();
        assertTrue(!result.isEmpty());
    }



    
}
