package com.corso.java.esercitazione.domain;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Employee {
    @Id
    private String id;
    private String fullName, mansion;

    public Employee(){}

    public Employee(String id, String fullName, String mansion) {
        this.id = id;
        this.fullName = fullName;
        this.mansion = mansion;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getMansion() {
        return mansion;
    }

    public void setMansion(String mansion) {
        this.mansion = mansion;
    }
}
