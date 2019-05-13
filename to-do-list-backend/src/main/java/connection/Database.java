/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author duru
 */
public class Database {
    
    public static Connection getConnection(){
        
     
        Connection con = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/server", "root", "");
        } catch (ClassNotFoundException | SQLException ex) {
            System.out.println("wtf" +ex.getMessage());
            return null;
        }
        return con;
    }
    
    public void registerUser(String username,String email,String password,String password_confirm) {
        
        Connection dbConnection = null;

          String query = " insert into users (username, email, password, password_confirm)"
        + " values (?, ?, ?, ?)";

         try { 
            dbConnection = getConnection();
            PreparedStatement ps = dbConnection.prepareStatement(query);
            ps.setString(1, username);
            ps.setString(2, email);
            ps.setString(3, password);
            ps.setString(4, password_confirm);
            ps.executeUpdate();

            
             } catch (SQLException ex) {
            
                 System.out.println(ex);
        }

    }
    
    public String loginUser(String username,String password) {
        
        Connection dbConnection = null;
        String query = "Select username,password FROM users WHERE username= ? and password= ?";
        try{
            dbConnection = getConnection();
            PreparedStatement stmt = dbConnection.prepareStatement(query);
            stmt.setString(1, username);
            stmt.setString(2, password);
        System.out.println(stmt);

        ResultSet rs = stmt.executeQuery();
        System.out.println(rs);
           if(rs.next()) {
                
                System.out.println("Username and Password correct");        
            }
           else{
               
               return null;
            }   
        }catch(SQLException ex)
        {
            System.out.println(ex);
        }
        return username;
}
        public void addItems(String item_name,Boolean completed_item) throws SQLException {
        Connection dbConnection= null;
        
        String query = " insert into items(name,isCompleted)" + "values (?,?)";
        try { 
            dbConnection = getConnection();
            PreparedStatement ps = dbConnection.prepareStatement(query);
            ps.setString(1, item_name);
            ps.setBoolean(2, completed_item);
            System.out.println(ps);
            ps.executeUpdate();
            System.out.println(ps.executeUpdate());
            
        }catch(SQLException ex){
            System.out.println(ex);      
        }
    }

}
