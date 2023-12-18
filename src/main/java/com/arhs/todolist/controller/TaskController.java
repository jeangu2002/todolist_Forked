package com.arhs.todolist.controller;

import com.arhs.todolist.models.Task;
import com.arhs.todolist.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin
@RequestMapping("api")
public class TaskController {
    @Autowired
    TaskService taskService ;

    @GetMapping("/task")
    private List<Task> listTasks(){
        return taskService.listTasks();
    }
    @PostMapping("/create-task")
    private ResponseEntity<Task> createTasks(@RequestBody Task task){
        Task createdTask = taskService.createTask(task);
        return ResponseEntity.ok(createdTask);
    }
    @PutMapping("/update/{taskId}")
    public ResponseEntity<?> updateTask(@PathVariable int taskId, @RequestBody Task task) {
        Optional<Task> updatedTask = taskService.updateTask(taskId, task);
        return updatedTask.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }
    @DeleteMapping("/delete/{taskId}")
    public ResponseEntity<?> deleteTask(@PathVariable int taskId) {
        try {
            taskService.deleteTask(taskId);
            return ResponseEntity.ok().build();
        } catch (Exception e) {
            // Handle exceptions, like when the task doesn't exist
            return ResponseEntity.notFound().build();
        }
    }
}
