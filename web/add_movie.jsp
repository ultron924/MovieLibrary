<%-- 
    Document   : add_movie
    Created on : May 10, 2024, 8:49:58 AM
    Author     : Acer
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.util.*"%>
<%@page import="com.movie.model.MovieItem"%>
<%
    String genre_list="Action, Comedy, Sci-fi";
    String [] genres= null;
    genres = genre_list.split(",");
%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Movie Library Application: Add Movie Form</title>
    </head>
    <body>
        <%--Generate main body --%>
        <h1>Add Movie (JSP)</h1>
        <%--- Report any errors (if any) --%>
        <%
            List errorMsgs = (List) request.getAttribute("errorMsgs");
            if ( errorMsgs != null){
               
         %>
         
         <p>
             <font color='red'>Plese correct the following errors:
         <ul>
             <%
                 Iterator items = errorMsgs.iterator();
                 while ( items.hasNext()){
                     String message = (String) items.next();
                 
              %>
              <li><%= message %></li>
              <%
                  }
              %>
         </ul>
         </p>
         <%  
             }
         %>
         <form action='add_movie.do' method='post'>
             <%-- Repopulate the title field --%>
             Title: <input type="text" name="title" value="${param.title}"/><br/><br/>
             <%-- Repopulate the year field --%>
             Year: <input type="text" name="year" value="${param.year}"/><br/><br/>
             
             <%-- Repopulate the genre drop drown menu--%>
             <%
                 String genre = request.getParameter("genre");
             %>
             Genre:<select name="genre">
                 <%
                     for (int i = 0; i < genres.length; i++){
                     String genre_item = genres[i];
                 %>
                 <option value='<%= genre_item %>'
                         <%
                             if(genre_item.equals(genre)){
                                 out.print(" selected");
                             }
                    %>
                 > <%= genre_item %></option>
             <%
                 }
             %>
             </select>
                 
                 or new genre:: <input type="text" name="newGenre" value="${param.newGenre}" /><br/><br/>
                 <input type="submit" vlue="Add Movie" />
                 
                </form>
                 
             
             
    </body>
</html>
