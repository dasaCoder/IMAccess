/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Queries;

import java.sql.DriverManager;

/**
 *
 * @author UPULEE
 */
public class Dbconnection {
    
Dbconnection(){
}
public static java.sql.Connection getConnection(){
       try{
        Class.forName("com.mysql.jdbc.Driver");
        java.sql.Connection con= DriverManager.getConnection(
               "jdbc:mysql://localhost:3306/imaccess?zeroDateTimeBehavior=convertToNull","root","123");
           System.out.println("connected to db");
        return con;
    }
    catch(Exception e)
    { 
    	System.out.println(e);
    }
       System.out.println("not connected");
    return null;
  }
}

 

