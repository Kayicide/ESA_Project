/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Command;

import static Command.Command.managerFactory;
import DTO.UserDTO;
import Manager.UserManager;

/**
 *
 * @author Kayde
 */
public class Register implements Command{
    private UserDTO user;
    public Register(UserDTO user){
        this.user = user;
    }
    @Override
    public Object execute() {
        return ((UserManager)managerFactory.create(managerFactory.USER_MANAGER)).register(user);
    }
    
}
