package com.example.TpTaller.controller;

import com.example.TpTaller.model.TODOList;
import com.example.TpTaller.service.TODOListService;
import com.example.TpTaller.model.Task;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
public class TODOListController {

    @Autowired
    private TODOListService todoListService;

    @GetMapping("/")
    public String viewHomePage(Model model) {
        List<TODOList> todoLists = todoListService.getAllTODOLists();
        model.addAttribute("todoLists", todoLists);
        return "index";
    }

    @GetMapping("/newTodoListForm")
    public String createNewTodoList(Model model){
        TODOList todoList = new TODOList();
        model.addAttribute("todoList", todoList);
        return "new_todo";
    }

    @PostMapping("/createTodoList")
    public String createOrUpdateTODOList(@ModelAttribute("todoList") TODOList todoList) {
        if (todoList.getTaskList() != null) {
            // Asignar el TODOList a cada Task
            for (Task task : todoList.getTaskList()) {
                task.setTodoList(todoList);
            }
        } else {
            todoList.setTaskList(new ArrayList<>()); // Asegurar que no sea null
        }
        todoListService.createTODOList(todoList);
        return "redirect:/";
    }

    @GetMapping("/updateTodoListForm/{id}")
    public String updateTodoList(@PathVariable(value ="id") long id,Model model){
        TODOList todoList = todoListService.getTODOListById(id);
        model.addAttribute("todoList", todoList);
        return "update_todo";
    }

    @GetMapping("/deleteTodoList/{id}")
    public String deleteTODOList(@PathVariable(value = "id") long id) {
        todoListService.deleteTODOList(id);
        return "redirect:/";
    }


}
