/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Manager;

import Gateway.BookingGateway;

/**
 *
 * @author Kayde
 */
public class BookingManager extends ManagerAbstract {
    private final BookingGateway gateway = (BookingGateway)gatewayFactory.create(gatewayFactory.BOOKING_GATEWAY);
}
