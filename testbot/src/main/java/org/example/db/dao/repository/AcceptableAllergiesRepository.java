package org.example.db.dao.repository;


import org.example.db.dao.entity.AcceptableAllergy;
import org.springframework.data.r2dbc.repository.Query;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import reactor.core.publisher.Flux;

public interface AcceptableAllergiesRepository extends ReactiveCrudRepository<AcceptableAllergy, Long> {
    Flux<AcceptableAllergy> findAll();
    @Query("SELECT * FROM acceptable_allergies ORDER BY RANDOM() LIMIT :limit")
    Flux<AcceptableAllergy> findRandomAllergies(int limit);
}
