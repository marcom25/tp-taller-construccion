package com.example.TpTaller.list.controller;

import com.example.TpTaller.list.model.TODOList;
import com.example.TpTaller.list.service.TODOListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Controller
@RequestMapping("/todolist")
public class TODOListController {

    @Autowired
    private TODOListService todoListService;

    @GetMapping("/")
    public String getAllTODOLists(Model model) {
        model.addAttribute("todoLists", todoListService.getAllTODOLists());
        return "index";
    }

    @GetMapping("/{id}")
    public String getTODOListById(@PathVariable("id") Long id, Model model) {
        Optional<TODOList> todoList = todoListService.getTODOListById(id);
        if (todoList.isPresent()) {
            model.addAttribute("todoList", todoList.get());
            return "todo_list_detail";
        }
        return "todo_list_not_found";
    }

    @PostMapping
    public String createOrUpdateTODOList(@ModelAttribute TODOList todoList) {
        todoListService.createOrUpdateTODOList(todoList);
        return "redirect:/todolist";
    }

    @GetMapping("/delete/{id}")
    public String deleteTODOList(@PathVariable("id") Long id) {
        todoListService.deleteTODOList(id);
        return "redirect:/todolist";
    }
}
