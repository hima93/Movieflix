package io.egen.app.entity;


import java.util.UUID;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

import io.egen.app.entity.Movie;;



@Entity
@Table
@NamedQueries({ 
		@NamedQuery(name = "Comments.findComments", query = "SELECT u FROM Comments u where u.Movie.id = :pMovieId")
})
public class Comments {

	@Id
	private String id;
	
	@ManyToOne
	@PrimaryKeyJoinColumn(name="userId", referencedColumnName="id")
	private User user;
	
	
	@ManyToOne
	@PrimaryKeyJoinColumn(name="MovieId", referencedColumnName="id")
	private Movie movie;
	
	private String comments;
	
	public Comments() {
 		id = UUID.randomUUID().toString();
 	}
	public String getId() {
		return id;
	}
	
	public void setId(String id) {
		this.id = id;
	}
	
	public User getUser() {
		return user;
	}
	
	public void setUser(User user) {
		this.user = user;
	}
	
	public Movie getMovie() {
		return movie;
	}
	
	public void setMovie(Movie movie) {
		this.movie = movie;
	}
	
	@Override
	public String toString() {
		return "UserComments [id=" + id + ", user=" + user + ", Movie=" + movie + ", comments=" + comments + "]";
	}
	
	public String getComments() {
		return comments;
	}
	
	public void setComments(String comments) {
		this.comments = comments;
	}
	
}
