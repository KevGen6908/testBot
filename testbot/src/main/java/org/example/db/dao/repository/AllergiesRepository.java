package org.example.db.dao.repository;


import org.example.db.dao.entity.Allergy;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import reactor.core.publisher.Flux;

public interface AllergiesRepository extends ReactiveCrudRepository<Allergy, Long> {
    Flux<Allergy> findByUserId(Long userId);
}

