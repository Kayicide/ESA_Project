/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Manager;

import Gateway.GatewayFactory;
import java.util.ArrayList;

/**
 *
 * @author Kayde
 */
public abstract class ManagerAbstract {
    protected static final GatewayFactory gatewayFactory = new GatewayFactory(); 
    
    public abstract boolean add(Object obj);
    public abstract boolean delete(int id);
    public abstract ArrayList<Object> getAll();
    public abstract Object getById(int id);
    
    //non abstract methods that pass String instead of int
    public Object getById(String id)
    {
        //should be over written
        throw new UnsupportedOperationException();
    }
    
    public boolean delete(String id)
    {
        //should be over written
        throw new UnsupportedOperationException();
    }
    
}
