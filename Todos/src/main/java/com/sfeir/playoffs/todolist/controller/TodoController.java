package com.sfeir.playoffs.todolist.controller;

import com.sfeir.playoffs.todolist.domain.Todo;
import com.sfeir.playoffs.todolist.exception.BeanNotFound;
import com.sfeir.playoffs.todolist.repository.TodoRepository;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
@RequestMapping() // TODO add path API
public class TodoController {

    private final TodoRepository repository;

    public TodoController(TodoRepository repository) {
        this.repository = repository;
    }

    @PostMapping(value = "/")
    @ResponseStatus(value= HttpStatus.CREATED)
    public Todo createTodo(@RequestBody Todo todo) {
        // add to base
        return null;
    }

    // TODO add getTodos
    // TODO add getTodoById
    // TODO add updateTodo
    // TODO add deleteTodo

}
