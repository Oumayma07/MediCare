package com.medicare.mediCare_backend.Model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "appointments")
public class Appointments {

    @Id private String id;
    private String fullname;
    private String patientEmail;
    private String doctorName;
    private String date;
    private String heure;
    private String status;
    private String motif;

    public Appointments() {}

    // ✅ BUG CORRIGÉ : this.status = status (était this.heure = status)
    public Appointments(String id, String fullname, String patientEmail,
                        String doctorName, String date, String heure,
                        String status, String motif) {
        this.id = id; this.fullname = fullname; this.patientEmail = patientEmail;
        this.doctorName = doctorName; this.date = date; this.heure = heure;
        this.status = status; this.motif = motif;
    }

    public String getId() { return id; }
    public void setId(String id) { this.id = id; }
    public String getFullname() { return fullname; }
    public void setFullname(String fullname) { this.fullname = fullname; }
    public String getPatientEmail() { return patientEmail; }
    public void setPatientEmail(String e) { this.patientEmail = e; }
    public String getDoctorName() { return doctorName; }
    public void setDoctorName(String d) { this.doctorName = d; }
    public String getDate() { return date; }
    public void setDate(String date) { this.date = date; }
    public String getHeure() { return heure; }
    public void setHeure(String heure) { this.heure = heure; }
    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }
    public String getMotif() { return motif; }
    public void setMotif(String motif) { this.motif = motif; }
}
