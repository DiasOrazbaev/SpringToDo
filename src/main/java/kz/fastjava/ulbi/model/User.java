package kz.fastjava.ulbi.model;

import kz.fastjava.ulbi.entity.UserEntity;
import lombok.Builder;
import lombok.Data;

import java.util.List;
import java.util.stream.Collectors;

@Data
@Builder
public class User {
    private Long id;
    private String username;
    private List<Todo> todos;

    public static User toModel(UserEntity entity) {
        return User.builder()
                .id(entity.getId())
                .username(entity.getUsername())
                .todos(entity.getTodoEntities().stream().map(Todo::toModel).collect(Collectors.toList()))
                .build();
    }
}
