/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Manager;

import DTO.AirportDTO;
import Gateway.AirportGateway;
import java.util.ArrayList;

/**
 *
 * @author Kayde
 */
public class AirportManager extends ManagerAbstract {
    private final AirportGateway gateway = (AirportGateway)gatewayFactory.create(gatewayFactory.AIRPORT_GATEWAY);

    @Override
    public boolean add(Object obj) {
        AirportDTO dto = (AirportDTO)obj;
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
        //should not be called
        return null;
    }
    
    @Override
    public Object getById(String id)
    {
        return gateway.getByID(id);
    }
}
