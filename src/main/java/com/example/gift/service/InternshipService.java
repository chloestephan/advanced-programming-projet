package com.example.gift.service;

import com.example.gift.exception.EntityNotFoundException;
import com.example.gift.model.Internship;
import com.example.gift.repository.InternshipRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InternshipService {
    private final InternshipRepository repository;

    InternshipService(InternshipRepository repository){this.repository = repository;}

    public List<Internship> getInternshipsFromTutorId(String username){
        return repository.findByTutor_Username(username);
    }

    public Internship save(Internship newInternship) {
        return repository.save(newInternship);
    }

    public Internship one(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException());
    }
    public List<Internship> getAll() {
        return repository.findAll();
    }

    public void delete(Long id) {
        repository.deleteById(id);
    }

    public List<Internship> search(String query) {
        return repository.findByIntern_FirstnameContainingIgnoreCaseOrIntern_LastnameContainingIgnoreCaseOrCompanyContainingIgnoreCaseOrSupervisorContainingIgnoreCase(query, query, query, query);
    }
}

