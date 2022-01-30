package com.sfeir.playoffs.todolist.controller;

import com.sfeir.playoffs.todolist.domain.Todo;
import com.sfeir.playoffs.todolist.exception.BeanNotFound;
import com.sfeir.playoffs.todolist.repository.TodoRepository;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.List;

@RestController
@RequestMapping("/todos")
public class TodoController {

    private final TodoRepository repository;

    public TodoController(TodoRepository repository) {
        this.repository = repository;
    }

    @PostMapping(value = "/")
    @ResponseStatus(value= HttpStatus.CREATED)
    public Todo createTodo(@RequestBody Todo todo) {
        return repository.save(todo);
    }

    @GetMapping(value = "/{id}")
    @ResponseStatus(value = HttpStatus.OK)
    public Todo getTodo(@PathVariable Long id) {
        try {
            return repository.findById(id).orElseThrow(BeanNotFound::new);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @GetMapping(value = "/")
    @ResponseStatus(value = HttpStatus.OK)
    public List<Todo> getTodos() {
        try {
            return repository.findAll();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

}
