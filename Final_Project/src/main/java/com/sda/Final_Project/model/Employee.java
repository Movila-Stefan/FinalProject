package com.sda.Final_Project.model;


import lombok.Data;

import javax.annotation.Generated;
import javax.persistence.*;


@Entity
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "name")
    private String name;

    @Column(name = "email")
    private String email;

    @Column(name = "phone_No")
    private long phoneNo;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public long getPhoneNo() {
        return phoneNo;
    }

    public void setPhoneNo(long phoneNo) {
        this.phoneNo = phoneNo;
    }

    public Employee() {
        super();
    }

    public Employee(String name, String email, long phoneNo) {
        super();
        this.name = name;
        this.email = email;
        this.phoneNo = phoneNo;
    }

    public void setid(long id) {
    }
}

