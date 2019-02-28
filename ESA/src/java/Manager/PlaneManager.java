/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Manager;

import DTO.PlaneDTO;
import Gateway.PlaneGateway;
import static Manager.ManagerAbstract.gatewayFactory;
import java.util.ArrayList;

/**
 *
 * @author Kayde
 */
public class PlaneManager extends ManagerAbstract{
    private final PlaneGateway gateway = (PlaneGateway)gatewayFactory.create(gatewayFactory.PLANE_GATEWAY);

    @Override
    public boolean add(Object obj) {
        PlaneDTO dto = (PlaneDTO)obj;
        return gateway.insert(dto);
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
