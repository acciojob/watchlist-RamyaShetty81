package com.driver;

import org.springframework.stereotype.Repository;

import java.util.*;

@Repository

public class MovieRepository {
    HashMap<String,Movie> movieDb;
    HashMap<String,Director> directorDb;
    HashMap<String,List<String>> movieDirectorPair;

    public MovieRepository() {
        this.movieDb=new HashMap<>();
        this.directorDb=new HashMap<>();
        this.movieDirectorPair=new HashMap<>();
    }
    //1 Add Movie
    public String addMovie(Movie movie){
        String key=movie.getName();
        if(!movieDb.containsKey(key)){
            movieDb.put(key,movie);
            return "Movie added Successfully";
        }
        return "Movie already exists";
    }
    //2 Add Director
    public String addDirector(Director director){
        String key=director.getName();
        if(!directorDb.containsKey(key)){
            directorDb.put(key,director);
            return "Director added Successfully";
        }
        return "Director already exists";
    }
    //3 Pairing movie and director
    public String addMovieDirectorPair(String movieName,String directorName){
        List<String> list=movieDirectorPair.get(directorName);
        if(list==null){
            list = new ArrayList<String>();
        }
        list.add(movieName);
        movieDirectorPair.put(directorName,list);

        return "Movie & Director pair added successfully";
    }
    public Movie getMovieByName(String name){
        if(movieDb.containsKey(name)){
            return movieDb.get(name);
        }
        return null;
    }
    public Director getDirectorByName(String name){
        if(directorDb.containsKey(name)){
            return directorDb.get(name);
        }
        return null;
    }
    public HashMap<String,Movie> getAllMovies(){
        return movieDb;
    }
    public HashMap<String,List<String>> getAllMovieDirectorPairs(){
        return movieDirectorPair;
    }
    public String deleteDirectorByName(String name){
        for(String movie: movieDirectorPair.get(name)){
            movieDb.remove(movie);
        }
        directorDb.remove(name);
        return "Director removed Successfully";
    }
    public String deleteAllDirectors() {
        for(String director:directorDb.keySet()) {
            for(String movie: movieDirectorPair.get(director)){
                movieDb.remove(movie);
            }
            directorDb.remove(director);
        }
        return "Successfully removed Everything";
    }
}