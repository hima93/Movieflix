package io.egen.app.service;



import java.util.List;

import io.egen.app.entity.Comments;


public interface CommentsService {

	public List<Comments> findComments(String movieId);
	
	public Comments create(Comments comments);
}
