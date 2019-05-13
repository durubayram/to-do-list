/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.demo;

import connection.Database;
import java.sql.SQLException;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMethod;
import static org.springframework.web.bind.annotation.RequestMethod.POST;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 *
 * @author duru
 */

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
public class UserController {
    
    
    @RequestMapping(value = "/user/login", method ={RequestMethod.GET,RequestMethod.POST})
    public String userLogin(@RequestParam(value="username", required=false) String username, @RequestParam(value="password",required=false) String password) throws SQLException, JSONException {
        Database db = new Database();
        if(db.loginUser(username, password) == null){
            return null;
        }
        else{

        String json = username;             
        System.out.println(json);
               
        return json; 

    }
    }

    
    @RequestMapping(value = "user/register", method = POST)
    public Register userRegister(@RequestParam(value="username") String username,@RequestParam(value="email") String email, @RequestParam(value="password") String password,@RequestParam(value="password_confirm") String password_confirm) {
        
        Database db = new Database();
        db.registerUser(username, email, password, password_confirm);
        return new Register(username,email,password,password_confirm);

    }
}
