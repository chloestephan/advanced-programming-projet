package com.example.gift.service;

import com.example.gift.model.Intern;
import com.example.gift.repository.InternRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InternService {
    private final InternRepository repository;

    InternService(InternRepository repository){this.repository = repository;}

    public List<Intern> getAll() {
        return repository.findAll();
    }

    public Intern one(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Internship not found"));
    }
}

