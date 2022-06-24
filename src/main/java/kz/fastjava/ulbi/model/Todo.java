package kz.fastjava.ulbi.model;

import kz.fastjava.ulbi.entity.TodoEntity;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Todo {
    private Long id;
    private String title;
    private Boolean complete;

    public static Todo toModel(TodoEntity entity) {
        return Todo.builder().id(entity.getUserID()).title(entity.getTitle()).complete(entity.getComplete()).build();
    }
}
