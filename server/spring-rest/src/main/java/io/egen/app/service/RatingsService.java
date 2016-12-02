package io.egen.app.service;


import io.egen.app.entity.Rating;

public interface RatingsService {

	public Double findRatings(String movieId);
	
	public Rating create(Rating Rating);
}
