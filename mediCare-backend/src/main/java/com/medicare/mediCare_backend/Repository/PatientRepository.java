package com.medicare.mediCare_backend.Repository;

import java.util.Optional;
import org.springframework.data.mongodb.repository.MongoRepository;

import com.medicare.mediCare_backend.Model.Patient;

public interface PatientRepository extends MongoRepository<Patient, String> {
    Optional<Patient> findByEmail(String email);
}
