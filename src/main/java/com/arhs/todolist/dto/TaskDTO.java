package com.arhs.todolist.dto;

import com.arhs.todolist.models.User;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TaskDTO {
    private int taskId;
    private String title;
    private String description;
    private Boolean completed;
    private Integer userId;
}
