/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Manager;

import DTO.BookingDTO;
import Gateway.BookingGateway;
import java.util.ArrayList;

/**
 *
 * @author Kayde
 */
public class BookingManager extends ManagerAbstract {
    private final BookingGateway gateway = (BookingGateway)gatewayFactory.create(gatewayFactory.BOOKING_GATEWAY);

    @Override
    public boolean add(Object obj) {
        BookingDTO dto = (BookingDTO)obj;
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
