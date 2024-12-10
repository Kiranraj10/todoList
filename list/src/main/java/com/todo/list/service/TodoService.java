package com.todo.list.service;

import com.todo.list.Todo;
import com.todo.list.repo.TodoRepo;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TodoService {
    private TodoRepo todoRepo;

    public TodoService(TodoRepo todoRepo) {
        this.todoRepo = todoRepo;
    }

    public ResponseEntity addTodo(Todo t)  {
        todoRepo.save(t);
        return ResponseEntity.ok(t);
    }

    public List<Todo> getTodos() {
        return todoRepo.findAll();
    }

    public Todo getTodo( Long id) {
        Optional<Todo>t= todoRepo.findById(id);
        return t.orElse(null);
    }

    public Todo setTodoDone( Long id) {
        Todo t= todoRepo.findById(id).orElse(null);
        if(t!=null){
            todoRepo.updateIsDoneToTrue(id);
        }else{
            return null;
        }
       return t;
    }

    public void deleteTodo( Long id) {
        todoRepo.deleteById(id);
    }
}
