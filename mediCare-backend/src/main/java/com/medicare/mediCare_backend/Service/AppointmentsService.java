package com.medicare.mediCare_backend.Service;

import com.medicare.mediCare_backend.Model.Appointments;
import com.medicare.mediCare_backend.Repository.AppointmentRepository;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class AppointmentsService {

    private final AppointmentRepository repo;

    public AppointmentsService(AppointmentRepository repo) { this.repo = repo; }

    public Appointments create(Appointments a) {
        a.setStatus("EN_ATTENTE");
        return repo.save(a);
    }

    public List<Appointments> getAll() { return repo.findAll(); }

    public List<Appointments> getByPatientEmail(String email) {
        return repo.findByPatientEmail(email);
    }

    public List<Appointments> getByDoctor(String doctorName) {
        return repo.findByDoctorName(doctorName);
    }

    public Optional<Appointments> updateStatus(String id, String status) {
        return repo.findById(id).map(a -> { a.setStatus(status); return repo.save(a); });
    }

    public void delete(String id) { repo.deleteById(id); }
}
