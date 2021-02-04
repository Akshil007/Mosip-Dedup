package com.pe.mosip.bean;


import javax.persistence.*;
import javax.swing.undo.AbstractUndoableEdit;
import java.util.Properties;

@Entity
public class Demo_Details {

    @GeneratedValue(strategy = GenerationType.AUTO)
    @Id
    private int id;

    @Column(nullable = false)
    String full_name;

//    @Column(nullable = false)
//    String last_name;

    @Column(nullable = false)
    String gender;

    @Column(nullable = false)
    String dob;

    @Column
    String address;

    public Demo_Details(String full_name, String gender, String dob, String address) {
        this.full_name=full_name;
        this.gender = gender;
        this.dob = dob;
        this.address = address;
    }

    public Demo_Details() {
    }

    public String getFull_name() {
        return full_name;
    }

    public void setFull_name(String full_name) {
        this.full_name = full_name;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getDob() {
        return dob;
    }

    public void setDob(String dob) {
        this.dob = dob;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
