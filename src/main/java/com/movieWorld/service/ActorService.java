package com.movieWorld.service;

import com.movieWorld.exceptions.RecordNotFoundException;
import com.movieWorld.model.Actor;
import com.movieWorld.repository.ActorRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class ActorService {

    private final ActorRepository repository;

    public List<Actor> getActors(){
        return repository.findAll();
    }

    public Actor findActorById (String id){
        return repository.findActorById(id).orElseThrow(
                () -> new RecordNotFoundException("Actor by Id " + id + "not found!")
        );
    }

    public Actor addOrUpdateActor (Actor newActor){
        return repository.save(newActor);
    }

    public void deleteActor(String id){
        repository.deleteById(id);
    }
}
