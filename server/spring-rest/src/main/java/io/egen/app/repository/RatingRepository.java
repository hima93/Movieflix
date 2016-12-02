package io.egen.app.repository;



import io.egen.app.entity.Rating;


public interface RatingRepository {

	public Double findAverageRatings(String movieId);
	
	public Rating create(Rating userRating);


}

