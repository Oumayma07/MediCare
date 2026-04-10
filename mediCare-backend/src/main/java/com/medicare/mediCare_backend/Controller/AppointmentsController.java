package com.medicare.mediCare_backend.Controller;

import com.medicare.mediCare_backend.Model.Appointments;
import com.medicare.mediCare_backend.Service.AppointmentsService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/appointments")
@CrossOrigin(origins = "http://localhost:4200")
public class AppointmentsController {

    private final AppointmentsService service;
    public AppointmentsController(AppointmentsService service) { this.service = service; }

    @PostMapping("/create")
    public Appointments create(@RequestBody Appointments a) { return service.create(a); }

    @GetMapping("/all")
    public List<Appointments> getAll() { return service.getAll(); }

    @GetMapping("/patient/{email}")
    public List<Appointments> getByPatient(@PathVariable String email) {
        return service.getByPatientEmail(email);
    }

    @GetMapping("/doctor/{name}")
    public List<Appointments> getByDoctor(@PathVariable String name) {
        return service.getByDoctor(name);
    }

    @PatchMapping("/{id}/status")
    public ResponseEntity<?> updateStatus(@PathVariable String id,
                                          @RequestBody Map<String, String> body) {
        return service.updateStatus(id, body.get("status"))
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable String id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}
