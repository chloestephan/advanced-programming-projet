package com.example.gift.security;

import java.util.Collection;
import java.util.HashSet;

import com.example.gift.model.Tutor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

public class TutorUserDetails implements UserDetails {
    private Tutor tutor;

    public TutorUserDetails(Tutor tutor) {
        this.tutor = tutor;
    }

    // No roles here, so we return an empty set
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return new HashSet<GrantedAuthority>();
    }

    @Override
    public String getPassword() {
        return tutor.getPassword();
    }

    @Override
    public String getUsername() {
        return tutor.getUsername();
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

    public String getFullName() {
        return tutor.getFirstname() + " " + tutor.getLastname();
    }
}
