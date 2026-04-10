package com.medicare.mediCare_backend.Repository;
import com.medicare.mediCare_backend.Model.Appointments;
import org.springframework.data.mongodb.repository.MongoRepository;
import java.util.List;

public interface AppointmentRepository extends MongoRepository<Appointments, String> {
    List<Appointments> findByPatientEmail(String patientEmail);
    List<Appointments> findByDoctorName(String doctorName);
}
