/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Command;

import DTO.UserDTO;
import Manager.UserManager;

/**
 *
 * @author Kayde
 */
public class Login implements Command{
    private UserDTO user;
    
    public Login(UserDTO user){
        this.user = user;
    }

    @Override
    public Object execute() { //returns boolean
        //converts the abstract that's returned into the create manager than calls it
        return ((UserManager)managerFactory.create(managerFactory.USER_MANAGER)).login(user);
    }
}
