package com.apr2023.ctrl;

import com.apr2023.model.DBActions;
import com.apr2023.utils.TextConstants;
import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.io.InputStream;
import java.sql.*;
import java.util.Properties;

/*
 * @author Clochette
 */
public class modifyInternController extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request  servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException      if an I/O error occurs
     */

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, SQLException {

        Properties prop = new Properties();
        InputStream inputStream = getServletContext().getResourceAsStream(TextConstants.DB_CONFIG_PATH);
        prop.load(inputStream);

        String dbUrl = prop.getProperty("dbUrl");
        String dbUser = prop.getProperty("dbUser");
        String dbPwd = prop.getProperty("dbPwd");

        if (request.getParameter("action") == null) {
            request.getRequestDispatcher(TextConstants.JSP_HOME_PAGE).forward(request, response);
        } else {
            DBActions dbActions = new DBActions(dbUrl, dbUser, dbPwd);

            // Establish a connection to the database
            Connection connection;
            try {
                connection = DriverManager.getConnection(dbUrl, dbUser, dbPwd);
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
            String sql = TextConstants.QUERY_UPDATE_INTERN;
            PreparedStatement stmt = connection.prepareStatement(sql);

            //get the parameters to insert into the database
            String username = request.getParameter("firstName").toLowerCase() + "_" + request.getParameter("lastName").toLowerCase();

            String internId = request.getParameter("internId");
            int IdInterParam = Integer.parseInt(internId);

            String cahierDesChargesBool = request.getParameter("cahierDesCharges");
            boolean cahierDesCharges = cahierDesChargesBool != null && cahierDesChargesBool.equals("on");

            String ficheVisiteBool = request.getParameter("ficheVisite");
            boolean ficheVisite = ficheVisiteBool != null && ficheVisiteBool.equals("on");

            String ficheEvaluationBool = request.getParameter("ficheEvaluation");
            boolean ficheEvaluation = ficheEvaluationBool != null && ficheEvaluationBool.equals("on");

            String sondageWebBool = request.getParameter("sondageWeb");
            boolean sondageWeb = sondageWebBool != null && sondageWebBool.equals("on");

            String rapportRenduBool = request.getParameter("rapportRendu");
            boolean rapportRendu = rapportRenduBool != null && rapportRenduBool.equals("on");

            String soutenanceBool = request.getParameter("soutenance");
            boolean soutenance = soutenanceBool != null && soutenanceBool.equals("on");

            String visitePlanifieeBool = request.getParameter("visitePlanifiee");
            boolean visitePlanifiee = visitePlanifieeBool != null && visitePlanifieeBool.equals("on");

            String visiteFaiteBool = request.getParameter("visiteFaite");
            boolean visiteFaite = visiteFaiteBool != null && visiteFaiteBool.equals("on");

            //accept empty values for note tech and note com when modifying an intern
            String noteTechParam = request.getParameter("noteTechModified");
            float noteTech = 0;
            if (noteTechParam != null && !noteTechParam.equals("")) {
                noteTech = Float.parseFloat(noteTechParam);
            }

            String noteComParam = request.getParameter("noteComModified");
            float noteCom = 0;
            if (noteComParam != null && !noteComParam.equals("")) {
                noteCom = Float.parseFloat(noteComParam);
            }

            int InternId = Integer.parseInt(request.getParameter("internId"));

            // set the parameters of the sql request
            stmt.setString(1, request.getParameter("firstName"));
            stmt.setString(2, request.getParameter("lastName"));
            stmt.setString(3, username);
            stmt.setString(4, request.getParameter("email"));
            stmt.setString(5, request.getParameter("groupe"));
            stmt.setString(6, request.getParameter("debutDuStage"));
            stmt.setString(7, request.getParameter("finDuStage"));
            stmt.setString(8, request.getParameter("entreprise"));
            stmt.setString(9, request.getParameter("maitreDeStage"));
            stmt.setString(10, request.getParameter("adresse_stage"));
            stmt.setBoolean(11, cahierDesCharges);
            stmt.setBoolean(12, ficheVisite);
            stmt.setBoolean(13, ficheEvaluation);
            stmt.setBoolean(14, sondageWeb);
            stmt.setBoolean(15, rapportRendu);
            stmt.setBoolean(16, soutenance);
            stmt.setBoolean(17, visitePlanifiee);
            stmt.setBoolean(18, visiteFaite);
            stmt.setFloat(19, noteTech);
            stmt.setFloat(20, noteCom);
            stmt.setInt(21, InternId);

            stmt.executeUpdate();
            connection.close();

            HttpSession session = request.getSession();
            int tutorId = (int) session.getAttribute("tutorId");
            request.setAttribute("listInternsPerTutor", dbActions.getAssociationTutorAndInterns(tutorId));
            request.getRequestDispatcher(TextConstants.JSP_HOME_PAGE).forward(request, response);
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">

    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request  servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException      if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request  servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException      if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>
}
