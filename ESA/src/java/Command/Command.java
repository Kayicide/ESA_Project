/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Command;

import Manager.ManagerFactory;

/**
 *
 * @author Kayde
 */
public interface Command {
    public static final ManagerFactory managerFactory = new ManagerFactory();
    public Object execute();
}
