package com.medicare.mediCare_backend.Service;

import com.medicare.mediCare_backend.Model.Secretaire;
import com.medicare.mediCare_backend.Repository.SecretaireRepository;
import org.springframework.stereotype.Service;
import java.util.Optional;

@Service
public class SecretaireService {
    private final SecretaireRepository repo;
    public SecretaireService(SecretaireRepository repo) { this.repo = repo; }

    public Secretaire save(Secretaire s) { return repo.save(s); }

    public Optional<Secretaire> login(String email, String password) {
        return repo.findByEmail(email).filter(s -> s.getPassword().equals(password));
    }

    public boolean emailExists(String email) { return repo.findByEmail(email).isPresent(); }
}
