/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.apr2023.model;

import java.util.Date;

/**
 *
 * @author Clochette
 */
public class Interns {

    private int id;
    private String firstname;
    private String lastname;
    private String username;
    private String email;
    private String groupe;
    private Date debut_stage;
    private Date fin_stage;
    private String entreprise;
    private String maitre_de_stage;
    private String adresse_stage;
    private boolean cahier_des_charges;
    private boolean fiche_visite;
    private boolean fiche_evaluation;
    private boolean sondage_web;
    private boolean rapport_rendu;
    private boolean soutenance;
    private boolean visite_planifiee;
    private boolean visite_faite;

    private float note_tech;
    private float note_com;


    public int getId() {
        return id;
    }

    public void setId(int id) {
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

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getGroupe() {
        return groupe;
    }

    public void setGroupe(String groupe) {
        this.groupe = groupe;
    }

    public Date getDebut_stage() {
        return debut_stage;
    }

    public void setDebut_stage(Date debut_stage) {
        this.debut_stage = debut_stage;
    }

    public Date getFin_stage() {
        return fin_stage;
    }

    public void setFin_stage(Date fin_stage) {
        this.fin_stage = fin_stage;
    }

    public String getEntreprise() {
        return entreprise;
    }

    public void setEntreprise(String entreprise) {
        this.entreprise = entreprise;
    }

    public String getMaitre_de_stage() {
        return maitre_de_stage;
    }

    public void setMaitre_de_stage(String maitre_de_stage) {
        this.maitre_de_stage = maitre_de_stage;
    }

    public String getAdresse_stage() {
        return adresse_stage;
    }

    public void setAdresse_stage(String adresse_stage) {
        this.adresse_stage = adresse_stage;
    }

    public String getCahier_des_charges() {
        return cahier_des_charges ? "\uD83D\uDDF8" : "⛌";
    }

    public void setCahier_des_charges(Boolean cahier_des_charges) {
        this.cahier_des_charges = cahier_des_charges;
    }

    public String getFiche_visite() {
        return fiche_visite ? "\uD83D\uDDF8" : "⛌";
    }

    public void setFiche_visite(Boolean fiche_visite) {
        this.fiche_visite = fiche_visite;
    }

    public String getFiche_evaluation() {
        return fiche_evaluation ? "\uD83D\uDDF8" : "⛌";
    }

    public void setFiche_evaluation(Boolean fiche_evaluation) {
        this.fiche_evaluation = fiche_evaluation;
    }

    public String getSondage_web() {
        return sondage_web ? "\uD83D\uDDF8" : "⛌";
    }

    public void setSondage_web(Boolean sondage_web) {
        this.sondage_web = sondage_web;
    }

    public String getRapport_rendu() {
        return rapport_rendu ? "\uD83D\uDDF8" : "⛌";
    }

    public void setRapport_rendu(Boolean rapport_rendu) {
        this.rapport_rendu = rapport_rendu;
    }

    public String getSoutenance() {
        return soutenance ? "\uD83D\uDDF8" : "⛌";
    }

    public void setSoutenance(Boolean soutenance) {
        this.soutenance = soutenance;
    }

    public String getVisite_planifiee() {
        return visite_planifiee ? "\uD83D\uDDF8" : "⛌";
    }

    public void setVisite_planifiee(Boolean visite_planifiee) {
        this.visite_planifiee = visite_planifiee;
    }

    public String getVisite_faite() {
        return visite_faite ? "\uD83D\uDDF8" : "⛌";
    }

    public void setVisite_faite(Boolean visite_faite) {
        this.visite_faite = visite_faite;
    }

    public String getNote_tech() {
        if (note_tech == 0.0) {
            return " ";
        } else {
            return String.valueOf(note_tech);
        }
    }

    public void setNote_tech(float note_tech) {
        this.note_tech = note_tech;
    }

    public String getNote_com() {
        if (note_com == 0.0) {
            return " ";
        } else {
            return String.valueOf(note_com);
        }
    }

    public void setNote_com(float note_com) {
        this.note_com = note_com;
    }

}
