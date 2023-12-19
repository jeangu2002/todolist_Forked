package com.arhs.todolist.service;

import com.arhs.todolist.models.Task;
import com.arhs.todolist.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TaskService {

    private final TaskRepository taskRepository;

    @Autowired
    public TaskService(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    public List<Task> listTasks() {
        return taskRepository.findAll();
    }

    public Task saveTask(Task task) {

        return taskRepository.save(task);
    }

    public void deleteTask(int taskId) {
        taskRepository.deleteById(taskId);
    }

    public Optional<Task> selectTask(int taskId) {
        return taskRepository.findById(taskId);
    }


}
