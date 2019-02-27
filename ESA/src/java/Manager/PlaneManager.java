/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Manager;

import Gateway.PlaneGateway;
import static Manager.ManagerAbstract.gatewayFactory;

/**
 *
 * @author Kayde
 */
public class PlaneManager extends ManagerAbstract{
    private final PlaneGateway gateway = (PlaneGateway)gatewayFactory.create(gatewayFactory.PLANE_GATEWAY);
}
