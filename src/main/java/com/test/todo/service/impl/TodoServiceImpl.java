package com.test.todo.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.test.todo.domain.Todo;
import com.test.todo.exception.TodoIdNotFoundException;
import com.test.todo.model.TodoModel;
import com.test.todo.repository.TodoRepository;
import com.test.todo.service.TodoService;

@Service
public class TodoServiceImpl implements TodoService {

	@Resource
	TodoRepository todoRepository;

	@Override
	public Todo getTodoById(String todoId) {
		Todo todo = todoRepository.findOne(todoId);
		if (todo == null)
			throw new TodoIdNotFoundException();
		return todo;

	}

	@Override
	public List<Todo> getAllTodos() {
		return todoRepository.findAll();
	}

	@Override
	public Todo createTodo(TodoModel todoModel) {
		Todo todo = new Todo();
		todo.setTitle(todoModel.getTitle());
		return todoRepository.save(todo);
	}

	@Override
	public Todo updateTodo(String todoId, TodoModel todoModel) {
		Todo todo = todoRepository.findOne(todoId);
		if (todo == null)
			throw new TodoIdNotFoundException();
		if (checkNonNullOrEmpty(todo.getTitle()))
			todo.setTitle(todoModel.getTitle());
		if (todoModel.isComplete() != null)
			todo.setComplete(todoModel.isComplete());
		return todoRepository.save(todo);
	}

	private boolean checkNonNullOrEmpty(String str) {
		return str != null && !str.isEmpty();
	}

	@Override
	public boolean deleteTodo(String todoId) {
		Todo todo = todoRepository.findOne(todoId);
		if (todo == null)
			throw new TodoIdNotFoundException();
		todoRepository.delete(todoId);
		return true;
	}

}
