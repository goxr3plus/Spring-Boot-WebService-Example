package com.example.restfulwebservices.model;

public class Post {

	private String content;

	public Post(String content) {
		super();
		this.content = content;
	}

	/**
	 * @return the content
	 */
	public String getContent() {
		return content;
	}

	/**
	 * @param content the content to set
	 */
	public void setContent(String content) {
		this.content = content;
	}

}
