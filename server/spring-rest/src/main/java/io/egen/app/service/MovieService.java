package io.egen.app.service;


import java.util.List;

import io.egen.app.entity.Movie;

public interface MovieService {
	
	
    public List<Movie> findAll();
	

	
	public Movie create(Movie movie);
	
	public Movie update(String id, Movie movie);
	
	public void delete(String id);

	
	public Movie findOne(String id);
	public List<Movie> findByYear(int year);
	public List<Movie> findBytype(String type);
	
	public List<Movie> findTopMovies();
	public List<Movie> findTopSeries();

	
	public List<Movie> sortByYear();
    public List<Movie> sortByimdbRating();
	public List<Movie> sortByimdbVotes();


}
