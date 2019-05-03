/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Manager;

import DTO.UserDTO;
import java.util.ArrayList;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author c015678g
 */
public class UserManagerTest
{
    
    public UserManagerTest()
    {
    }
    

    @Test
    public void testAdd()
    {
        System.out.println("RegisterUser");
        String[] address = new String[] {"", "", "", "", ""};
        UserDTO user = new UserDTO("test", "test", "test", "test", address , "test", false);
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
