package io.egen.app.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.*;

import io.egen.app.entity.Movie;



public class MovieRepositoryImp implements MovieRepository{

	@PersistenceContext
	private EntityManager em;
	@Override
	public List<Movie> findAll() {
		TypedQuery<Movie> query = em.createNamedQuery("Movie.findAll", Movie.class);
		return query.getResultList();
	}

	@Override
	public Movie findOne(String id) {
		return em.find(Movie.class, id);
	}

	@Override
	public Movie create(Movie movie) {
		em.persist(movie);
		return movie;
	}

	@Override
	public Movie update(Movie movie) {
		return em.merge(movie);
	}

	@Override
	public void delete(Movie movie) {
		em.remove(movie);
		
	}

	@Override
	public List<Movie> findByYear(int year) {
		TypedQuery<Movie> query = em.createNamedQuery("Movie.findByYear", Movie.class);
		query.setParameter("pYear",year);
		return query.getResultList();
	}

	@Override
	public List<Movie> findBytype(String type) {
		TypedQuery<Movie> query = em.createNamedQuery("Movie.findByType", Movie.class);
		query.setParameter("ptype",type);
		return query.getResultList();
	}

	@Override
	public List<Movie> sortByimdbRating() {
		TypedQuery<Movie> query = em.createNamedQuery("Movie.sortByimdbRating", Movie.class);
		return query.getResultList();
	}

	@Override
	public List<Movie> sortByimdbVotes() {
		TypedQuery<Movie> query = em.createNamedQuery("Movie.sortByimdbVotes", Movie.class);
		return query.getResultList();

	}

	@Override
	public List<Movie> sortByYear() {
		TypedQuery<Movie> query = em.createNamedQuery("Movie.sortByYear", Movie.class);
		return query.getResultList();

	}

	@Override
	public List<Movie> findTopRatedMovies() {
		String type="movie";
		TypedQuery<Movie> query = em.createNamedQuery("Movie.findTopMovies", Movie.class);
		query.setParameter("ptype",type);
				return query.getResultList();

	}

	@Override
	public List<Movie> findTopRatedSeries() {
		
		String type="series";
		TypedQuery<Movie> query = em.createNamedQuery("Movie.findTopTvSeries", Movie.class);
		query.setParameter("ptype",type);
		return query.getResultList();

	}

	@Override
	public Movie findBytitle(String title) {
		TypedQuery<Movie> query = em.createNamedQuery("Movie.findByTitle", Movie.class);
		query.setParameter("pTitle", title);
		List<Movie> list = query.getResultList();
		if(list!=null && list.size() == 1){
			return list.get(0);
		}
		return null;

	}

}


