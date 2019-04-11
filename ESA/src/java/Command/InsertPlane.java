/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Command;

import DTO.PlaneDTO;
import Manager.PlaneManager;

/**
 *
 * @author Kayde
 */
public class InsertPlane implements Command{
    PlaneDTO plane;
    PlaneManager manager = new PlaneManager();
    public InsertPlane(PlaneDTO plane){
        this.plane = plane;
    }

    @Override
    public Object execute() {
        return manager.add(plane);
    }
    
}
