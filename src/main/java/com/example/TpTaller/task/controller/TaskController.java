package com.example.TpTaller.task.controller;

import com.example.TpTaller.task.model.Task;
import com.example.TpTaller.task.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Controller
public class TaskController {

    @Autowired
    private TaskService taskService;

//    @GetMapping
//    public String getAllTasks(Model model) {
//        model.addAttribute("tasks", taskService.getAllTasks());
//        return "task_list"; // Vista con la lista de tareas
//    }

//    @GetMapping("/{id}")
//    public String getTaskById(@PathVariable("id") Long id, Model model) {
//        Optional<Task> task = taskService.getTaskById(id);
//        if (task.isPresent()) {
//            model.addAttribute("task", task.get());
//            return "task_detail"; // Vista para detalles de la tarea
//        }
//        return "task_not_found"; // Vista de error
//    }
//
//    @PostMapping
//    public String createOrUpdateTask(@ModelAttribute Task task) {
//        taskService.createOrUpdateTask(task);
//        return "redirect:/tasks";
//    }

    @GetMapping("/{id}/toggle")
    public String toggleTask(@PathVariable Long id){
        taskService.toggleCompletion(id);
        return "redirect:/";
    }

    @GetMapping("/delete/{id}")
    public String deleteTask(@PathVariable("id") Long id) {
        taskService.deleteTask(id);
        return "redirect:/";
    }
}
