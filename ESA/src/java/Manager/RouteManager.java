/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Manager;

import Gateway.RouteGateway;
import static Manager.ManagerAbstract.gatewayFactory;

/**
 *
 * @author Kayde
 */
public class RouteManager extends ManagerAbstract{
    private final RouteGateway gateway = (RouteGateway)gatewayFactory.create(gatewayFactory.ROUTE_GATEWAY); 
}
