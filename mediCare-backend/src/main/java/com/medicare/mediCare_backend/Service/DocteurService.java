package com.medicare.mediCare_backend.Service;

import com.medicare.mediCare_backend.Model.Docteur;
import com.medicare.mediCare_backend.Repository.DocteurRepository;
import org.springframework.stereotype.Service;
import java.util.Optional;

@Service
public class DocteurService {
    private final DocteurRepository repo;
    public DocteurService(DocteurRepository repo) { this.repo = repo; }

    public Docteur save(Docteur d) { return repo.save(d); }

    public Optional<Docteur> login(String email, String password) {
        return repo.findByEmail(email).filter(d -> d.getPassword().equals(password));
    }

    public boolean emailExists(String email) { return repo.findByEmail(email).isPresent(); }
}
