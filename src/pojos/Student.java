package pojos;
// Generated Sep 6, 2018 2:17:35 AM by Hibernate Tools 4.3.1



/**
 * Student generated by hbm2java
 */
public class Student  implements java.io.Serializable {


     private Integer id;
     private String title;
     private String firstName;
     private String lastName;
     private String fullName;
     private String address;
     private String telephone;
     private String degree;
     private int year;
     private int month;
     private int day;

    public Student() {
    }

    public Student(String title, String firstName, String lastName, String fullName, String address, String telephone, String degree, int year, int month, int day) {
       this.title = title;
       this.firstName = firstName;
       this.lastName = lastName;
       this.fullName = fullName;
       this.address = address;
       this.telephone = telephone;
       this.degree = degree;
       this.year = year;
       this.month = month;
       this.day = day;
    }
   
    public Integer getId() {
        return this.id;
    }
    
    public void setId(Integer id) {
        this.id = id;
    }
    public String getTitle() {
        return this.title;
    }
    
    public void setTitle(String title) {
        this.title = title;
    }
    public String getFirstName() {
        return this.firstName;
    }
    
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
    public String getLastName() {
        return this.lastName;
    }
    
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
    public String getFullName() {
        return this.fullName;
    }
    
    public void setFullName(String fullName) {
        this.fullName = fullName;
    }
    public String getAddress() {
        return this.address;
    }
    
    public void setAddress(String address) {
        this.address = address;
    }
    public String getTelephone() {
        return this.telephone;
    }
    
    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }
    public String getDegree() {
        return this.degree;
    }
    
    public void setDegree(String degree) {
        this.degree = degree;
    }
    public int getYear() {
        return this.year;
    }
    
    public void setYear(int year) {
        this.year = year;
    }
    public int getMonth() {
        return this.month;
    }
    
    public void setMonth(int month) {
        this.month = month;
    }
    public int getDay() {
        return this.day;
    }
    
    public void setDay(int day) {
        this.day = day;
    }




}

