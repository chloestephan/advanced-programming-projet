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

import javax.xml.transform.Result;
import java.io.IOException;
import java.io.InputStream;
import java.sql.*;
import java.util.Properties;

/*
 * @author Clochette
 */
public class PrepareModifyInternController extends HttpServlet {

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

            // *** get intern infos ***
            //get intern id
            String internId = request.getParameter("internId");
            int idIntern = Integer.parseInt(internId);

            //get the info
            HttpSession session = request.getSession();
            int tutorId = (int) session.getAttribute("tutorId");
            request.setAttribute("listInternsPerTutor", dbActions.getAssociationTutorAndInterns(tutorId));
            request.setAttribute("internInfo", dbActions.getInternInfoToModify(idIntern));
            request.setAttribute("isCheckedCDC", dbActions.isCheckedCahier_Des_Charges(idIntern));
            request.setAttribute("isCheckedFV", dbActions.isCheckedFiche_Visite(idIntern));
            request.setAttribute("isCheckedFE", dbActions.isCheckedFiche_Evaluation(idIntern));
            request.setAttribute("isCheckedSW", dbActions.isCheckedSondage_Web(idIntern));
            request.setAttribute("isCheckedRR", dbActions.isCheckedRapport_Rendu(idIntern));
            request.setAttribute("isCheckedS", dbActions.isCheckedSoutenance(idIntern));
            request.setAttribute("isCheckedVP", dbActions.isCheckedVisite_Planifiee(idIntern));
            request.setAttribute("isCheckedVF", dbActions.isCheckedVisite_Faite(idIntern));

            request.getRequestDispatcher(TextConstants.JSP_MODIFY_INTERN_PAGE).forward(request, response);
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
