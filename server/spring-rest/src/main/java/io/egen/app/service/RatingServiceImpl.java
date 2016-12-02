package io.egen.app.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import io.egen.app.entity.Rating;
import io.egen.app.repository.RatingRepository;

@Service
public class RatingServiceImpl implements RatingsService {

	@Autowired
	RatingRepository RatingRepository;
	@Override
	public Double findRatings(String movieId) {
		return RatingRepository.findAverageRatings(movieId);
	}

	@Override
	public Rating create(Rating rating) {
		return RatingRepository.create(rating);
	}

}
