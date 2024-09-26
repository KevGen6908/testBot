package org.example.db.dao.repository;


import org.example.db.dao.entity.Preference;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import reactor.core.publisher.Flux;

public interface PreferencesRepository extends ReactiveCrudRepository<Preference, Long> {
    Flux<Preference> findByUserId(Long userId);
}
