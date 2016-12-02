package io.egen.app.controller;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import io.egen.app.entity.Comments;
import io.egen.app.entity.Movie;
import io.egen.app.service.MovieService;
import io.egen.app.service.CommentsService;
import io.egen.app.service.RatingsService;


@RestController
@RequestMapping(path = "movies", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
public class MoviesController {


	@Autowired
	private MovieService service;
	@Autowired
	private CommentsService commentsService;
	
	@Autowired
	RatingsService ratingService;


	
	@RequestMapping(method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public List<Movie> findAll(){
		return service.findAll();
	}
	
	
	//Adding a new movie
		@RequestMapping(method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
		public Movie create(@RequestBody Movie movie){
			return service.create(movie);
		}
		
		
		//updating a movie information
		@RequestMapping(method = RequestMethod.PUT, path="{id}", produces = MediaType.APPLICATION_JSON_UTF8_VALUE, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
		public Movie update(@PathVariable("id") String movId, @RequestBody Movie movie){
			return service.update(movId, movie);
		}
		
		//Deleting a movie
		@RequestMapping(method = RequestMethod.DELETE, path="{id}")
		public void delete(@PathVariable("id") String movId){
			service.delete(movId);
		}
		
		//finding a movie with its id
	@RequestMapping(method = RequestMethod.GET, path="/findById/{id}", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public Movie findOne(@PathVariable("id") String movId){
		return service.findOne(movId);
	}
	
	
	//finding a movie by its year
	@RequestMapping(method = RequestMethod.GET,path="/findByYear/{year}",produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public List<Movie> findByYear(@PathVariable("year") int year) {
		return service.findByYear(year);
	}
	
	
	//finding a movie by its type
	@RequestMapping(method = RequestMethod.GET,path="/findBytype/{type}",produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public List<Movie> findByDirector(@PathVariable("type") String type) {
		return service.findBytype(type);
	}
	

	//finding a movie by its year
	@RequestMapping(method = RequestMethod.GET,path="/sortByYear",produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public List<Movie> sortByYear() {
		return service.sortByYear();
	}
	
	//sorting with IMDB ratings
	
	@RequestMapping(method = RequestMethod.GET,path="/sortByimdbRating",produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public List<Movie> sortByRating() {
		return service.sortByimdbRating();
	}
	
	//sorting with IMDB votes
	@RequestMapping(method = RequestMethod.GET,path="/sortByimdbVotes",produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public List<Movie> sortByVotes() {
		return service.sortByimdbVotes();
	}
	
	//Finding top 10 movies
	@RequestMapping(method = RequestMethod.GET,path="/findTopMovies",produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public List<Movie> findTopMovies() {
		return service.findTopMovies();
	}
	
	
	//finding top 10 series
	@RequestMapping(method = RequestMethod.GET,path="/findTopSeries",produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public List<Movie> findTopSeries() {
		return service.findTopSeries();
	}
	
	
	
	//Getting all comments for the movie
	@RequestMapping(method = RequestMethod.GET, path = "{id}/comments", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public List<Comments> findAllComments(@PathVariable("id") String movieId) {
		return commentsService.findComments(movieId);
	}

	
	//Getting average rating for a movie
	@RequestMapping(method = RequestMethod.GET, path = "{id}/averagerating", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public Double findCatelogRationg(@PathVariable("id") String movieId) {
		return ratingService.findRatings(movieId);
	}

	
}
