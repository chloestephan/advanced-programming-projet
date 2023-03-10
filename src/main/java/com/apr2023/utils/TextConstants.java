/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.apr2023.utils;

/**
 *
 * @author Clochette
 */
public class TextConstants {

    //sql queries
    public static final String QUERY_GET_TUTOR_INFO = "SELECT * FROM tutors WHERE username = ?";
    public static final String QUERY_GET_INTERN_ID = "SELECT id FROM interns WHERE username = ?";
    public static final String QUERY_SELECT_INTERNS_FOR_ONE_TUTOR = "SELECT * FROM INTERNS WHERE id_tutor =";
    public static final String QUERY_SELECT_TUTOR_NAME = "SELECT name FROM tutors WHERE id = ";
    public static final String QUERY_INSERT_NEW_INTERN = "INSERT INTO interns (firstname, lastname, username, email, groupe, debut_stage, fin_stage, entreprise, maitre_de_stage, adresse_stage, cahier_des_charges, fiche_visite, fiche_evaluation, sondage_web, rapport_rendu, soutenance, visite_planifiee, visite_faite, note_tech, note_com, id_tutor) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
    public static final String QUERY_DELETE_INTERN = "DELETE FROM interns WHERE id = ?";
    public static final String QUERY_UPDATE_INTERN = "UPDATE interns SET firstname = ?, lastname = ?, email = ?, groupe = ?, debut_stage = ?, fin_stage = ?, entreprise = ?, maitre_de_stage = ?, adresse_stage = ?, cahier_des_charges = ?, fiche_visite = ?, fiche_evaluation = ?, sondage_web = ?, rapport_rendu = ?, soutenance = ?, visite_planifiee = ?, visite_faite = ?, note_tech = ?, note_com = ? WHERE id = ?";
    public static final String QUERY_GET_ALL_INTERN_INFO = "SELECT * FROM interns WHERE id = ";

    //code efficiency
    public static final String ERROR_MESSAGE = "Invalid credentials! Please try again.";
    public static final String JSP_LOGIN_PAGE = "/WEB-INF/pages/login.jsp";
    public static final String JSP_HOME_PAGE = "/WEB-INF/pages/homepage.jsp";
    public static final String FORM_LOGIN_FIELD_NAME = "loginField";
    public static final String FORM_PWD_FIELD_NAME = "pwdField";
    public static final String DB_CONFIG_PATH = "/WEB-INF/db.properties";

    public static final String JSP_MODIFY_INTERN_PAGE = "/WEB-INF/pages/modifyIntern.jsp";

}

