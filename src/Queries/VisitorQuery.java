/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Queries;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
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
        //Dbconnection db = new Dbconnection();
        con = Dbconnection.getConnection();
    }
    
    public int getLastUserId(){
        String query = "SELECT id FROM `visitors` ORDER by id DESC LIMIT 1";
        
        try {
            stmt =  con.createStatement();
            
            ResultSet rst = stmt.executeQuery(query);
            if(rst.next()){
                return (Integer)rst.getInt("id");
            } else{
                return -1;
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(VisitorQuery.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        return -1;
        
    }
    
    public boolean setAccess(int visitor_id){
        
        
        String query = "INSERT INTO `visitor_building` (`id`, `visitor_id`, `block_id`, `is_allowed`) VALUES (NULL, ?, 1, '0'), (NULL, ?, 2, '0'), (NULL, ?, 3, '0'), (NULL, ?, 4, '0');";
            
        try {
            pst = con.prepareStatement(query);
            pst.setInt(1,visitor_id);
            pst.setInt(2,visitor_id);
            pst.setInt(3,visitor_id);
            boolean status = pst.execute();

            return status;
        } catch (SQLException ex) {
            System.out.println(ex);
            Logger.getLogger(VisitorQuery.class.getName()).log(Level.SEVERE, null, ex);
        }
         return false;   
    }
    
    public boolean updateAcess(int visitor_id, int block_id, boolean access){
        String query = "UPDATE `visitor_building` SET `is_allowed` = ? WHERE visitor_building.visitor_id = ? AND block_id = ?";
        
        try {
            
            pst = con.prepareStatement(query);
            pst.setBoolean(1, access);
            pst.setInt(2,visitor_id);
            pst.setInt(3, block_id);
            int status = pst.executeUpdate();
            
            if(status == 0){
                return false;
            } else{
                return true;
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(VisitorQuery.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }
    
}
