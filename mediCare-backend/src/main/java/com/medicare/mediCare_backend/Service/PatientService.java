package com.medicare.mediCare_backend.Service;

import com.medicare.mediCare_backend.Model.Patient;
import com.medicare.mediCare_backend.Repository.PatientRepository;
import org.springframework.stereotype.Service;
import java.util.Optional;

@Service
public class PatientService {

    private final PatientRepository repo;
    public PatientService(PatientRepository repo) { this.repo = repo; }

    public Patient save(Patient p) { return repo.save(p); }

    public Optional<Patient> login(String email, String password) {
        return repo.findByEmail(email).filter(p -> p.getPassword().equals(password));
    }

    public boolean emailExists(String email) { return repo.findByEmail(email).isPresent(); }

    public Optional<Patient> findByEmail(String email) { return repo.findByEmail(email); }

    public Patient update(String id, Patient data) {
        return repo.findById(id).map(p -> {
            if (data.getFullname() != null) p.setFullname(data.getFullname());
            if (data.getTelephone() != null) p.setTelephone(data.getTelephone());
            if (data.getPassword() != null) p.setPassword(data.getPassword());
            return repo.save(p);
        }).orElseThrow(() -> new RuntimeException("Patient non trouvé"));
    }
}
