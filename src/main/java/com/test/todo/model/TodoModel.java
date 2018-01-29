package com.test.todo.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class TodoModel {

	private String title;

	@JsonProperty("isComplete")
	private Boolean isComplete;

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	@JsonProperty("isComplete")
	public Boolean isComplete() {
		return isComplete;
	}
	
	@JsonProperty("isComplete")
	public void setComplete(Boolean isComplete) {
		this.isComplete = isComplete;
	}

}
