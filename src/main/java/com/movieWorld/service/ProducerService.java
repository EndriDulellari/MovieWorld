package com.movieWorld.service;

import com.movieWorld.exceptions.RecordNotFoundException;
import com.movieWorld.model.Producer;
import com.movieWorld.repository.ProducerRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class ProducerService {

    private final ProducerRepository repository;

    public List<Producer> getProducers (){
        return repository.findAll();
    }

    public Producer getProducerById(String id){
        return repository.findProducerById(id).orElseThrow(
                () -> new RecordNotFoundException("Producer by Id " + id + "not found!")
        );
    }

    public Producer addUpdateProducer(Producer newProducer){
        return repository.save(newProducer);
    }

    public void deleteProducer(String id){
        repository.deleteProducerById(id);
    }
}
