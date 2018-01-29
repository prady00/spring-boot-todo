package com.test.todo.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.test.todo.domain.Todo;

@Repository
public interface TodoRepository extends MongoRepository<Todo, String> {

}
