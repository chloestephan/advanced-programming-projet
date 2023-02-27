package com.apr2023.model;

import java.sql.*;
import java.util.ArrayList;

import static com.apr2023.utils.TextConstants.QUERY_SELECT_INTERNS_FOR_ONE_TUTOR;
import static com.apr2023.utils.TextConstants.QUERY_SELECT_TUTOR_NAME;

/**
 *
 * @author Clochette
 */
public class DBActions {
    private Connection conn;
    private Statement stmt;
    private ResultSet rs;

    public DBActions(String dbUrl, String dbUser, String dbPwd) {
        try {
            conn = DriverManager.getConnection(dbUrl, dbUser, dbPwd);
        } catch (SQLException sqle) {
            System.out.println("Error connecting to database: " + sqle.getMessage() + " " + sqle.getErrorCode());
        }
    }

    public Statement getStatement() {
        try {
            stmt = conn.createStatement();
        } catch (SQLException sqle) {
            System.out.println("Error creating statement: " + sqle.getMessage() + " " + sqle.getErrorCode());
        }
        return stmt;
    }

    public ResultSet getResultSet(String query) {
        stmt = getStatement();
        try {
            rs = stmt.executeQuery(query);
        } catch (SQLException sqle) {
            System.out.println("Error executing query: " + sqle.getMessage() + " " + sqle.getErrorCode());
        }
        return rs;

    }

    public ArrayList<Tutors> getTutorName(int idTutor) {
        ArrayList<Tutors> Tutors = new ArrayList<>();
        String query = QUERY_SELECT_TUTOR_NAME + idTutor;
        rs = getResultSet(query);
        try {
            while (rs.next()) {
                Tutors Tutor = new Tutors();
                Tutor.setId(idTutor);
                Tutor.setName(rs.getString("name"));
                Tutors.add(Tutor);
            }
        } catch (SQLException sqle) {
            System.out.println("Error getting tutor name: " + sqle.getMessage() + " " + sqle.getErrorCode());
        }
        return Tutors;
    }

    public ArrayList<Interns> getAssociationTutorAndInterns(int idTutor) {
        ArrayList<Interns> listAssociationTutorInterns = new ArrayList<>();
        String fullQuery = QUERY_SELECT_INTERNS_FOR_ONE_TUTOR + idTutor;
        rs = getResultSet(fullQuery);

        try {
            while (rs.next()) {
                Interns oneTutorAllInterns = new Interns();
                oneTutorAllInterns.setId(rs.getInt("ID"));
                oneTutorAllInterns.setFirstname(rs.getString("FIRSTNAME"));
                oneTutorAllInterns.setLastname(rs.getString("LASTNAME"));
                oneTutorAllInterns.setGroupe(rs.getString("GROUPE"));
                oneTutorAllInterns.setDebut_stage(rs.getDate("DEBUT_STAGE"));
                oneTutorAllInterns.setFin_stage(rs.getDate("FIN_STAGE"));
                oneTutorAllInterns.setEntreprise(rs.getString("ENTREPRISE"));
                oneTutorAllInterns.setMaitre_de_stage(rs.getString("MAITRE_DE_STAGE"));
                oneTutorAllInterns.setAdresse_stage(rs.getString("ADRESSE_STAGE"));
                oneTutorAllInterns.setCahier_des_charges(rs.getBoolean("CAHIER_DES_CHARGES"));
                oneTutorAllInterns.setFiche_visite(rs.getBoolean("FICHE_VISITE"));
                oneTutorAllInterns.setFiche_evaluation(rs.getBoolean("FICHE_EVALUATION"));
                oneTutorAllInterns.setSondage_web(rs.getBoolean("SONDAGE_WEB"));
                oneTutorAllInterns.setRapport_rendu(rs.getBoolean("RAPPORT_RENDU"));
                oneTutorAllInterns.setSoutenance(rs.getBoolean("SOUTENANCE"));
                oneTutorAllInterns.setVisite_planifiee(rs.getBoolean("VISITE_PLANIFIEE"));
                oneTutorAllInterns.setVisite_faite(rs.getBoolean("VISITE_FAITE"));
                oneTutorAllInterns.setNote_tech(rs.getFloat("NOTE_TECH"));
                oneTutorAllInterns.setNote_com(rs.getFloat("NOTE_COM"));

                listAssociationTutorInterns.add(oneTutorAllInterns);
            }
        } catch (SQLException sqle) {
            System.out.println("Error retrieving data: " + sqle.getMessage() + " " + sqle.getErrorCode());
        }

        return listAssociationTutorInterns;
    }
}
