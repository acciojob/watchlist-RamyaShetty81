package com.driver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;




import java.util.List;


@RestController
@RequestMapping("/movies")
public class MovieController {
    @Autowired
    private MovieService movieService;


    @PostMapping("/add-movie")
    public ResponseEntity<String> addMovie(@RequestBody Movie movie) {
        movieService.addMovie(movie);
        return new ResponseEntity<>("Movie added successfully", HttpStatus.CREATED);
    }


    @PostMapping("/add-director")
    public ResponseEntity<String> addDirector(@RequestBody Director director) {
        movieService.addDirector(director);
        return new ResponseEntity<>("Director added successfully", HttpStatus.CREATED);
    }


    @PutMapping("/add-movie-director-pair")
    public ResponseEntity<String> addMovieDirectorPair(@RequestBody String movie, @RequestBody String director) {


        movieService.addMovieDirectorPair(movie,director);
        return new ResponseEntity<>("Movie Director Pair added Successfully", HttpStatus.ACCEPTED);
    }


    @GetMapping("/get-movie-by-name/{name}")
    public ResponseEntity<Movie> getMovieByName(@PathVariable("name")String movieName)
    {
        Movie movie = movieService.getMovieByName(movieName);
        return new ResponseEntity<>(movie,HttpStatus.OK);
    }


    @GetMapping("/get-director-by-name/{name}")
    public ResponseEntity<Director> getDirectorByName(@PathVariable("name")String directorName)
    {
        Director director = movieService.getDirectorByName(directorName);
        return new ResponseEntity<>(director,HttpStatus.OK);
    }


    @GetMapping("/get-movies-by-director-name/{director}")
    public ResponseEntity<List<String>> getMoviesByDirectorName(@PathVariable("name")String directorName)
    {
        List<String> movie = movieService.getMoviesByDirectorName(directorName);
        return new ResponseEntity<>(movie,HttpStatus.OK);
    }


    @GetMapping("/get-all-movies")
    public ResponseEntity<List<String>> findAllMovies() {
        List<String> movieNames = movieService.findAllMovies();
        return new ResponseEntity<>(movieNames, HttpStatus.OK);
    }




    @DeleteMapping("/delete-director-by-name")
    public ResponseEntity<String> deleteDirectorByName(@RequestBody String director) {
        movieService.deleteDirectorByName(director);
        return new ResponseEntity<>("Director deleted successfully", HttpStatus.OK);
    }


    @DeleteMapping("/delete-all-directors")
    public ResponseEntity<String> deleteAllDirectors()
    {
        movieService.deleteAllDirectors();
        return new ResponseEntity<>("All Directors deleted Successfully",HttpStatus.OK);
    }
}

