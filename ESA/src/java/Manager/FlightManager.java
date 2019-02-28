/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Manager;

import DTO.FlightDTO;
import Gateway.FlightGateway;
import static Manager.ManagerAbstract.gatewayFactory;
import java.util.ArrayList;

/**
 *
 * @author Kayde
 */
public class FlightManager extends ManagerAbstract{
    private final FlightGateway gateway = (FlightGateway)gatewayFactory.create(gatewayFactory.FLIGHT_GATEWAY);

    @Override
    public boolean add(Object obj) {
        FlightDTO dto = (FlightDTO)obj;
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
        return gateway.getByID();
    }
}
