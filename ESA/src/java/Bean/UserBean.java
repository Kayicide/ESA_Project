/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Bean;

import Command.CommandFactory;
import DTO.UserDTO;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.context.FacesContext;

/**
 *
 * @author Kayde
 */
@Named(value = "UserBean")
@SessionScoped
public class UserBean implements Serializable {
    private String username, password;
    private UserDTO currentUser;
    private boolean loggedIn = false;

    public boolean getLoggedIn(){
        return loggedIn;
    }
    
    public UserDTO getCurrentUser(){
        return currentUser;
    }
    
    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        try {
            byte[] hash = MessageDigest.getInstance("SHA-256").digest(password.getBytes(StandardCharsets.UTF_8));
            this.password = Base64.getEncoder().encodeToString(hash);
            
        } catch (NoSuchAlgorithmException ex) {
            this.password = "";
            Logger.getLogger(UserBean.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public String getUsername(){
        return username;
    }
    
    public String getPassword(){
        return password;
    }
    
    
    public String Login(){
        if(loggedIn == true){
            //display error that user is already logged in!
            return null;
        }else if(username == null || password == null){
            //return error that user needs to fill the boxes!
            return null;
        }
        
        currentUser.setUsername(username);
        currentUser.setPassword(password);
        
        if((Boolean)CommandFactory.createCommand(CommandFactory.LOGIN, currentUser).execute()){ //if login is successfull then
            currentUser = new UserDTO(username, password);
            loggedIn = true;
            return "index.xhtml";
        }else{
            //display incorrect login details error
            clear();
            return null;
        }
    }
    
    public String Logout(){
        loggedIn = false;
        clear();
        return "/login";
    }
    
    public void clear(){
        this.username = "";
        this.password = "";
        currentUser = null;
        
        FacesContext.getCurrentInstance().getExternalContext().invalidateSession();
    }
}
