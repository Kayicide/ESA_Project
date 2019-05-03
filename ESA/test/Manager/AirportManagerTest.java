/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Manager;

import DTO.AirportDTO;
import java.util.ArrayList;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author c015678g
 */
public class AirportManagerTest
{
    
    public AirportManagerTest()
    {
    }
    
    @Test
    public void testAdd()
    {
        System.out.println("add");
        
        AirportDTO airport = new AirportDTO("test", "test", 1, 1);
        AirportManager instance = new AirportManager();
        boolean result = instance.add(airport); 
        assertTrue(result);
    }

    @Test
    public void testGetAll()
    {
        System.out.println("getAll");
        AirportManager instance = new AirportManager();
        ArrayList<Object> result =instance.getAll();
        assertTrue(!result.isEmpty());
    }
    
}
