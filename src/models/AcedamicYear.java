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
@Table(name="academic_years")
public class AcedamicYear {
  
    @Id
    @GeneratedValue
    private int id;
    private String academic_year;
    private int year_slug;

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
     * @return the academic_year
     */
    public String getAcademic_year() {
        return academic_year;
    }

    /**
     * @param academic_year the academic_year to set
     */
    public void setAcademic_year(String academic_year) {
        this.academic_year = academic_year;
    }

    /**
     * @return the year_slug
     */
    public int getYear_slug() {
        return year_slug;
    }

    /**
     * @param year_slug the year_slug to set
     */
    public void setYear_slug(int year_slug) {
        this.year_slug = year_slug;
    }
}
