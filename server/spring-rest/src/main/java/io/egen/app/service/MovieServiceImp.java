package io.egen.app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import io.egen.app.entity.Movie;
import io.egen.app.exception.EntityNotFoundException;
import io.egen.app.repository.MovieRepository;



public class MovieServiceImp implements MovieService{

	

	@Autowired
	private MovieRepository repository;
	@Override
	public List<Movie> findAll() {
		return repository.findAll();
	}

	@Override
	public Movie create(Movie movie) {
		
		return repository.create(movie);
	}

	@Override
	public Movie update(String id, Movie movie) {
		Movie existing = repository.findOne(id);
		if (existing == null) {
			throw new EntityNotFoundException("Movie not found");
		}
		return repository.update(movie);
	}

	@Override
	public void delete(String id) {
		Movie existing = repository.findOne(id);
		if (existing == null) {
			throw new EntityNotFoundException("Movie not found");
		}
		repository.delete(existing);
		
	}

	@Override
	public Movie findOne(String id) {
		Movie existing = repository.findOne(id);
		if (existing == null) {
			throw new EntityNotFoundException("Movie not found");
		}
		return existing;
	}

	@Override
	public List<Movie> findByYear(int year) {
	return repository.findByYear(year);
	}

	@Override
	public List<Movie> findBytype(String type) {
		return repository.findBytype(type);
	}

	@Override
	public List<Movie> findTopMovies() {
		return repository.findTopRatedMovies();
	}

	@Override
	public List<Movie> findTopSeries() {
		return repository.findTopRatedSeries();
	}

	@Override
	public List<Movie> sortByYear() {
		return repository.sortByYear();
	}

	@Override
	public List<Movie> sortByimdbRating() {
		return repository.sortByimdbRating();
	}

	@Override
	public List<Movie> sortByimdbVotes() {
		return repository.sortByimdbVotes();
	}

}
