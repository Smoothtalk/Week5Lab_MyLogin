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
public class User {
    private String username;
    private String password;
    
    public User(String username, String password) {
        this.username = username;
        this.password = password;
    }
    
    public User validUser(){
        this.password = null;
        return this;
    }
    
    public User invalidUser(){
        this.username = null;
        this.password = null;
        
        return this;
    }
}