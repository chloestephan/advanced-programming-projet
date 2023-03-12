package com.example.gift.service;

import com.example.gift.exception.EntityNotFoundException;
import com.example.gift.model.Tutor;
import com.example.gift.repository.TutorRepository;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TutorService{
    private final TutorRepository repository;

    TutorService(TutorRepository repository) {
        this.repository = repository;
    }

    public List<Tutor> getAll() {
        return repository.findAll();
    }

    public Tutor newTutor(Tutor newTutor) {
        return repository.save(newTutor);
    }

    public Tutor one(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException());
    }
    public void deleteTutor(Long id) {
        repository.deleteById(id);
    }

    public Tutor getFromUsername(String username) {
        return repository.getTutorByUsername(username);
    }
}
