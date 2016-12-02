package io.egen.app.entity;


import java.util.Date;
import java.util.List;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;

import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;




@Entity
@Table
@NamedQueries({ 
		@NamedQuery(name = "Movie.findAll", query = "SELECT c FROM Movie c ORDER BY c.title ASC"),
		@NamedQuery(name = "Movie.findTopMovies", query = "SELECT TOP 10 * FROM Movie m  WHERE m.type=:ptype order by m.imdbRating DESC"),
    	@NamedQuery(name = "Movie.findTopTvSeries", query = "SELECT TOP 10 * FROM Movie m  WHERE m.type=:ptype order by m.imdbRating DESC"),
		@NamedQuery(name = "Movie.findByType", query = "SELECT c FROM Movie c WHERE c.type=:pType"),
		@NamedQuery(name = "Movie.findByTitle", query = "SELECT c FROM Movie c WHERE c.title=:pTitle"),
		@NamedQuery(name = "Movie.findByYear", query = "SELECT c FROM Movie c WHERE c.year=:pYear"),
		@NamedQuery(name = "Movie.sortByimdbRating", query = "Select m from Movie m order by m.imdbRating DESC"),
		@NamedQuery(name = "Movie.sortByimdbVotes", query = "Select m from Movie m order by m.imdbVotes DESC")
})
public class Movie {

	@Id
	private String id;
	
	@Column(unique = true)
	private String title;
	private String year;
	private String rated;
	private Date released;
	private String runtime;
	
	@ManyToMany
	private List<Genre> genre;
	
	private String director;
	
	@ManyToMany
	private List<Writer> writer;
	
	@ManyToMany
	private List<Actor> Actor;
	
	@Column(name="plot",length=3000)
	private String plot;
	private String language;
	private String country;
	private String awards;
	private String poster;
	private Integer metascore;
	private Double imdbRating;
	private Long imdbVotes;
	private String imdbId;
	private String type;
	
	

	public Movie() {
 		id = UUID.randomUUID().toString();
 	}

	
	public String getId() {
		return id;
	}
	
	public void setId(String id) {
		this.id = id;
	}
	
	public String getTitle() {
		return title;
	}
	
	public void setTitle(String title) {
		this.title = title;
	}
	
	public String getYear() {
		return year;
	}
	
	public void setYear(String year) {
		this.year = year;
	}
	
	public String getRated() {
		return rated;
	}
	
	public void setRated(String rated) {
		this.rated = rated;
	}
	
	public Date getReleased() {
		return released;
	}
	
	public void setReleasedOn(Date released) {
		this.released = released;
	}
	
	public String getRuntime() {
		return runtime;
	}
	
	public void setRuntime(String runtime) {
		this.runtime = runtime;
	}
	
	
	
	public String getDirector() {
		return director;
	}
	
	public void setDirector(String director) {
		this.director = director;
	}
	
	
	
	public String getPlot() {
		return plot;
	}
	
	public void setPlot(String plot) {
		this.plot = plot;
	}
	
	public String getLanguage() {
		return language;
	}
	
	public void setLanguage(String language) {
		this.language = language;
	}
	
	public String getCountry() {
		return country;
	}
	
	public List<Genre> getGenre() {
		return genre;
	}


	public void setGenre(List<Genre> genre) {
		this.genre = genre;
	}


	public List<Writer> getWriter() {
		return writer;
	}


	public void setWriter(List<Writer> writer) {
		this.writer = writer;
	}


	public List<Actor> getActor() {
		return Actor;
	}


	public void setActor(List<Actor> actor) {
		Actor = actor;
	}


	public void setReleased(Date released) {
		this.released = released;
	}

	
	public void setCountry(String country) {
		this.country = country;
	}
	
	public String getAwards() {
		return awards;
	}
	
	public void setAwards(String awards) {
		this.awards = awards;
	}
	
	public String getPoster() {
		return poster;
	}
	
	public void setPoster(String poster) {
		this.poster = poster;
	}
	
	public Integer getMetascore() {
		return metascore;
	}
	
	public void setMetascore(Integer metascore) {
		this.metascore = metascore;
	}
	
	public Double getImdbRating() {
		return imdbRating;
	}
	
	public void setImdbRating(Double imdbRating) {
		this.imdbRating = imdbRating;
	}
	
	public Long getImdbVotes() {
		return imdbVotes;
	}
	
	public void setImdbVotes(Long imdbVotes) {
		this.imdbVotes = imdbVotes;
	}
	
	public String getImdbId() {
		return imdbId;
	}
	
	public void setImdbId(String imdbId) {
		this.imdbId = imdbId;
	}
	
	public String getType() {
		return type;
	}
	
	public void setType(String type) {
		this.type = type;
	}


	@Override
	public String toString() {
		return "Movie [id=" + id + ", title=" + title + ", year=" + year + ", rated=" + rated + ", released=" + released
				+ ", runtime=" + runtime + ", genre=" + genre + ", director=" + director + ", writer=" + writer
				+ ", Actor=" + Actor + ", plot=" + plot + ", language=" + language + ", country=" + country
				+ ", awards=" + awards + ", poster=" + poster + ", metascore=" + metascore + ", imdbRating="
				+ imdbRating + ", imdbVotes=" + imdbVotes + ", imdbId=" + imdbId + ", type=" + type + "]";
	}
	
	
}
