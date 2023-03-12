package com.example.gift.security;

import com.example.gift.model.Tutor;
import com.example.gift.repository.TutorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class TutorUserDetailService implements UserDetailsService {

    @Autowired
    private TutorRepository tutorRepository;

    @Override
    public UserDetails loadUserByUsername(String username)
            throws UsernameNotFoundException {
        Tutor tutor = tutorRepository.getTutorByUsername(username);

        if (tutor == null) {
            throw new UsernameNotFoundException("Could not find tutor");
        }
        return new TutorUserDetails(tutor);
    }

}