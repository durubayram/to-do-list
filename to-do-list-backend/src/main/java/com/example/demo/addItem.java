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
public class addItem {
        private final String item_name;
         private final Boolean completed_item;
         
    public String getItem_name() {
        return item_name;
    }

    public Boolean getCompleted_item() {
        return completed_item;
    }

    public addItem(String item_name, Boolean completed_item) {
        
        this.item_name =item_name;
        this.completed_item =completed_item;
    }
    
}
