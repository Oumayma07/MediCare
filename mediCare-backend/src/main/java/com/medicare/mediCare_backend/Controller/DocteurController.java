package com.medicare.mediCare_backend.Controller;

import com.medicare.mediCare_backend.Model.Docteur;
import com.medicare.mediCare_backend.Service.DocteurService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/docteurs")
@CrossOrigin(origins = "http://localhost:4200")
public class DocteurController {

    private final DocteurService service;
    public DocteurController(DocteurService service) { this.service = service; }

    @PostMapping("/register")
    public ResponseEntity<?> register(@RequestBody Docteur d) {
        if (service.emailExists(d.getEmail()))
            return ResponseEntity.badRequest().body(java.util.Map.of("message","Email déjà utilisé"));
        return ResponseEntity.ok(service.save(d));
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody Docteur d) {
        return service.login(d.getEmail(), d.getPassword())
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.status(401).build());
    }
}
