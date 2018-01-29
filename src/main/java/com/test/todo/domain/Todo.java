package com.test.todo.domain;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import com.fasterxml.jackson.annotation.JsonProperty;

@Document(collection = "todo")
public class Todo {

	@Id
	private String id;

	private String title;

	@JsonProperty("isComplete")
	private boolean isComplete;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	@JsonProperty("isComplete")
	public boolean isComplete() {
		return isComplete;
	}

	@JsonProperty("isComplete")
	public void setComplete(boolean isComplete) {
		this.isComplete = isComplete;
	}

}
