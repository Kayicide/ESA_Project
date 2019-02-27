/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Manager;

import Gateway.FlightGateway;
import static Manager.ManagerAbstract.gatewayFactory;

/**
 *
 * @author Kayde
 */
public class FlightManager extends ManagerAbstract{
    private final FlightGateway gateway = (FlightGateway)gatewayFactory.create(gatewayFactory.FLIGHT_GATEWAY);
}