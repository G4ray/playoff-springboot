package com.sfeir.playoffs.todolist.controller;

import com.sfeir.playoffs.todolist.domain.Todo;
import com.sfeir.playoffs.todolist.exception.BeanNotFound;
import com.sfeir.playoffs.todolist.repository.TodoRepository;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

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

    @GetMapping(value = "/")
    public Collection<Todo> getTodos() {
        return repository.findAll();
    }

    @GetMapping(value = "/{id}")
    public Todo getTodo(@PathVariable Long id) throws BeanNotFound {
        return repository.findById(id).orElseThrow(() -> new BeanNotFound());
    }

    @PutMapping(value = "/{id}")
    public Todo updateTodo(@PathVariable Long id,@RequestBody Todo todo) throws BeanNotFound {
        getTodo(id);
        todo.setId(id);
        return repository.save(todo);
    }

    @DeleteMapping(value = "/{id}")
    @ResponseStatus(value= HttpStatus.NO_CONTENT)
    public void deleteTodo (@PathVariable Long id) throws BeanNotFound{
        getTodo(id);
        repository.deleteById(id);
    }
}
