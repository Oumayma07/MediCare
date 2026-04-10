package com.medicare.mediCare_backend.Repository;
import com.medicare.mediCare_backend.Model.Secretaire;
import org.springframework.data.mongodb.repository.MongoRepository;
import java.util.Optional;

public interface SecretaireRepository extends MongoRepository<Secretaire, String> {
    Optional<Secretaire> findByEmail(String email);
}
