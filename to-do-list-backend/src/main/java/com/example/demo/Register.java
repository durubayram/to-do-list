/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.demo;

/**
 *
 * @author duru
 */
public class Register {
    
        
    private final String username;
    private final String email;
    private final String password;
    private final String password_confirm;

    public String getUsername() {
        return username;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public String getPassword_confirm() {
        return password_confirm;
    }

    public Register(String username,String email,String password,String password_confirm){
            this.username =username;
            this.email=email;
            this.password=password;
            this.password_confirm=password_confirm;
    }
    
    
}
