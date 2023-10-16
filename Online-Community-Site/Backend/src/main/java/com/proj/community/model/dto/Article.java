package com.proj.community.model.dto;

import java.util.Date;

public class Article {
	private int id;
	private String title;
	private String writer;
	private String content;
	private String category;
	private int viewCnt;
	private int recommendCnt;
	private String writeDate;
	private int commentCnt;
	
	public Article() {
		super();
	}

	public Article(int id, String title, String writer, String content, String category, int viewCnt, int recommendCnt,
			String writeDate, int commentCnt) {
		super();
		this.id = id;
		this.title = title;
		this.writer = writer;
		this.content = content;	
		this.category = category;
		this.viewCnt = viewCnt;
		this.recommendCnt = recommendCnt;
		this.writeDate = writeDate;
		this.commentCnt = commentCnt;
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

	public String getWriter() {
		return writer;
	}

	public void setWriter(String writer) {
		this.writer = writer;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public int getViewCnt() {
		return viewCnt;
	}

	public void setViewCnt(int viewCnt) {
		this.viewCnt = viewCnt;
	}

	public int getRecommendCnt() {
		return recommendCnt;
	}

	public void setRecommendCnt(int recommendCnt) {
		this.recommendCnt = recommendCnt;
	}

	public String getWriteDate() {
		return writeDate;
	}

	public void setWriteDate(String writeDate) {
		this.writeDate = writeDate;
	}

	public int getCommentCnt() {
		return commentCnt;
	}

	public void setCommentCnt(int commentCnt) {
		this.commentCnt = commentCnt;
	}

	@Override
	public String toString() {
		return "Article [id=" + id + ", title=" + title + ", writer=" + writer + ", content=" + content + ", category="
				+ category + ", viewCnt=" + viewCnt + ", recommendCnt=" + recommendCnt + ", writeDate=" + writeDate
				+ ", commentCnt=" + commentCnt + "]";
	}
	
	
	
	
}
