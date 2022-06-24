package kz.fastjava.ulbi.exception;

public class UserAlreadyExistException extends Exception{
    public UserAlreadyExistException() {
        super("User with same username already exist");
    }
}
