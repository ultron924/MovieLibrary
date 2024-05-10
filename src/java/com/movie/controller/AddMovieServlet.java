/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.movie.controller;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.movie.model.MovieItem;
import com.movie.view.AddMovieFormServlet;
import java.util.*;
import javax.servlet.RequestDispatcher;

@WebServlet(name = "AddMovieServlet", urlPatterns = {"/add_movie.do"})
public class AddMovieServlet extends HttpServlet {


    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet AddMovieServlet</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet AddMovieServlet at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

  
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }


    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        try{
            
            String title = request.getParameter("title");
            String year = request.getParameter("year");
            String genre = request.getParameter("newGenre");
            
            /*if (title == null || title.trim().isEmpty() || year == null || year.trim().isEmpty() || genre == null || genre.trim().isEmpty()) {
                throw new RuntimeException("Required parameters are missing.");
            }*/

            if ((genre == null) || genre.trim().length() == 0){
                genre = request.getParameter("genre");
            }
            
            MovieItem item = new MovieItem(title, year, genre);
            
            request.setAttribute("movieItem", item);
            
            RequestDispatcher view = request.getRequestDispatcher("/success.jsp");
            view.forward(request, response);

            /*
            PrintWriter out = response.getWriter();
            out.println("SUCCESS: Added movie titled " + item.getTitle() + ".");
            out.close();*/


        }   catch (RuntimeException e) {         
            // Changed the request dispatcher path from /error.view to /add_movie.view
           /* RequestDispatcher view = request.getRequestDispatcher("/add_movie.view");
            view.forward(request, response);*/
            
            PrintWriter out = response.getWriter();
            out.println("ERROR: " + e.getMessage());
            out.close();
        }
        
        
        
        
        
        
        //processRequest(request, response);
    }

   
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
