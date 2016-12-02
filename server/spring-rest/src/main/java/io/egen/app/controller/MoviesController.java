package io.egen.app.controller;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import io.egen.app.entity.Movie;
import io.egen.app.service.MovieService;


@RestController
@RequestMapping(value = "movies", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
public class MoviesController {


	@Autowired
	private MovieService service;


	
	@RequestMapping(method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public List<Movie> findAll(){
		return service.findAll();
	}
	
	@RequestMapping(method = RequestMethod.GET, path="/findById/{id}", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public Movie findOne(@PathVariable("id") String movId){
		return service.findOne(movId);
	}
	
	
	
	@RequestMapping(method = RequestMethod.GET,path="/findByYear/{year}",produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public List<Movie> findByYear(@PathVariable("year") int year) {
		return service.findByYear(year);
	}
	
	@RequestMapping(method = RequestMethod.GET,path="/findBytype/{type}",produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public List<Movie> findByDirector(@PathVariable("type") String type) {
		return service.findBytype(type);
	}
	

	
	@RequestMapping(method = RequestMethod.GET,path="/sortByYear",produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public List<Movie> sortByYear() {
		return service.sortByYear();
	}
	
	@RequestMapping(method = RequestMethod.GET,path="/sortByimdbRating",produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public List<Movie> sortByRating() {
		return service.sortByimdbRating();
	}
	@RequestMapping(method = RequestMethod.GET,path="/sortByimdbVotes",produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public List<Movie> sortByVotes() {
		return service.sortByimdbVotes();
	}
	
	
	@RequestMapping(method = RequestMethod.GET,path="/findTopMovies",produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public List<Movie> findTopMovies() {
		return service.findTopMovies();
	}
	
	@RequestMapping(method = RequestMethod.GET,path="/findTopSeries",produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public List<Movie> findTopSeries() {
		return service.findTopSeries();
	}
	
	@RequestMapping(method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public Movie create(@RequestBody Movie movie){
		return service.create(movie);
	}
	
	@RequestMapping(method = RequestMethod.PUT, path="{id}", produces = MediaType.APPLICATION_JSON_UTF8_VALUE, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public Movie update(@PathVariable("id") String movId, @RequestBody Movie movie){
		return service.update(movId, movie);
	}
	
	@RequestMapping(method = RequestMethod.DELETE, path="{id}")
	public void delete(@PathVariable("id") String movId){
		service.delete(movId);
	}
	
	
}
