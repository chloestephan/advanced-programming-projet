/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.apr2023.ctrl;

import com.apr2023.model.DBActions;
import com.apr2023.utils.TextConstants;
import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.Cookie;

import java.io.IOException;
import java.io.InputStream;
import java.sql.*;
import java.util.Properties;

/**
 * @author Clochette
 */
public class Controller extends HttpServlet {

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

        Properties prop;
        prop = new Properties();
        InputStream inputStream = getServletContext().getResourceAsStream(TextConstants.DB_CONFIG_PATH);
        prop.load(inputStream);

        String dbUrl = prop.getProperty("dbUrl");
        String dbUser = prop.getProperty("dbUser");
        String dbPwd = prop.getProperty("dbPwd");

        if (request.getParameter("action") == null) {
            request.getRequestDispatcher(TextConstants.JSP_LOGIN_PAGE).forward(request, response);
        } else {
            DBActions dbActions = new DBActions(dbUrl, dbUser, dbPwd);

            // Establish a connection to the database
            Connection connection;
            try {
                connection = DriverManager.getConnection(dbUrl, dbUser, dbPwd);
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }

            // Execute a query to retrieve the user's credentials from the database
            String username = request.getParameter(TextConstants.FORM_LOGIN_FIELD_NAME);
            String password = request.getParameter(TextConstants.FORM_PWD_FIELD_NAME);
            String sql = TextConstants.QUERY_GET_TUTOR_INFO;
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setString(1, username);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                int IdTutor = rs.getInt("id");
                String UsernameTutor = rs.getString("username");
                String PasswordTutor = rs.getString("password");

                // Check if the entered credentials match the ones in the database
                if (username.equals(UsernameTutor) && password.equals(PasswordTutor)) {
                    //if they match, get all the interns associated to that tutor and get the name of the tutor
                    request.setAttribute("listInternsPerTutor", dbActions.getAssociationTutorAndInterns(IdTutor));
                    request.setAttribute("tutorName", dbActions.getTutorName(IdTutor));

                    //enter the tutor id in the cookies
                    Cookie cookieTutorId = new Cookie("tutorId", String.valueOf(IdTutor));
                    cookieTutorId.setMaxAge(60 * 60 * 24);
                    response.addCookie(cookieTutorId);

                    //forward to the home page
                    request.getRequestDispatcher(TextConstants.JSP_HOME_PAGE).forward(request, response);
                } else {
                    request.setAttribute("errKey", TextConstants.ERROR_MESSAGE);
                    request.getRequestDispatcher(TextConstants.JSP_LOGIN_PAGE).forward(request, response);
                }
            } else {
                request.setAttribute("errKey", TextConstants.ERROR_MESSAGE);
                request.getRequestDispatcher(TextConstants.JSP_LOGIN_PAGE).forward(request, response);
            }
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
