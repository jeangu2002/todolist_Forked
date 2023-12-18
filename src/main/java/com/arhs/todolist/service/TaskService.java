package com.arhs.todolist.service;

import com.arhs.todolist.models.Task;
import com.arhs.todolist.repository.TaskRepository;
import jakarta.annotation.PostConstruct;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class TaskService {
    private ArrayList<Task> list = new ArrayList<>();
    private final TaskRepository taskRepository;

    @Autowired
    public TaskService(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }
    @PostConstruct
    void init() {
        list.add(new Task(1,"tache1","description1",false));
        list.add(new Task(2, "tache2","description2",false));
    }

    public List<Task> listTasks() {
        return taskRepository.findAll();
    }

    @Transactional
    public Task createTask(Task task) {
        return taskRepository.save(task);
    }

    public Optional<Task> updateTask(int taskId, Task updatedTask) {
        return taskRepository.findById(taskId).map(task -> {
            task.setTitle(updatedTask.getTitle());
            task.setDescription(updatedTask.getDescription());
            task.setCompleted(updatedTask.getCompleted());
            return taskRepository.save(task);
        });
    }
    public void deleteTask(int taskId) {
        taskRepository.deleteById(taskId);
    }
}
