/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.movie.view;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 *
 * @author Acer
 */
@WebServlet(name = "AddMovieFormServlet", urlPatterns = {"/add_movie.view"})
public class AddMovieFormServlet extends HttpServlet {

   
    private String[] genres = null;
    
    public AddMovieFormServlet() {
        
    }
    
    public void init() throws ServletException {
        
        // Retrieving the genre-list initialization parameter
        String genreListParam = getInitParameter("genre-list");

        if (genreListParam != null) {
            // Splitting the parameter value on commas and populating the genres instance variable
            genres = genreListParam.split(",");
        } else {
            // Handle the case when the parameter is not provided
            throw new ServletException("Genre list initialization parameter not found.");
        }
       
    } 
   
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        
        // Retrieving the errorMsgs attribute from the request scope
        List<String> errorMsgs = (List<String>) request.getAttribute("errorMsgs");
        
        try (PrintWriter out = response.getWriter()) {
            // Retrieving request parameter data
            String title = request.getParameter("title");
            String director = request.getParameter("director");
            String year = request.getParameter("year");
            String genre = request.getParameter("genre");
            String newGenre = request.getParameter("newGenre");

            // Generating the HTML form with repopulated field values
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Add Movie Form</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h2>Add Movie</h2>");
            out.println("<form action='AddMovieServlet' method='post'>");

            // Title field
            out.println("Title: <input type='text' name='title' value='" + (title != null ? title : "") + "'><br>");
            // Year field
            out.println("Year: <input type='number' name='year' value='" + (year != null ? year : "") + "'><br>");

            // Genre drop-down menu and new genre field
            out.println("Genre: <select name='genre'>");
            for (String g : genres) {
                out.print("<option value='" + g + "'");
                if (genre != null && genre.equals(g)) {
                    out.print(" selected");
                }
                out.println(">" + g + "</option>");
            }
            out.println("</select> or new genre: <input type='text' name='newGenre' value='" + (newGenre != null ? newGenre : "") + "'><br>");

            out.println("<input type='submit' value='Add Movie'>");
            out.println("</form>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
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
