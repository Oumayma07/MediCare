package com.medicare.mediCare_backend.Repository;
import com.medicare.mediCare_backend.Model.Docteur;
import org.springframework.data.mongodb.repository.MongoRepository;
import java.util.Optional;

public interface DocteurRepository extends MongoRepository<Docteur, String> {
    Optional<Docteur> findByEmail(String email);
}
