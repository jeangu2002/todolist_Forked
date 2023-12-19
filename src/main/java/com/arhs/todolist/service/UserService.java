package com.arhs.todolist.service;

import com.arhs.todolist.models.Task;
import com.arhs.todolist.models.User;
import com.arhs.todolist.repository.TaskRepository;
import com.arhs.todolist.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
@Service
public class UserService {
    private final UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }
    public Optional<User> selectUser(int userId) {
        return userRepository.findById(userId);
    }
}
