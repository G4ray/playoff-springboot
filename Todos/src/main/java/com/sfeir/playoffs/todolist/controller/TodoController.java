package com.sfeir.playoffs.todolist.controller;

import com.sfeir.playoffs.todolist.domain.Todo;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("TODO")
public class TodoController {


    public TodoController() {}

    public Todo createTodo(@RequestBody Todo todo) {
        return null;
    }

}
