package com.proj.community.model.dto;

import java.util.Date;

public class Book {
	private int id;
	private String isbn;
	private String title;
	private String author;
	private String pubDate;
	private String description;
	private int price;
	private String coverImg;
	private String publisher;
	private String category;
	private String categoryName;
	private int reviewRank;
	private String bestDuration;
	private int bestRank;
	private int recommendCnt;
	private int commentCnt;

	@Override
	public String toString() {
		return "Book [id=" + id + ", isbn=" + isbn + ", title=" + title + ", author=" + author + ", pubDate=" + pubDate
				+ ", description=" + description + ", price=" + price + ", coverImg=" + coverImg + ", publisher="
				+ publisher + ", category=" + category + ", categoryName=" + categoryName + ", reviewRank=" + reviewRank
				+ ", bestDuration=" + bestDuration + ", bestRank=" + bestRank + ", recommendCnt=" + recommendCnt
				+ ", commentCnt=" + commentCnt + "]";
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getIsbn() {
		return isbn;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getPubDate() {
		return pubDate;
	}

	public void setPubDate(String pubDate) {
		this.pubDate = pubDate;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public String getCoverImg() {
		return coverImg;
	}

	public void setCoverImg(String coverImg) {
		this.coverImg = coverImg;
	}

	public String getPublisher() {
		return publisher;
	}

	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getCategoryName() {
		return categoryName;
	}

	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}

	public int getReviewRank() {
		return reviewRank;
	}

	public void setReviewRank(int reviewRank) {
		this.reviewRank = reviewRank;
	}

	public String getBestDuration() {
		return bestDuration;
	}

	public void setBestDuration(String bestDuration) {
		this.bestDuration = bestDuration;
	}

	public int getBestRank() {
		return bestRank;
	}

	public void setBestRank(int bestRank) {
		this.bestRank = bestRank;
	}

	public int getRecommendCnt() {
		return recommendCnt;
	}

	public void setRecommendCnt(int recommendCnt) {
		this.recommendCnt = recommendCnt;
	}

	public int getCommentCnt() {
		return commentCnt;
	}

	public void setCommentCnt(int commentCnt) {
		this.commentCnt = commentCnt;
	}

	public Book() {
		super();
	}

	public Book(int id, String isbn, String title, String author, String pubDate, String description, int price,
			String coverImg, String publisher, String category, String categoryName, int reviewRank,
			String bestDuration, int bestRank, int recommendCnt, int commentCnt) {
		super();
		this.id = id;
		this.isbn = isbn;
		this.title = title;
		this.author = author;
		this.pubDate = pubDate;
		this.description = description;
		this.price = price;
		this.coverImg = coverImg;
		this.publisher = publisher;
		this.category = category;
		this.categoryName = categoryName;
		this.reviewRank = reviewRank;
		this.bestDuration = bestDuration;
		this.bestRank = bestRank;
		this.recommendCnt = recommendCnt;
		this.commentCnt = commentCnt;
	}

}
