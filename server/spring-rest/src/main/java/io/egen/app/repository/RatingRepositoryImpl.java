package io.egen.app.repository;


import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import io.egen.app.entity.Rating;

@Repository
public class RatingRepositoryImpl implements RatingRepository {

	@PersistenceContext
	private EntityManager em;
	
	@Override
	public Double findAverageRatings(String movieId) {
		TypedQuery<Double> query = em.createNamedQuery("Rating.findAverage", Double.class);
		query.setParameter("pMovieId", movieId);
		return query.getSingleResult();
	}

	@Override
	@Transactional
	public Rating create(Rating userRating) {
		em.persist(userRating);
		return userRating;
	}
	
	
	

}
