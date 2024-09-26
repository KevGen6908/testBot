package org.example.db.dao.repository;


import org.example.db.dao.entity.User;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import reactor.core.publisher.Mono;

public interface UserRepository extends ReactiveCrudRepository<User, Long> {
    Mono<User> findByUsername(String username);// можно потом использовать в getUserIdByUsername UserService, но нужно изменить и UserDAO
}