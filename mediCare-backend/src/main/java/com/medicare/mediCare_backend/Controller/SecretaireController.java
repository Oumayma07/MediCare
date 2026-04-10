package com.medicare.mediCare_backend.Controller;

import com.medicare.mediCare_backend.Model.Secretaire;
import com.medicare.mediCare_backend.Service.SecretaireService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/secretaires")
@CrossOrigin(origins = "http://localhost:4200")
public class SecretaireController {

    private final SecretaireService service;
    public SecretaireController(SecretaireService service) { this.service = service; }

    @PostMapping("/register")
    public ResponseEntity<?> register(@RequestBody Secretaire s) {
        if (service.emailExists(s.getEmail()))
            return ResponseEntity.badRequest().body(java.util.Map.of("message","Email déjà utilisé"));
        return ResponseEntity.ok(service.save(s));
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody Secretaire s) {
        return service.login(s.getEmail(), s.getPassword())
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.status(401).build());
    }
}
