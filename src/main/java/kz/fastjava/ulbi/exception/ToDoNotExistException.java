package kz.fastjava.ulbi.exception;

public class ToDoNotExistException extends Exception {
    public ToDoNotExistException(Long id) {
        super(String.format("ToDo with %d id not exist", id));
    }
}
