package com.arhs.todolist.controller;

import com.arhs.todolist.exception.NotFoundException;
import com.arhs.todolist.models.Task;
import com.arhs.todolist.models.User;
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
    @PostMapping("/save-task")
    private ResponseEntity<Task> saveTask(@RequestBody Task task){
        Task createdTask = taskService.saveTask(task);
        return ResponseEntity.ok(createdTask);
    }

    @DeleteMapping("/delete/{taskId}")
    public ResponseEntity<?> deleteTask(@PathVariable int taskId) {
            taskService.deleteTask(taskId);
            //throw new RuntimeException();
            return ResponseEntity.ok().build();

    }
    @PostMapping("/select-task/{taskId}")
    private ResponseEntity<Task> selectTask(@PathVariable int taskId){
        Optional<Task> selectedTask = taskService.selectTask(taskId);
        if (selectedTask.isPresent()){
            return ResponseEntity.ok(selectedTask.get());
        }else {
            throw new NotFoundException("La tache n'existe pas");
        }
    }



}
