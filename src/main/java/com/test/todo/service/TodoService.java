package com.test.todo.service;

import java.util.List;

import com.test.todo.domain.Todo;
import com.test.todo.model.TodoModel;

public interface TodoService {

	Todo getTodoById(String todoId);
	
	List<Todo> getAllTodos();
	
	Todo createTodo(TodoModel todoModel);
	
	Todo updateTodo(String todoId, TodoModel todoModel);

	boolean deleteTodo(String todoId);

}
