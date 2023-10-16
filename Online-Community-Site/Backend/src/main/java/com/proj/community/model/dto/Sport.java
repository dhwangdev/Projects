package com.proj.community.model.dto;

public class Sport {
	private int id;
	private String title;
	private String key;
	private int recommendCnt;
	private int commentCnt;
	private String category;
	private int viewCnt;
	
	public Sport() {
		super();
	}

	public Sport(int id, String title, String key, String category, int recommendCnt, int viewCnt, int commentCnt) {
		super();
		this.id = id;
		this.title = title;
		this.key = key;
		this.category = category;
		this.recommendCnt = recommendCnt;
		this.viewCnt = viewCnt;
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

	public String getKey() {
		return key;
	}

	public void setKey(String key) {
		this.key = key;
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

	public int getViewCnt() {
		return viewCnt;
	}

	public void setViewCnt(int viewCnt) {
		this.viewCnt = viewCnt;
	}

	public int getCommentCnt() {
		return commentCnt;
	}

	public void setCommentCnt(int commentCnt) {
		this.commentCnt = commentCnt;
	}

	@Override
	public String toString() {
		return "Sport [id=" + id + ", title=" + title + ", key=" + key + ", category=" + category + ", recommendCnt="
				+ recommendCnt + ", viewCnt=" + viewCnt + ", commentCnt=" + commentCnt + "]";
	}
	
	
}
