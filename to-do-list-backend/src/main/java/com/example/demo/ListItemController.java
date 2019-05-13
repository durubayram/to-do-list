/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.demo;

import connection.Database;
import java.sql.SQLException;
import org.json.JSONException;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author duru
 */
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
public class ListItemController {
  
    
    @RequestMapping(value = "/user/add_items", method ={RequestMethod.GET,RequestMethod.POST})
    public addItem addItem(@RequestParam(value="item_name") String item_name, @RequestParam(value="completed_item") Boolean completed_item) throws SQLException, JSONException {
        Database db = new Database();
        db.addItems(item_name,completed_item);

               
        return new addItem(item_name,completed_item); 

        }
    
    }
    

