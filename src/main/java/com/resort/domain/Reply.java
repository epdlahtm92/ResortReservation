package com.resort.domain;

public class Reply {
	
	private int rootId;
	private int replyId;
	private String replyCategory;
	private String replyUser;
	private String replyContent;
	private String replyDate;
	
	public Reply() {
		super();
	}
	public int getRootId() {
		return rootId;
	}
	public void setRootId(int rootId) {
		this.rootId = rootId;
	}
	public int getReplyId() {
		return replyId;
	}
	public void setReplyId(int replyId) {
		this.replyId = replyId;
	}
	public String getReplyCategory() {
		return replyCategory;
	}
	public void setReplyCategory(String replyCategory) {
		this.replyCategory = replyCategory;
	}
	public String getReplyUser() {
		return replyUser;
	}
	public void setReplyUser(String replyUser) {
		this.replyUser = replyUser;
	}
	public String getReplyContent() {
		return replyContent;
	}
	public void setReplyContent(String replyContent) {
		this.replyContent = replyContent;
	}
	public String getReplyDate() {
		return replyDate;
	}
	public void setReplyDate(String replyDate) {
		this.replyDate = replyDate;
	}
	
	
}
