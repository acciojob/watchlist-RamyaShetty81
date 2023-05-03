package com.driver;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import javax.websocket.server.PathParam;
import java.util.List;

@RestController
@RequestMapping("/movies")
public class MovieController {
    @Autowired
    MovieService movieService;
    //1 Movie Add
    @PostMapping("/add-movie")
    public ResponseEntity<String> addMovie(@RequestBody Movie movie){
        String ans= movieService.addMovie(movie);
        return new ResponseEntity<>(ans, HttpStatus.CREATED);
    }
    //2 Add Director
    @PostMapping("/add-director")
    public ResponseEntity<String> addDirector(@RequestBody Director director){
        String ans= movieService.addDirector(director);
        return new ResponseEntity<>(ans,HttpStatus.CREATED);
    }
    //3 Add Movie-Director pair
    @PutMapping("/add-movie-director-pair")
    public ResponseEntity<String> addMovieDirectorPair(@RequestParam("movieName") String movieName,@RequestParam("directorName") String directorName){
        String ans=movieService.addMovieDirectorPair(movieName,directorName);
        return new ResponseEntity<>(ans,HttpStatus.CREATED);
    }
    //4 Get movie by Name
    @GetMapping("/get-movie-by-name/{name}")
    public ResponseEntity<Movie> getMovieByName(@PathParam("movieName") String movieName){
        Movie movie=movieService.getMovieByName(movieName);
        return new ResponseEntity<>(movie,HttpStatus.CREATED);
    }
    //5 Get director by Name
    @GetMapping("/get-director-by-name/{name}")
    public ResponseEntity<Director> getDirectorByName(@PathParam("directorName") String directorName){
        Director director=movieService.getDirectorByName(directorName);
        return new ResponseEntity<>(director,HttpStatus.CREATED);
    }
    //6 Get movies By Director
    @GetMapping("/get-movies-by-director-name/{director}")
    public ResponseEntity<List<String>> getMoviesByDirectorName(@PathParam("directorName") String directorName){
        List<String> list=movieService.getMoviesByDirectorName(directorName);
        return new ResponseEntity<>(list,HttpStatus.CREATED);
    }
    //7 Get all movies
    @GetMapping("/get-all-movies")
    public ResponseEntity<List<String>> findAllMovies(){
        List<String> list=movieService.findAllMovies();
        return new ResponseEntity<>(list,HttpStatus.CREATED);
    }
    //8 Delete Director by name
    @DeleteMapping("/delete-director-by-name")
    public ResponseEntity<String> deleteDirectorByName(@RequestParam("directorName") String directorName){
        String ans=movieService.deleteDirectorByName(directorName);
        return new ResponseEntity<>(ans,HttpStatus.CREATED);
    }
    //9 delete all directors
    @DeleteMapping("/delete-all-directors")
    public ResponseEntity<String> deleteAllDirectors(){
        String ans=movieService.deleteAllDirectors();
        return new ResponseEntity<>(ans,HttpStatus.CREATED);
    }
}