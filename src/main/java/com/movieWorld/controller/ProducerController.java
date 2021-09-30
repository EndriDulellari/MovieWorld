package com.movieWorld.controller;

import com.movieWorld.model.Producer;
import com.movieWorld.service.ProducerService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@AllArgsConstructor
@RequestMapping("/producer")
public class ProducerController {

    private final ProducerService service;

    @GetMapping("/all")
    public ResponseEntity<List<Producer>> getAllProducers(){
        List<Producer> producers = service.getProducers();
        return new ResponseEntity<>(producers, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Producer> getProducerById(@PathVariable("id") String id){
        Producer producer = service.getProducerById(id);
        return new ResponseEntity<>(producer, HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity<Producer> addProducerById(Producer newProducer){
        Producer producer = service.addUpdateProducer(newProducer);
        return new ResponseEntity<>(producer, HttpStatus.OK);
    }

    @PutMapping("/update")
    public ResponseEntity<Producer> updateProducerById(Producer newProducer){
        Producer producer = service.addUpdateProducer(newProducer);
        return new ResponseEntity<>(producer, HttpStatus.OK);
    }

    @PutMapping("/delete/{id}")
    public ResponseEntity<Producer> deleteProducer(@PathVariable("id") String id){
         service.deleteProducer(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
