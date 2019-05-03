/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Manager;

import java.util.ArrayList;
import org.junit.Test;
import static org.junit.Assert.*;
import DTO.PlaneDTO;
/**
 *
 * @author c015678g
 */
public class PlaneManagerTest
{
    
    public PlaneManagerTest()
    {
    }
    
    @Test
    public void testAdd()
    {
        System.out.println("add");        
        PlaneDTO plane = new PlaneDTO(1,"test",1 ,1);
        PlaneManager instance = new PlaneManager();
        boolean result = instance.add(plane); 
        assertTrue(result);
    }

    @Test
    public void testGetAll()
    {
        System.out.println("getAll");
        PlaneManager instance = new PlaneManager();
        ArrayList<Object> result =instance.getAll();
        assertTrue(!result.isEmpty());
        
    }


    
}
