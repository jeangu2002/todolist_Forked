package com.arhs.todolist.controller;

import com.arhs.todolist.exception.NotFoundException;
import com.arhs.todolist.models.Task;
import com.arhs.todolist.models.User;
import com.arhs.todolist.service.TaskService;
import com.arhs.todolist.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@CrossOrigin
@RequestMapping("api")
public class UserController {
    @Autowired
    UserService userService ;
    @PostMapping("/select-user/{userId}")
    private ResponseEntity<User> selectUser(@PathVariable int userId){
        Optional<User> selectedUser = userService.selectUser(userId);
        if (selectedUser.isPresent()){
            return ResponseEntity.ok(selectedUser.get());
        }else {
            throw new NotFoundException("Le user n'existe pas");
        }
    }
}
