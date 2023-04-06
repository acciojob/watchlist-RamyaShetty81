package com.driver;


import org.springframework.stereotype.Repository;


import java.util.*;


@Repository
public class MovieRepository {


    List<Movie> movieDB = new ArrayList<>();
    List<Director> directorDB = new ArrayList<>();


    HashMap<String,String> movieDirectorPair = new HashMap<>();


    public void addMovie(Movie movie)
    {
        movieDB.add(movie);
    }


    public void addDirector(Director director)
    {
        directorDB.add(director);
    }


    public void addMovieDirectorPair(String movie, String director)
    {
        movieDirectorPair.put(movie,director);
    }


    public Movie getMovieByName(String movieName)
    {
        for(Movie movie : movieDB)
        {
            if(movie.getName().equals(movieName)) {
                return movie;
            }
        }
        return null;
    }


    public Director getDirectorByName(String directorName)
    {
        for(Director director : directorDB)
        {
            if(director.getName().equals(directorName)) {
                return director;
            }
        }
        return null;
    }


    public List<String> getMoviesByDirectorName(String directorName)
    {
        List<String> ans = new ArrayList<>();


        for(String movie : movieDirectorPair.keySet())
        {
            if(movieDirectorPair.get(movie).equals(directorName))
            {
                ans.add(movie);
            }
        }
        return ans;
    }


    public List<String> findAllMovies()
    {
        List<String> ans = new ArrayList<>();
        for(Movie movie : movieDB)
        {
            ans.add(movie.getName());
        }
        return ans;
    }


    public void deleteDirectorByName(String directorName)
    {
        directorDB.remove(directorName);
        for(String movie : movieDirectorPair.keySet())
        {
            if(movieDirectorPair.get(movie).equals(directorName))
            {
                movieDirectorPair.remove(movie);
            }
        }
    }


    public void deleteAllDirectors()
    {
        directorDB.clear();


        for(String movie : movieDirectorPair.keySet())
        {
            if(movieDB.contains(movie))
            {
                movieDB.remove(movie);
            }
        }
        movieDirectorPair.clear();
    }


}
