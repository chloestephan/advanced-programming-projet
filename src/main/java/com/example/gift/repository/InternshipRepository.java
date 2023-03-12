package com.example.gift.repository;

import com.example.gift.model.Internship;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface InternshipRepository extends JpaRepository<Internship, Long> {
    List<Internship> findByTutor_Username(String username);
    List<Internship> findByIntern_FirstnameContainingIgnoreCaseOrIntern_LastnameContainingIgnoreCaseOrCompanyContainingIgnoreCaseOrSupervisorContainingIgnoreCase(String firstname, String lastname, String company, String supervisor);


}
