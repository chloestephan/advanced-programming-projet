package com.example.gift.repository;

import com.example.gift.model.Tutor;
import org.springframework.data.jpa.repository.JpaRepository;
public interface TutorRepository extends JpaRepository<Tutor, Long> {
    Tutor getTutorByUsername(String username);
}