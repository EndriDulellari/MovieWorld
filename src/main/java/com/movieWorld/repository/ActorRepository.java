package com.movieWorld.repository;

import com.movieWorld.model.Actor;
import org.springframework.data.mongodb.repository.MongoRepository;
import java.util.Optional;

public interface ActorRepository extends MongoRepository<Actor, String> {

    Optional<Actor> findActorById(String id);
}
