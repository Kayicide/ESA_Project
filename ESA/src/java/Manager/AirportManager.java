/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Manager;

import Gateway.AirportGateway;

/**
 *
 * @author Kayde
 */
public class AirportManager extends ManagerAbstract {
    private final AirportGateway gateway = (AirportGateway)gatewayFactory.create(gatewayFactory.AIRPORT_GATEWAY);
}
