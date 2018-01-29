package com.test.todo.controller;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.test.todo.domain.Todo;
import com.test.todo.exception.TodoIdNotFoundException;
import com.test.todo.model.TodoModel;
import com.test.todo.service.TodoService;

@RestController
@CrossOrigin
@RequestMapping("/todos")
public class TodoController {

	@Resource
	TodoService todoService;

	@GetMapping("/{todoId}")
	public ResponseEntity<Todo> getTodoById(@PathVariable(name = "todoId", required = true) String todoId) {
		return new ResponseEntity<>(todoService.getTodoById(todoId), HttpStatus.OK);
	}

	@GetMapping
	public ResponseEntity<List<Todo>> getAllTodos() {
		return new ResponseEntity<>(todoService.getAllTodos(), HttpStatus.OK);
	}
	
	@PostMapping
	public ResponseEntity<Todo> createTodo(@RequestBody TodoModel todoModel) {
		return new ResponseEntity<>(todoService.createTodo(todoModel), HttpStatus.OK);
	}
	
	@PutMapping("/{todoId}")
	public ResponseEntity<Todo> updateTodo(@PathVariable(name = "todoId", required = true) String todoId, @RequestBody TodoModel todoModel) {
		return new ResponseEntity<>(todoService.updateTodo(todoId, todoModel), HttpStatus.OK);
	}
	
	@DeleteMapping("/{todoId}")
	public ResponseEntity<Boolean> deleteTodo(@PathVariable(name = "todoId", required = true) String todoId) {
		return new ResponseEntity<>(todoService.deleteTodo(todoId), HttpStatus.OK);
	}
	
	@ExceptionHandler
	@ResponseStatus(HttpStatus.NOT_FOUND)
	public void handleTodoIdNotFoundException(TodoIdNotFoundException ex){
		
	}

}
