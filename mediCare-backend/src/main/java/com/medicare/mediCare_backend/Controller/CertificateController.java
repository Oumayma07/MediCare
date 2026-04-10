package com.medicare.mediCare_backend.Controller;

import com.medicare.mediCare_backend.Model.Certificate;
import com.medicare.mediCare_backend.Service.CertificateService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/certificates")
@CrossOrigin(origins = "http://localhost:4200")
public class CertificateController {

    private final CertificateService service;
    public CertificateController(CertificateService service) { this.service = service; }

    @PostMapping("/create")
    public Certificate create(@RequestBody Certificate c) { return service.create(c); }

    @GetMapping("/all")
    public List<Certificate> getAll() { return service.getAll(); }

    @GetMapping("/patient/{email}")
    public List<Certificate> getByPatient(@PathVariable String email) {
        return service.getByPatientEmail(email);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable String id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}
