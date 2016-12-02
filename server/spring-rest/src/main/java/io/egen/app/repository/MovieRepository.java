package io.egen.app.repository;

import java.util.List;

import io.egen.app.entity.Movie;

public interface MovieRepository {

	
	public List<Movie> findAll();
	public Movie findOne(String id);
	public Movie create(Movie movie);
	public Movie update(Movie movie);
	public void delete(Movie movie);

	public List<Movie> findByYear(int year);
	public List<Movie> findBytype(String type);
	
	public List<Movie> sortByimdbRating();
	public List<Movie> sortByimdbVotes();
	public List<Movie> sortByYear();
	public List<Movie>findTopRatedMovies();
	public List<Movie>findTopRatedSeries();
}
