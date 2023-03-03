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
public class removeInternController extends HttpServlet {

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

            // *** get intern infos ***
            //TODO : validate before deleting

            //delete an intern from the database
            String sql = TextConstants.QUERY_DELETE_INTERN;
            PreparedStatement stmt = connection.prepareStatement(sql);
            String internId = request.getParameter("internId");
            int idIntern = Integer.parseInt(internId);
            stmt.setInt(1, idIntern);

            stmt.executeUpdate();

            //delete the link between intern and tutor since the intern doesn't exist anymore
            sql = TextConstants.QUERY_DELETE_INTERN_LINK_TO_TUTOR;
            PreparedStatement stmt2 = connection.prepareStatement(sql);
            stmt2.setInt(1, idIntern);
            stmt2.executeUpdate();

            // Close the connection
            connection.close();

            //TODO : redirect vers même page avec session connectée
            //get tutor id from session
            HttpSession session = request.getSession();
            int tutorId = (int) session.getAttribute("tutorId");
            request.setAttribute("listInternsPerTutor", dbActions.getAssociationTutorAndInterns(tutorId));
            response.sendRedirect(request.getRequestURI());
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
