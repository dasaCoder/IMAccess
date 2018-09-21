/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Queries;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author ACER
 */
public class LectureQueries {
    
    Connection con;
    
    Statement stmt = null;
    PreparedStatement pst = null;
    
    public LectureQueries(){
        //Dbconnection db = new Dbconnection();
        con = Dbconnection.getConnection();
    }
    
    public boolean setLecture(String title, String code, String description){
        
        String sql = "INSERT INTO `subjects` (`id`, `code`, `title`, `description`) VALUES (NULL, ?,?,?)";
        
        try {
            
            pst = con.prepareStatement(sql);
            pst.setString(1,code);
            pst.setString(2, title);
            pst.setString(3,description);
            
            boolean status = pst.execute();
            return status;
            
            
        } catch (SQLException ex) {
            Logger.getLogger(LectureQueries.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
        
    }
    
}
