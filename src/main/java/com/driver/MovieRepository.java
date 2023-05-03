package com.driver;

import org.springframework.stereotype.Repository;
import java.util.*;

@Repository
public class MovieRepository {


    HashMap<String,Movie> movieDB = new HashMap<>();
    HashMap<String,Director> directorDB = new HashMap<>();
    HashMap<String,List<String>> movieDirectorPair = new HashMap<>();


    public void addMovie(Movie movie)
    {

        String key = movie.getName();
        if(!movieDB.containsKey(key))
            movieDB.put(key,movie);
        return;
    }


    public void addDirector(Director director)
    {
        String key = director.getName();
        if(!directorDB.containsKey(key))
          directorDB.put(key,director);
        return;
    }


    public void addMovieDirectorPair(String movie, String director)
    {
        if(movieDirectorPair.containsKey(director)){
            List<String> movies = movieDirectorPair.get(director);
            movies.add(movie);
            movieDirectorPair.put(director,movies);
        }
        else {
            List<String> movies = new ArrayList<>();
            movies.add(movie);
            movieDirectorPair.put(director,movies);
        }

    }


    public Movie getMovieByName(String movieName)
    {
        for(Movie movie : movieDB.values())
        {
            if(movie.getName().equals(movieName)) {
                return movie;
            }
        }
        return null;
    }


    public Director getDirectorByName(String directorName)
    {
        for(Director director : directorDB.values())
        {
            if(director.getName().equals(directorName)) {
                return director;
            }
        }
        return null;
    }


    public List<String> getMoviesByDirectorName(String directorName)
    {

    if(movieDirectorPair.containsKey(directorName)) {
        return movieDirectorPair.get(directorName);
    }

        return new ArrayList<>();
    }


    public List<String> findAllMovies()
    {
        List<String> ans = new ArrayList<>();
        for(Movie movie : movieDB.values())
        {
            ans.add(movie.getName());
        }
        return ans;
    }


    public void deleteDirectorByName(String directorName)
    {
        directorDB.remove(directorName);

        if(movieDirectorPair.containsKey(directorName))
            movieDirectorPair.remove(directorName);

    }


    public void deleteAllDirectors()
    {
        directorDB.clear();


        for(String director : movieDirectorPair.keySet())
        {
            List<String> movies = movieDirectorPair.get(director);
            for(String movie : movies){
                movieDB.remove(movie);
            }

              //  movieDB.remove(movie);

        }
        movieDirectorPair.clear();
    }


}
