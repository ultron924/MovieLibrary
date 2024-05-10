/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.movie.model;
import java.io.Serializable;
/**
 *
 * @author Acer
 */
public class MovieItem implements Serializable{
    private String title;
    private String year;
    private String genre;

    public MovieItem(String title, String year, String genre) {
        this.title = title;
        this.year = year;
        this.genre = genre;
    }

    public String getTitle() {
        return title;
    }

    public String getYear() {
        return year;
    }

    public String getGenre() {
        return genre;
    }
    
    
    
}
