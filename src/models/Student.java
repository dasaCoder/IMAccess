/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="student")
public class Student {

    /**
     * @return the is_active
     */
    public boolean isIs_active() {
        return is_active;
    }

    /**
     * @param is_active the is_active to set
     */
    public void setIs_active(boolean is_active) {
        this.is_active = is_active;
    }

    /**
     * @return the degree_id
     */
    public int getDegree_id() {
        return degree_id;
    }

    /**
     * @param degree_id the degree_id to set
     */
    public void setDegree_id(int degree_id) {
        this.degree_id = degree_id;
    }

    /**
     * @return the academic_yr_id
     */
    public int getAcademic_yr_id() {
        return academic_yr_id;
    }

    /**
     * @param academic_yr_id the academic_yr_id to set
     */
    public void setAcademic_yr_id(int academic_yr_id) {
        this.academic_yr_id = academic_yr_id;
    }

    /**
     * @return the id
     */
    public int getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * @return the title
     */
    public String getTitle() {
        return title;
    }

    /**
     * @param title the title to set
     */
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     * @return the first_name
     */
    public String getFirst_name() {
        return first_name;
    }

    /**
     * @param first_name the first_name to set
     */
    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    /**
     * @return the last_name
     */
    public String getLast_name() {
        return last_name;
    }

    /**
     * @param last_name the last_name to set
     */
    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    /**
     * @return the full_name
     */
    public String getFull_name() {
        return full_name;
    }

    /**
     * @param full_name the full_name to set
     */
    public void setFull_name(String full_name) {
        this.full_name = full_name;
    }

    /**
     * @return the address
     */
    public String getAddress() {
        return address;
    }

    /**
     * @param address the address to set
     */
    public void setAddress(String address) {
        this.address = address;
    }

    /**
     * @return the telephone
     */
    public int getTelephone() {
        return telephone;
    }

    /**
     * @param telephone the telephone to set
     */
    public void setTelephone(int telephone) {
        this.telephone = telephone;
    }

    /**
     * @return the year
     */
    public int getYear() {
        return year;
    }

    /**
     * @param year the year to set
     */
    public void setYear(int year) {
        this.year = year;
    }

    /**
     * @return the month
     */
    public int getMonth() {
        return month;
    }

    /**
     * @param month the month to set
     */
    public void setMonth(int month) {
        this.month = month;
    }

    /**
     * @return the day
     */
    public int getDay() {
        return day;
    }

    /**
     * @param day the day to set
     */
    public void setDay(int day) {
        this.day = day;
    }

    /**
     * @return the degree
     */
    
    @Id
    @GeneratedValue
    private int id;
    private String title;
    private String first_name;
    private String last_name;
    private String full_name;
    private String address;
    private int telephone;
    private int year;
    private int month;
    private int day;
    //private String degree;
    private String student_no;
    
    private int degree_id;
    private int academic_yr_id;
    private boolean is_active;
    
    private String img_path;
  

    /**
     * @return the student_no
     */
    public String getStudent_no() {
        return student_no;
    }

    /**
     * @param student_no the student_no to set
     */
    public void setStudent_no(String student_no) {
        this.student_no = student_no;
    }

    /**
     * @return the img_path
     */
    public String getImg_path() {
        return img_path;
    }

    /**
     * @param img_path the img_path to set
     */
    public void setImg_path(String img_path) {
        this.img_path = img_path;
    }
        
    
}
