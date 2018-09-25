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
    
    public boolean arrangeLecture(String sbj, String lec, String start, String End, String Date, String degree, String academicYr){
        String sql = "INSERT INTO `subject_record` (`id`, `subject_id`, `lecturer_id`, `start_time`, `end_time`, `academic_id`, `date`, `degree_id`)" +
                        "VALUES (NULL," +
                        "(SELECT id FROM `subjects` WHERE code = ?)," +
                        "(SELECT id FROM `lecturers` WHERE full_name = ?)," +
                        "?," +
                        "?," +
                        "(SELECT id FROM `academic_years` WHERE academic_year = ?)," +
                        "?," +
                        "(SELECT id FROM `degrees` WHERE short_name = ?)" +
                        ")";
        
        try {
            
            pst = con.prepareStatement(sql);
            pst.setString(1, sbj);
            pst.setString(2,lec);
            pst.setString(3,start);
            pst.setString(4,End);
            pst.setString(5, academicYr);
            pst.setString(6,Date);
            pst.setString(7,degree);
            
            return pst.execute();
            
        } catch (SQLException ex) {
            Logger.getLogger(LectureQueries.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }
    
    public ResultSet getSubjectList(){
        String sql = "SELECT id,date, start_time,end_time,(SELECT concat(lecturers.title,\" \",lecturers.full_name) from lecturers WHERE lecturers.id = subject_record.lecturer_id) as lec_name, "
                + "(select subjects.code FROM subjects WHERE subjects.id = subject_record.subject_id) as sub_code, degree_id, academic_id "
                + "FROM `subject_record`";
        
        try {
            //SELECT start_time,end_time,date, (select concat(lecturers.title,". ",lecturers.full_name) from lecturers WHERE lecturers.id = subject_record.lecturer_id) as lecturer, (SELECT subjects.code FROM subjects WHERE subjects.id = subject_record.subject_id) FROM `subject_record`

            stmt = con.createStatement();
            ResultSet rst = stmt.executeQuery(sql);
            
            return rst;
            
            
        } catch (SQLException ex) {
            Logger.getLogger(LectureQueries.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return null;
    }
    
    public ResultSet getStdBatch(String recId,String acYr, String deg){
        
        String sql = "SELECT *, (select s.isAttended FROM stu_attendance as s WHERE s.stu_id = student.id AND s.subject_rec_id = ? ) as isAttended  FROM student WHERE student.academic_yr_id = ? and student.degree_id = ?";
        
        try {
            
            pst = con.prepareStatement(sql);
            pst.setString(1, recId);
            pst.setString(2, acYr);
            pst.setString(3,deg);
            ResultSet rst = pst.executeQuery();
            return rst;
            
        } catch (SQLException ex) {
            Logger.getLogger(LectureQueries.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return null;
    }
    
    public boolean markStdAttendance(String stdId, String lecId){
        
        String sql = "INSERT INTO `stu_attendance` (`id`, `subject_id`, `stu_id`, `isAttended`) VALUES (NULL, ?, ?, '1')";
        
        try {
            pst = con.prepareStatement(sql);
            pst.setString(1,lecId);
            pst.setString(2,stdId);
            return pst.execute();
            
        } catch (SQLException ex) {
            Logger.getLogger(LectureQueries.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        return false;
    }
    
    public ResultSet getStudentDetailsByFP(int fpId) throws SQLException{
        String sql = "SELECT concat(student.title,' ',student.full_name) as name, student.student_no, "
                + "(select academic_years.academic_year from academic_years WHERE academic_years.id = student.academic_yr_id LIMIT 1) as ac_yr, "
                + "(SELECT degrees.short_name FROM degrees WHERE degrees.id = student.degree_id LIMIT 1) as degree "
                + "FROM `student` WHERE fingerprint_id = ?";

//String sql = "select * from student WHERE fingerprint_id = 116";
//System.out.println("hi");
        
            pst = con.prepareStatement(sql);
            pst.setInt(1, 116);
            ResultSet rst = pst.executeQuery();
            return rst;
           
            
            
        
    }
    // when lec is created this function will add false value to all enrolled stuent in stuent attendance table
    public boolean markStdAttendance(int stId, boolean isAttended){
        
        String sql = "INSERT INTO `stu_attendance` (`id`, `subject_rec_id`, `stu_id`, `isAttended`) VALUES (NULL,(SELECT MAX(subject_record.id) FROM subject_record),?,?)";
        
        try {
            pst = con.prepareStatement(sql);
            pst.setInt(1, stId);
            pst.setBoolean(2,isAttended);
            //pst.setBoolean(3,isAttended);
            
            
            return pst.execute();
            
        } catch (SQLException ex) {
            Logger.getLogger(LectureQueries.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return false;
    }
    
    public boolean updateAttendance(String stId, String recId, Boolean isAttended){
        
        String sql = "UPDATE `stu_attendance` SET `isAttended` = ? WHERE `subject_rec_id` = ? AND `stu_id` = ?";
        
        try {
            pst = con.prepareStatement(sql);
            pst.setBoolean(1, isAttended);
            pst.setString(2,recId);
            pst.setString(3,stId);
            
            return pst.execute();
            
        } catch (SQLException ex) {
            Logger.getLogger(LectureQueries.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return false;
    }
    
    
    
    
}
