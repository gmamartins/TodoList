package com.todolist.TodoList.service;

import java.util.List;

import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import com.todolist.TodoList.repository.TodoRepository;
import com.todolist.TodoList.entity.Todo;


@Service
public class TodoService {
	
	private TodoRepository todoRepository;
	
	public TodoService(TodoRepository todoRepository) {
		this.todoRepository = todoRepository;
	}
	
	
	public Todo create(Todo todo){
	    return todoRepository.save(todo);
	}

	public List<Todo> list(){
	    return todoRepository.findAll();
	}

	public Todo update(Long id, Todo todo){
	    return todoRepository.findById(id)
	        .map(t -> {
	            t.setNome(todo.getNome());
	            t.setDescricao(todo.getDescricao());
	            t.setRealizado(todo.getRealizado());
	            t.setPrioridade(todo.getPrioridade());
	            return todoRepository.save(t);
	        }).orElseThrow(() -> new RuntimeException("Todo não encontrado"));
	}

	public void delete(Long id){
	    todoRepository.deleteById(id);
	}
	
	
}
