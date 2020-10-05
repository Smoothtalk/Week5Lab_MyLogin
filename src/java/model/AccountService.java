/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author 775653
 */
public class AccountService {
    
    final private String validUsernameAbe = "abe";
    final private String validUsernameBard = "barb";
    final private String authenticatedPassword = "password";
    
    public AccountService(){
        
    }
    
    public User login(String username, String password){
        User newUser = new User(username, password);
        
        if((username.equalsIgnoreCase(this.validUsernameAbe) || username.equalsIgnoreCase(this.validUsernameBard)) && password.equals(this.authenticatedPassword)){
            newUser.validUser();
        } else {
            newUser = null;
        }
        return newUser;
    }
}
