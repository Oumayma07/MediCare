package com.medicare.mediCare_backend.Model;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "certificates")
public class Certificate {
    @Id private String id;
    private String patientEmail;
    private String patientName;
    private String doctorName;
    private String type;
    private String date;
    private String notes;

    public Certificate() {}
    public String getId() { return id; }
    public void setId(String id) { this.id = id; }
    public String getPatientEmail() { return patientEmail; }
    public void setPatientEmail(String e) { this.patientEmail = e; }
    public String getPatientName() { return patientName; }
    public void setPatientName(String n) { this.patientName = n; }
    public String getDoctorName() { return doctorName; }
    public void setDoctorName(String d) { this.doctorName = d; }
    public String getType() { return type; }
    public void setType(String t) { this.type = t; }
    public String getDate() { return date; }
    public void setDate(String d) { this.date = d; }
    public String getNotes() { return notes; }
    public void setNotes(String n) { this.notes = n; }
}
