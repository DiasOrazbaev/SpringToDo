package kz.fastjava.ulbi.service;

import kz.fastjava.ulbi.entity.UserEntity;
import kz.fastjava.ulbi.exception.UserAlreadyExistException;
import kz.fastjava.ulbi.exception.UserWithIDNotExistException;
import kz.fastjava.ulbi.model.User;
import kz.fastjava.ulbi.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserService {

    private final UserRepository repository;

    public UserService(UserRepository repository) {
        this.repository = repository;
    }

    public void register(UserEntity entity) throws UserAlreadyExistException {
        if (repository.findByUsername(entity.getUsername()) != null) {
            throw new UserAlreadyExistException();
        }
        repository.save(entity);
    }

    public List<User> getAll() {
        return ((List<UserEntity>) repository.findAll()).stream().map(User::toModel).collect(Collectors.toList());
    }

    public User getWithID(Long id) throws UserWithIDNotExistException {
        return User.toModel(repository.findById(id).orElseThrow(() -> new UserWithIDNotExistException(id)));
    }
}
