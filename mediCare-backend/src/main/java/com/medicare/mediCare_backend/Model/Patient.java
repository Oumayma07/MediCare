package com.medicare.mediCare_backend.Model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;


@Document(collection = "patients")
public class Patient {

    @Id
    private String id;

    private String fullname;
    private String email;
    private String telephone;
    private String password;

    // Constructeur vide
    public Patient() {}

    // Constructeur complet
    public Patient(String id, String fullname,  String email, String telephone, String password) {
        this.id = id;
        this.fullname = fullname;
        this.email = email;
        this.telephone = telephone;
        this.password = password;
    }

    // Getters et Setters
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
