/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Queries;

import com.mysql.jdbc.Statement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author ACER
 */
public class VisitorQuery {
    
    Connection con;
    
    Statement stmt = null;
     PreparedStatement pst = null;
    
    public VisitorQuery(){
        Dbconnection db = new Dbconnection();
        con = db.getConnection();
    }
    
    public boolean setAccess(int visitor_id){
        
        
        String query = "INSERT INTO `visitor_building` (`id`, `visitor_id`, `block_id`, `is_allowed`) VALUES (NULL, ?, 1, '0'), (NULL, ?, 2, '0');";
            
        try {
            pst = con.prepareStatement(query);
            pst.setInt(1,visitor_id);
            pst.setInt(2,visitor_id);
            boolean status = pst.execute();

            return status;
        } catch (SQLException ex) {
            System.out.println(ex);
            Logger.getLogger(VisitorQuery.class.getName()).log(Level.SEVERE, null, ex);
        }
         return false;   
    }
    
}
