package com.proj.community.model.dto;

import java.util.Date;

public class Comment {
	private int id;
	private String writer;
	private String content;
	private int articleId;
	private String category;
	private int recommendCnt;
	private String writeDate;
	private int isDelete;

	public Comment() {
		super();
	}

	public Comment(int id, String writer, String content, int articleId, String category, int recommendCnt,
			String writeDate, int isDelete) {
		super();
		this.id = id;
		this.writer = writer;
		this.content = content;
		this.articleId = articleId;
		this.category = category;
		this.recommendCnt = recommendCnt;
		this.writeDate = writeDate;
		this.isDelete = isDelete;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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

	public int getArticleId() {
		return articleId;
	}

	public void setArticleId(int articleId) {
		this.articleId = articleId;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
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

	public int getIsDelete() {
		return isDelete;
	}

	public void setIsDelete(int isDelete) {
		this.isDelete = isDelete;
	}

	@Override
	public String toString() {
		return "Comment [id=" + id + ", writer=" + writer + ", content=" + content + ", articleId=" + articleId
				+ ", category=" + category + ", recommendCnt=" + recommendCnt + ", writeDate=" + writeDate
				+ ", isDelete=" + isDelete + "]";
	}

}
