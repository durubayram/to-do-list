/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.demo;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author duru
 */
public class UserControllerTest {
    
    public UserControllerTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of userLogin method, of class UserController.
     */
    @Test
    public void testUserLogin() throws Exception {
        System.out.println("userLogin");
        String username = "";
        String password = "";
        UserController instance = new UserController();
        String expResult = "";
        String result = instance.userLogin(username, password);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of userRegister method, of class UserController.
     */
    @Test
    public void testUserRegister() {
        System.out.println("userRegister");
        String username = "";
        String email = "";
        String password = "";
        String password_confirm = "";
        UserController instance = new UserController();
        Register expResult = null;
        Register result = instance.userRegister(username, email, password, password_confirm);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
