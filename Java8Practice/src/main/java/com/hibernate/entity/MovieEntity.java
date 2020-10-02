package com.hibernate.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="movie_details")
public class MovieEntity {
	
	@Id
	@Column(name="movie_id")
	private String movieId;
	
	@Column(name="movie_name")
	private String movieName;
	
	private String language;
	
	@Column(name="released_in")
	private Integer releasedIn;
	
	@Column(name="revenue_in_dollars")
	private Integer revenueInDollars;

	public String getMovieId() {
		return movieId;
	}

	public void setMovieId(String movieId) {
		this.movieId = movieId;
	}

	public String getMovieName() {
		return movieName;
	}

	public void setMovieName(String movieName) {
		this.movieName = movieName;
	}

	public String getLanguage() {
		return language;
	}

	public void setLanguage(String language) {
		this.language = language;
	}

	public Integer getReleasedIn() {
		return releasedIn;
	}

	public void setReleasedIn(Integer releasedIn) {
		this.releasedIn = releasedIn;
	}

	public Integer getRevenueInDollars() {
		return revenueInDollars;
	}

	public void setRevenueInDollars(Integer revenueInDollars) {
		this.revenueInDollars = revenueInDollars;
	}

	public MovieEntity(String movieId, String movieName, String language, Integer releasedIn,
			Integer revenueInDollars) {
		super();
		this.movieId = movieId;
		this.movieName = movieName;
		this.language = language;
		this.releasedIn = releasedIn;
		this.revenueInDollars = revenueInDollars;
	}

}
