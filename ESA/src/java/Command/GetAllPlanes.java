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
public class GetAllPlanes implements Command{
    PlaneManager manager = new PlaneManager();
    @Override
    public Object execute() {
        return manager.getAll();
    }
}
