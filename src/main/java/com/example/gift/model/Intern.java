package com.example.gift.model;

import jakarta.persistence.*;
@Entity
public class Intern {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String firstname;
    private String lastname;
    private String groupe; // "group" is a reserved mysql keyword
    protected Intern() {}
    Intern(long id, String firstname, String lastname, String group) {
        this.id = id;
        this.firstname = firstname;
        this.lastname = lastname;
        this.groupe = group;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getGroupe() {
        return groupe;
    }

    public void setGroupe(String groupe) {
        this.groupe = groupe;
    }
}