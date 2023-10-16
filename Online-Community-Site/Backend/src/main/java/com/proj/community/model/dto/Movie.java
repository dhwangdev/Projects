package com.proj.community.model.dto;

import java.util.Date;
import java.util.List;

public class Movie {
	private int id;
	private String title;
	private String genre;
	private String overview;
	private int recommendCnt;
	private String backdropPath;
	private String posterPath;
	private float popularity;
	private String releaseDate;
	private int commentCnt;
	private String key;

	public Movie() {
		super();
	}

	public Movie(int id, String title, String genre, String overview, int recommendCnt, String backdropPath,
			String posterPath, float popularity, String releaseDate, int commentCnt, String key) {
		super();
		this.id = id;
		this.title = title;
		this.genre = genre;
		this.overview = overview;
		this.recommendCnt = recommendCnt;
		this.backdropPath = backdropPath;
		this.posterPath = posterPath;
		this.popularity = popularity;
		this.releaseDate = releaseDate;
		this.commentCnt = commentCnt;
		this.key = key;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getGenre() {
		return genre;
	}

	public void setGenre(String genre) {
		this.genre = genre;
	}

	public String getOverview() {
		return overview;
	}

	public void setOverview(String overview) {
		this.overview = overview;
	}

	public int getRecommendCnt() {
		return recommendCnt;
	}

	public void setRecommendCnt(int recommendCnt) {
		this.recommendCnt = recommendCnt;
	}

	public String getBackdropPath() {
		return backdropPath;
	}

	public void setBackdropPath(String backdropPath) {
		this.backdropPath = backdropPath;
	}

	public String getPosterPath() {
		return posterPath;
	}

	public void setPosterPath(String posterPath) {
		this.posterPath = posterPath;
	}

	public float getPopularity() {
		return popularity;
	}

	public void setPopularity(float popularity) {
		this.popularity = popularity;
	}

	public String getReleaseDate() {
		return releaseDate;
	}

	public void setReleaseDate(String releaseDate) {
		this.releaseDate = releaseDate;
	}

	public int getCommentCnt() {
		return commentCnt;
	}

	public void setCommentCnt(int commentCnt) {
		this.commentCnt = commentCnt;
	}

	public String getKey() {
		return key;
	}

	public void setKey(String key) {
		this.key = key;
	}

	@Override
	public String toString() {
		return "Movie [id=" + id + ", title=" + title + ", genre=" + genre + ", overview=" + overview
				+ ", recommendCnt=" + recommendCnt + ", backdropPath=" + backdropPath + ", posterPath=" + posterPath
				+ ", popularity=" + popularity + ", releaseDate=" + releaseDate + ", commentCnt=" + commentCnt
				+ ", key=" + key + "]";
	}

}
