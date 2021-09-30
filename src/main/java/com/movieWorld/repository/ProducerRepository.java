package com.movieWorld.repository;

import com.movieWorld.model.Producer;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface ProducerRepository extends MongoRepository <Producer,String> {
    
    Optional<Producer> findProducerById(String id);

    void deleteProducerById(String id);
}
