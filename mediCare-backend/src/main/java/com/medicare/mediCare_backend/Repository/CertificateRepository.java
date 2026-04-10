package com.medicare.mediCare_backend.Repository;
import com.medicare.mediCare_backend.Model.Certificate;
import org.springframework.data.mongodb.repository.MongoRepository;
import java.util.List;

public interface CertificateRepository extends MongoRepository<Certificate, String> {
    List<Certificate> findByPatientEmail(String patientEmail);
}
