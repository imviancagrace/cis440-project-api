package com.cis440.model;

public class Post {

    private int id;
    private String title;
    private int parentId;
    private String content;
    private int rating;
    private int ownerId;

    public Post(int id, String title, int parentId, String content, int rating, int ownerId)
    {
        this.id = id;
        this.title = title;
        this.parentId = parentId;
        this.content = content;
        this.rating = rating;
        this.ownerId = ownerId;
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

    public int getParentId() {
		return parentId;
	}

	public void setParentId(int parentId) {
		this.parentId = parentId;
	}

    public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

    public int getRating() {
		return rating;
	}

	public void setRating(int rating) {
		this.rating = rating;
	}

    public int getOwnerId() {
		return ownerId;
	}

	public void setOwnerId(int ownerId) {
		this.ownerId = ownerId;
	}

}
