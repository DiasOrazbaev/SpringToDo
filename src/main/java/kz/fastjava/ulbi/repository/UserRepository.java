package kz.fastjava.ulbi.repository;

import kz.fastjava.ulbi.entity.UserEntity;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<UserEntity, Long> {

    UserEntity findByUsername(String username);
}
