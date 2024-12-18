package com.todo.list;

import com.todo.list.service.TodoService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/todo")
public class TodoController {
    private TodoService todoService;

    public TodoController(TodoService todoService) {
        this.todoService = todoService;
    }

    @GetMapping("/get")
    public List<Todo> getTodo() {
       return todoService.getTodos();
    }
    @GetMapping("/get/{id}")
    public Todo getTodo(@PathVariable("id") Long id) {
        return todoService.getTodo(id);
    }
    @PostMapping("/add")
    public ResponseEntity addTodo(@RequestBody Todo t) {
        return todoService.addTodo(t);
    }

    @PostMapping("/done/{id}")
    public ResponseEntity setTodoDone(@PathVariable("id") Long id) {
        todoService.setTodoDone(id);
        return ResponseEntity.ok().build();

    }

    @DeleteMapping("/delete/{id}")
    public void deleteTodo(@PathVariable("id") Long id) {
         todoService.deleteTodo(id);
    }
}
