package com.movieWorld.controller;

import com.movieWorld.model.Actor;
import com.movieWorld.service.ActorService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/actor")
@AllArgsConstructor
public class ActorController {

    private final ActorService service;



    @GetMapping("/all")
    public ResponseEntity<List<Actor>> getActors(){
        List<Actor> actors = service.getActors();
        return new ResponseEntity<>(actors, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Actor> findActorById(@PathVariable("id") String id) {
        Actor product = service.findActorById(id);
        return new ResponseEntity<>(product, HttpStatus.OK);
    }


    @PostMapping("/add")
    public ResponseEntity<Actor> addProduct(@RequestBody Actor newActor) {
        Actor actor = service.addOrUpdateActor(newActor);
        return new ResponseEntity<>(actor, HttpStatus.CREATED);
    }

    @PutMapping("/update")
    public ResponseEntity<Actor> updateProduct(@RequestBody Actor updateActor) {
        Actor actor = service.addOrUpdateActor(updateActor);
        return new ResponseEntity<>(actor, HttpStatus.OK);
    }

    @PutMapping("/delete/{id}")
    public ResponseEntity<Actor> deleteProduct(@PathVariable("id") String id) {
        service.deleteActor(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
