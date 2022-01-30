package com.sfeir.playoffs.todolist.repository;

import com.sfeir.playoffs.todolist.domain.Todo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TodoRepository extends JpaRepository<Todo,Long> {
}
