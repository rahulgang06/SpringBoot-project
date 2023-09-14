// entity class sbse pehle yeh create krna this class shows table in db;

package com.example.first.model;

import jakarta.persistence.*;
import org.springframework.boot.autoconfigure.domain.EntityScan;
@Entity
public class student {
    public student(){}
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String name;
    private String address;
    private Integer contact;

    public student(String name, String address, Integer contact) {
        this.name = name;
        this.address = address;
        this.contact = contact;
    }

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Integer getContact() {
        return contact;
    }

    public void setContact(Integer contact) {
        this.contact = contact;
    }
}
