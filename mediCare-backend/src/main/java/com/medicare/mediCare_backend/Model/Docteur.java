package com.medicare.mediCare_backend.Model;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "docteurs")
public class Docteur {
    @Id private String id;
    private String fullname;
    private String email;
    private String specialite;
    private String password;

    public Docteur() {}
    public String getId() { return id; }
    public void setId(String id) { this.id = id; }
    public String getFullname() { return fullname; }
    public void setFullname(String f) { this.fullname = f; }
    public String getEmail() { return email; }
    public void setEmail(String e) { this.email = e; }
    public String getSpecialite() { return specialite; }
    public void setSpecialite(String s) { this.specialite = s; }
    public String getPassword() { return password; }
    public void setPassword(String p) { this.password = p; }
}
