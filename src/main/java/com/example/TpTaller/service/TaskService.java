package com.example.TpTaller.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.TpTaller.repo.TaskRepository;

@Service
public class TaskService {
    @Autowired
    TaskRepository taskRepository;

    public void deleteTaskById(Long taskId) {
        taskRepository.deleteById(taskId);
    }
}
