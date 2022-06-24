package kz.fastjava.ulbi.controller;

import kz.fastjava.ulbi.entity.TodoEntity;
import kz.fastjava.ulbi.exception.ToDoNotExistException;
import kz.fastjava.ulbi.exception.UserWithIDNotExistException;
import kz.fastjava.ulbi.service.TodoService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/todos")
public class TodoController {

    private final TodoService service;

    public TodoController(TodoService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<String> createToDo(@RequestBody TodoEntity todo, @RequestParam Long id) {
        try {
            service.createTodo(todo, id);
            return ResponseEntity.ok("Todo created successfully!");
        } catch (UserWithIDNotExistException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @PutMapping
    public ResponseEntity<String> completeTodo(@RequestParam Long id) {
        try {
            service.complete(id);
            return ResponseEntity.ok("Value of status changed!");
        } catch (ToDoNotExistException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
}
