package com.medicare.mediCare_backend.Controller;

import com.medicare.mediCare_backend.Model.Patient;
import com.medicare.mediCare_backend.Service.PatientService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.Map;

@RestController
@RequestMapping("/api/patients")
@CrossOrigin(origins = "http://localhost:4200")
public class PatientController {

    private final PatientService service;
    public PatientController(PatientService service) { this.service = service; }

    @PostMapping("/register")
    public ResponseEntity<?> register(@RequestBody Patient patient) {
        if (service.emailExists(patient.getEmail()))
            return ResponseEntity.badRequest().body(Map.of("message", "Email déjà utilisé"));
        return ResponseEntity.ok(service.save(patient));
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody Patient patient) {
        return service.login(patient.getEmail(), patient.getPassword())
                .map(p -> ResponseEntity.ok(p))
                .orElse(ResponseEntity.status(401).build());
    }

    @GetMapping("/{email}")
    public ResponseEntity<Patient> getByEmail(@PathVariable String email) {
        return service.findByEmail(email)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PutMapping("/{id}")
    public ResponseEntity<Patient> update(@PathVariable String id, @RequestBody Patient p) {
        return ResponseEntity.ok(service.update(id, p));
    }
}
