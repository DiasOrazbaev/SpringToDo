package kz.fastjava.ulbi.service;

import kz.fastjava.ulbi.entity.TodoEntity;
import kz.fastjava.ulbi.exception.ToDoNotExistException;
import kz.fastjava.ulbi.exception.UserWithIDNotExistException;
import kz.fastjava.ulbi.repository.TodoRepository;
import kz.fastjava.ulbi.repository.UserRepository;
import org.springframework.stereotype.Service;

@Service
public class TodoService {

    private final TodoRepository todoRepository;
    private final UserRepository userRepository;

    public TodoService(TodoRepository todoRepository, UserRepository userRepository) {
        this.todoRepository = todoRepository;
        this.userRepository = userRepository;
    }

    public void createTodo(TodoEntity todo, Long userID) throws UserWithIDNotExistException {
        if (userRepository.existsById(userID)) {
            todo.setUserID(userID);
            todoRepository.save(todo);
        }
        throw new UserWithIDNotExistException(userID);
    }

    public void complete(Long todoID) throws ToDoNotExistException {
        var todo = todoRepository.findById(todoID).orElseThrow(() -> new ToDoNotExistException(todoID));
        todo.setComplete(!todo.getComplete());
        todoRepository.save(todo);
    }
}
