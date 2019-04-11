/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Command;

import Manager.PlaneManager;

/**
 *
 * @author Kayde
 */
public class DeletePlane implements Command{
    int id;
    PlaneManager manager = new PlaneManager();
    public DeletePlane(int id){
        this.id = id;
    }

    @Override
    public Object execute() {
        return manager.delete(id);
    }
}
