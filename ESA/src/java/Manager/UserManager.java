/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Manager;

import DTO.UserDTO;
import Gateway.UserGateway;
import static Manager.ManagerAbstract.gatewayFactory;
import java.util.ArrayList;

/**
 *
 * @author Kayde
 */
public class UserManager extends ManagerAbstract {
    private final UserGateway gateway = (UserGateway)gatewayFactory.create(gatewayFactory.USER_GATEWAY); 
    
    
    public boolean login(UserDTO user){
        return gateway.login(user);
    }

    @Override
    public boolean add(Object obj) {
        return gateway.register((UserDTO)obj);
    }

    @Override
    public boolean delete(int id) {
        return gateway.delete(id);
    }

    @Override
    public ArrayList<Object> getAll() {
        return gateway.getAll();
    }

    @Override
    public Object getById(int id) {
        return gateway.getByID(id);
    }
}
