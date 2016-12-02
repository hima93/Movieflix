package io.egen.app.service;



import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import io.egen.app.entity.Comments;
import io.egen.app.repository.CommentsRepository;


@Service
public class CommentsServiceImpl implements CommentsService {

	@Autowired
CommentsRepository CommentsRepository;
	
	
	@Override
	public List<Comments> findComments(String movieId) {
		return CommentsRepository.findComments(movieId);
	}

	
	@Override
	@Transactional
	public Comments create(Comments Comments) {
		return CommentsRepository.create(Comments);
	}

}