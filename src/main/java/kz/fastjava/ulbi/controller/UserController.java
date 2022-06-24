package kz.fastjava.ulbi.controller;

import kz.fastjava.ulbi.entity.UserEntity;
import kz.fastjava.ulbi.exception.UserAlreadyExistException;
import kz.fastjava.ulbi.exception.UserWithIDNotExistException;
import kz.fastjava.ulbi.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@Slf4j
@RequestMapping("/users")
public class UserController {

    private final UserService service;

    public UserController(UserService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<String> registration(@RequestBody UserEntity entity) {
        try {
            service.register(entity);
            return ResponseEntity.ok("User correct created!");
        } catch (UserAlreadyExistException e) {
            log.warn(e.getMessage());
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @GetMapping
    public ResponseEntity<String> getUser() {
        return ResponseEntity.ok(service.getAll().toString());
    }

    @GetMapping("/{id}")
    public ResponseEntity<String> getUserWithID(@PathVariable Long id) {
        try {
            return ResponseEntity.ok(service.getWithID(id).toString());
        } catch (UserWithIDNotExistException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
}
