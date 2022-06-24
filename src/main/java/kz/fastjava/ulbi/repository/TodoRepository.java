package kz.fastjava.ulbi.repository;

import kz.fastjava.ulbi.entity.TodoEntity;
import org.springframework.data.repository.CrudRepository;

public interface TodoRepository extends CrudRepository<TodoEntity, Long> {

}
