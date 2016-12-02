package io.egen.app.repository;



import java.util.List;
import io.egen.app.entity.*;

public interface CommentsRepository {
	
	public List<Comments> findComments(String movieid);
	
	public Comments create(Comments comments);

}
