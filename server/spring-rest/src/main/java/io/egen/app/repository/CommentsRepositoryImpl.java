package io.egen.app.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import io.egen.app.entity.Comments;

@Repository
public class CommentsRepositoryImpl implements CommentsRepository{
   
	@PersistenceContext
	private EntityManager em;
	
	
	@Override
	public Comments create(Comments userComments) {
		em.persist(userComments);
		return userComments;
	}


	@Override
	public List<Comments> findComments(String movieid) {
		TypedQuery<Comments> query = em.createNamedQuery("UserComments.findComments", Comments.class);
		query.setParameter("pMovieId", movieid);
		return query.getResultList();
	}

}
