package kz.fastjava.ulbi.exception;

public class UserWithIDNotExistException extends Exception{

    public UserWithIDNotExistException(Long id) {
        super(String.format("User with %d id not exist", id));
    }

}
