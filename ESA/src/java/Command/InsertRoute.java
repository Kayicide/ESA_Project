/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Command;

import DTO.RouteDTO;
import Manager.RouteManager;

/**
 *
 * @author Kayde
 */
public class InsertRoute implements Command{
    private RouteDTO route;
    private RouteManager manager = new RouteManager();
    public InsertRoute(RouteDTO route){
        this.route = route;
    }
    @Override
    public Object execute() {
        return manager.add(route);
    }
    
}
