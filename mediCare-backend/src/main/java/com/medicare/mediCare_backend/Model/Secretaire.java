package com.medicare.mediCare_backend.Model;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "secretaires")
public class Secretaire {
    @Id private String id;
    private String fullname;
    private String email;
    private String password;

    public Secretaire() {}
    public String getId() { return id; }
    public void setId(String id) { this.id = id; }
    public String getFullname() { return fullname; }
    public void setFullname(String f) { this.fullname = f; }
    public String getEmail() { return email; }
    public void setEmail(String e) { this.email = e; }
    public String getPassword() { return password; }
    public void setPassword(String p) { this.password = p; }
}
