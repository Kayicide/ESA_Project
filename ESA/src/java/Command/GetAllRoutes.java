/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Command;

import Manager.RouteManager;

/**
 *
 * @author Kayde
 */
public class GetAllRoutes implements Command{
    RouteManager manager = new RouteManager();
    @Override
    public Object execute() {
        return manager.getAll();
    }
}
