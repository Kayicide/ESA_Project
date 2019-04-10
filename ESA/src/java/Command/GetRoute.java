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
public class GetRoute implements Command{
    private int id;
    RouteManager manager = new RouteManager();
    public GetRoute(int id){
        this.id = id;
    }

    @Override
    public Object execute() {
        return manager.getById(id);
    }
}
