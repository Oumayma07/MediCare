package com.medicare.mediCare_backend.Service;

import com.medicare.mediCare_backend.Model.Certificate;
import com.medicare.mediCare_backend.Repository.CertificateRepository;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class CertificateService {
    private final CertificateRepository repo;
    public CertificateService(CertificateRepository repo) { this.repo = repo; }

    public Certificate create(Certificate c) { return repo.save(c); }
    public List<Certificate> getAll() { return repo.findAll(); }
    public List<Certificate> getByPatientEmail(String email) { return repo.findByPatientEmail(email); }
    public void delete(String id) { repo.deleteById(id); }
}
