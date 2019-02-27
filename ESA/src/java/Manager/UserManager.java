/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Manager;

import Gateway.UserGateway;
import static Manager.ManagerAbstract.gatewayFactory;

/**
 *
 * @author Kayde
 */
public class UserManager extends ManagerAbstract {
    private final UserGateway gateway = (UserGateway)gatewayFactory.create(gatewayFactory.USER_GATEWAY); 
}
