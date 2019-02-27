/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Command;

import DTO.UserDTO;
import Manager.ManagerFactory;

/**
 *
 * @author Kayde
 */
public class CommandFactory {
    static final ManagerFactory managerFactory = new ManagerFactory();
    //Basic
    public static final int REGISTER_USER = 1;
    public static final int LOGIN = 2;
    public static final int VIEW_FLIGHTS = 3;
    public static final int SEARCH_FLIGHTS = 4;

    //User only
    public static final int BOOK_FLIGHT = 5;
    public static final int UPDATE_BOOKING = 6;
    public static final int CANCEL_FLIGHT = 7;
    public static final int VIEW_BOOKINGS = 8;

    //Admin only
    public static final int VIEW_USERS = 9;
    public static final int SEARCH_USERS = 10;
    public static final int ADD_FLIGHT = 11;

    public static Command createCommand(int commandType) {
        switch (commandType) {
            default:
                return null;
        }
    }
    public static Command createCommand(int commandType, UserDTO user) {
        switch (commandType) {
            case LOGIN:
                return new Login(user);
            default:
                return null;
        }
    }
}
