package com.apr2023.model;

import java.sql.*;
import java.util.ArrayList;

import static com.apr2023.utils.TextConstants.*;

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

    public String getTutorName(int idTutor) {
        String tutorName = "";
        String query = QUERY_SELECT_TUTOR_NAME + idTutor;
        rs = getResultSet(query);
        try {
            while (rs.next()) {
                tutorName = rs.getString("name");
            }
        } catch (SQLException sqle) {
            System.out.println("Error getting tutor name: " + sqle.getMessage() + " " + sqle.getErrorCode());
        }
        return tutorName;
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
                oneTutorAllInterns.setId_Tutor(rs.getInt("ID_TUTOR"));

                listAssociationTutorInterns.add(oneTutorAllInterns);
            }
        } catch (SQLException sqle) {
            System.out.println("Error retrieving data: " + sqle.getMessage() + " " + sqle.getErrorCode());
        }

        return listAssociationTutorInterns;
    }

    public ArrayList<Interns> getInternInfoToModify(int idIntern) {
        ArrayList<Interns> intern = new ArrayList<>();
        String fullQuery = QUERY_GET_ALL_INTERN_INFO + idIntern;
        rs = getResultSet(fullQuery);

        try {
            while (rs.next()) {
                Interns internInfo = new Interns();
                internInfo.setId(rs.getInt("ID"));
                internInfo.setFirstname(rs.getString("FIRSTNAME"));
                internInfo.setLastname(rs.getString("LASTNAME"));
                internInfo.setEmail(rs.getString("EMAIL"));
                internInfo.setGroupe(rs.getString("GROUPE"));
                internInfo.setDebut_stage(rs.getDate("DEBUT_STAGE"));
                internInfo.setFin_stage(rs.getDate("FIN_STAGE"));
                internInfo.setEntreprise(rs.getString("ENTREPRISE"));
                internInfo.setMaitre_de_stage(rs.getString("MAITRE_DE_STAGE"));
                internInfo.setAdresse_stage(rs.getString("ADRESSE_STAGE"));
                internInfo.setCahier_des_charges(rs.getBoolean("CAHIER_DES_CHARGES"));
                internInfo.setFiche_visite(rs.getBoolean("FICHE_VISITE"));
                internInfo.setFiche_evaluation(rs.getBoolean("FICHE_EVALUATION"));
                internInfo.setSondage_web(rs.getBoolean("SONDAGE_WEB"));
                internInfo.setRapport_rendu(rs.getBoolean("RAPPORT_RENDU"));
                internInfo.setSoutenance(rs.getBoolean("SOUTENANCE"));
                internInfo.setVisite_planifiee(rs.getBoolean("VISITE_PLANIFIEE"));
                internInfo.setVisite_faite(rs.getBoolean("VISITE_FAITE"));
                internInfo.setNote_tech(rs.getFloat("NOTE_TECH"));
                internInfo.setNote_com(rs.getFloat("NOTE_COM"));
                internInfo.setId_Tutor(rs.getInt("ID_TUTOR"));

                intern.add(internInfo);
            }
        } catch (SQLException sqle) {
            System.out.println("Error retrieving data: " + sqle.getMessage() + " " + sqle.getErrorCode());
        }

        return intern;
    }

    public boolean isCheckedCahier_Des_Charges(int idIntern) {
        boolean isChecked = false;
        String fullQuery = "SELECT CAHIER_DES_CHARGES FROM interns WHERE id = " + idIntern;
        rs = getResultSet(fullQuery);

        try {
            while (rs.next()) {
                isChecked = rs.getBoolean("CAHIER_DES_CHARGES");
            }
        } catch (SQLException sqle) {
            System.out.println("Error retrieving data: " + sqle.getMessage() + " " + sqle.getErrorCode());
        }

        return isChecked;
    }

    public boolean isCheckedFiche_Visite(int idIntern) {
        boolean isChecked = false;
        String fullQuery = "SELECT FICHE_VISITE FROM interns WHERE id = " + idIntern;
        rs = getResultSet(fullQuery);

        try {
            while (rs.next()) {
                isChecked = rs.getBoolean("FICHE_VISITE");
            }
        } catch (SQLException sqle) {
            System.out.println("Error retrieving data: " + sqle.getMessage() + " " + sqle.getErrorCode());
        }

        return isChecked;
    }

    public boolean isCheckedFiche_Evaluation(int idIntern) {
        boolean isChecked = false;
        String fullQuery = "SELECT FICHE_EVALUATION FROM interns WHERE id = " + idIntern;
        rs = getResultSet(fullQuery);

        try {
            while (rs.next()) {
                isChecked = rs.getBoolean("FICHE_EVALUATION");
            }
        } catch (SQLException sqle) {
            System.out.println("Error retrieving data: " + sqle.getMessage() + " " + sqle.getErrorCode());
        }

        return isChecked;
    }

    public boolean isCheckedSondage_Web(int idIntern) {
        boolean isChecked = false;
        String fullQuery = "SELECT SONDAGE_WEB FROM interns WHERE id = " + idIntern;
        rs = getResultSet(fullQuery);

        try {
            while (rs.next()) {
                isChecked = rs.getBoolean("SONDAGE_WEB");
            }
        } catch (SQLException sqle) {
            System.out.println("Error retrieving data: " + sqle.getMessage() + " " + sqle.getErrorCode());
        }

        return isChecked;
    }

    public boolean isCheckedRapport_Rendu(int idIntern) {
        boolean isChecked = false;
        String fullQuery = "SELECT RAPPORT_RENDU FROM interns WHERE id = " + idIntern;
        rs = getResultSet(fullQuery);

        try {
            while (rs.next()) {
                isChecked = rs.getBoolean("RAPPORT_RENDU");
            }
        } catch (SQLException sqle) {
            System.out.println("Error retrieving data: " + sqle.getMessage() + " " + sqle.getErrorCode());
        }

        return isChecked;
    }

    public boolean isCheckedSoutenance(int idIntern) {
        boolean isChecked = false;
        String fullQuery = "SELECT SOUTENANCE FROM interns WHERE id = " + idIntern;
        rs = getResultSet(fullQuery);

        try {
            while (rs.next()) {
                isChecked = rs.getBoolean("SOUTENANCE");
            }
        } catch (SQLException sqle) {
            System.out.println("Error retrieving data: " + sqle.getMessage() + " " + sqle.getErrorCode());
        }

        return isChecked;
    }

    public boolean isCheckedVisite_Planifiee(int idIntern) {
        boolean isChecked = false;
        String fullQuery = "SELECT VISITE_PLANIFIEE FROM interns WHERE id = " + idIntern;
        rs = getResultSet(fullQuery);

        try {
            while (rs.next()) {
                isChecked = rs.getBoolean("VISITE_PLANIFIEE");
            }
        } catch (SQLException sqle) {
            System.out.println("Error retrieving data: " + sqle.getMessage() + " " + sqle.getErrorCode());
        }

        return isChecked;
    }

    public boolean isCheckedVisite_Faite(int idIntern) {
        boolean isChecked = false;
        String fullQuery = "SELECT VISITE_FAITE FROM interns WHERE id = " + idIntern;
        rs = getResultSet(fullQuery);

        try {
            while (rs.next()) {
                isChecked = rs.getBoolean("VISITE_FAITE");
            }
        } catch (SQLException sqle) {
            System.out.println("Error retrieving data: " + sqle.getMessage() + " " + sqle.getErrorCode());
        }

        return isChecked;
    }
}
