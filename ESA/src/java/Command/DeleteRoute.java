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
public class DeleteRoute implements Command{
    private final int id;
    private RouteManager manager = new RouteManager();
    public DeleteRoute(int id){
        this.id = id;
    }

    @Override
    public Object execute() {
        return manager.delete(id);
    }
    
}
