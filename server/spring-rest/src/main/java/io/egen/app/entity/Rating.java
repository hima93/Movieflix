package io.egen.app.entity;

import java.util.UUID;

import javax.persistence.Entity;

import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;



@Entity
@Table
@NamedQueries({ 
        @NamedQuery(name="Rating.findAverage", query = "SELECT avg(u.rating) FROM Rating u where u.Movie.id=:pMovieId")
})
public class Rating {

	@Id
	private String id;
	
	@ManyToOne
	@PrimaryKeyJoinColumn(name="userId", referencedColumnName="id")
	private User user;
	@ManyToOne
	@PrimaryKeyJoinColumn(name="MovieId", referencedColumnName="id")
	private Movie movie;
	
	private Double rating;
	
	
	public Rating() {
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
	
	public Double getRating() {
		return rating;
	}
	
	public void setRating(Double rating) {
		this.rating = rating;
	}
	
	@Override
	public String toString() {
		return "Rating [id=" + id + ", user=" + user + ", Movie=" + movie + ", rating=" + rating + "]";
	}
	
}
