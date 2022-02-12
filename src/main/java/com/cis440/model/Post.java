package com.cis440.model;

public class Post {

    private int id;
    private String title;
    private int parentId;
    private String content;
    private int rating;
    private User owner;

    public Post(int id, String title, int parentId, String content, int rating, User owner)
    {
        this.id = id;
        this.title = title;
        this.parentId = parentId;
        this.content = content;
        this.rating = rating;
        this.owner = owner;
    }

    public int id() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

    public String title() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

    public int parentId() {
		return parentId;
	}

	public void setParentId(int parentId) {
		this.parentId = parentId;
	}

    public String content() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

    public int rating() {
		return rating;
	}

	public void setRating(int rating) {
		this.rating = rating;
	}

    public User owner() {
		return owner;
	}

	public void setOwner(User owner) {
		this.owner = owner;
	}

}
