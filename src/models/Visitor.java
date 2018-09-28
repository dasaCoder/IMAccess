/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

/**
 *
 * @author ACER
 */

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="visitors")
public class Visitor {
     @Id
    @GeneratedValue
    private int id;
    private String title;
    private String first_name;
    private String last_name;
    private String full_name;
    private String address;
    private int telephone;
    private String email;
    private String nic_no;
    private String img_path;
    private int fp_id;

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
     * @return the email
     */
    public String getEmail() {
        return email;
    }

    /**
     * @param email the email to set
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * @return the nic_no
     */
    public String getNic_no() {
        return nic_no;
    }

    /**
     * @param nic_no the nic_no to set
     */
    public void setNic_no(String nic_no) {
        this.nic_no = nic_no;
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

    /**
     * @return the fp_id
     */
    public int getFp_id() {
        return fp_id;
    }

    /**
     * @param fp_id the fp_id to set
     */
    public void setFp_id(int fp_id) {
        this.fp_id = fp_id;
    }
    
    
}
