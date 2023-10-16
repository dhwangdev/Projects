package com.proj.community.model.dto;

import java.util.Date;

public class Recomment {
	private int reId;
	private String reWriter;
	private String reContent;
	private int reCommentId;
	private int reReommendCnt;
	private String reWriteDate;
	private int reIsDelete;
	
	public Recomment() {
		super();
	}

	public Recomment(int reId, String reWriter, String reContent, int reCommentId, int reReommendCnt,
			String reWriteDate, int reIsDelete) {
		super();
		this.reId = reId;
		this.reWriter = reWriter;
		this.reContent = reContent;
		this.reCommentId = reCommentId;
		this.reReommendCnt = reReommendCnt;
		this.reWriteDate = reWriteDate;
		this.reIsDelete = reIsDelete;
	}

	public int getReId() {
		return reId;
	}

	public void setReId(int reId) {
		this.reId = reId;
	}

	public String getReWriter() {
		return reWriter;
	}

	public void setReWriter(String reWriter) {
		this.reWriter = reWriter;
	}

	public String getReContent() {
		return reContent;
	}

	public void setReContent(String reContent) {
		this.reContent = reContent;
	}

	public int getReCommentId() {
		return reCommentId;
	}

	public void setReCommentId(int reCommentId) {
		this.reCommentId = reCommentId;
	}

	public int getReReommendCnt() {
		return reReommendCnt;
	}

	public void setReReommendCnt(int reReommendCnt) {
		this.reReommendCnt = reReommendCnt;
	}

	public String getReWriteDate() {
		return reWriteDate;
	}

	public void setReWriteDate(String reWriteDate) {
		this.reWriteDate = reWriteDate;
	}

	public int getReIsDelete() {
		return reIsDelete;
	}

	public void setReIsDelete(int reIsDelete) {
		this.reIsDelete = reIsDelete;
	}

	@Override
	public String toString() {
		return "Recomment [reId=" + reId + ", reWriter=" + reWriter + ", reContent=" + reContent + ", reCommentId="
				+ reCommentId + ", reReommendCnt=" + reReommendCnt + ", reWriteDate=" + reWriteDate + ", reIsDelete="
				+ reIsDelete + "]";
	}

	
}
