package com.todolist.TodoList.controller;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.todolist.TodoList.entity.Todo;
import com.todolist.TodoList.service.TodoService;

import jakarta.validation.Valid;


@RestController
@RequestMapping("/todos")
public class TodoController {
	
	private TodoService todoService;
	
	
	public TodoController(TodoService todoService) {
		this.todoService = todoService;
	}

	@PostMapping
    public Todo create(@RequestBody @Valid Todo todo){
        return todoService.create(todo); // retorna o objeto criado
    }

    @GetMapping
    public List<Todo> list(){
        return todoService.list();
    }

    @PutMapping("/{id}")
    public Todo update(@PathVariable Long id, @RequestBody Todo todo){
        return todoService.update(id, todo); // retorna o objeto atualizado
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id){
        todoService.delete(id); // geralmente delete retorna void
    }
}