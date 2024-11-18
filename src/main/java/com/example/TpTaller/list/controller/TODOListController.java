package com.example.TpTaller.list.controller;

import com.example.TpTaller.list.model.TODOList;
import com.example.TpTaller.list.service.TODOListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
public class TODOListController {

    @Autowired
    private TODOListService todoListService;

    @GetMapping
    public String getAllTODOLists(Model model) {
        List<TODOList> todoLists = todoListService.getAllTODOLists();
        model.addAttribute("todoLists", todoLists);
        return "index";
    }

//    @GetMapping("/{id}")
//    public String getTODOListById(@PathVariable("id") Long id, Model model) {
//        Optional<TODOList> todoList = todoListService.getTODOListById(id);
//        if (todoList.isPresent()) {
//            model.addAttribute("todoList", todoList.get());
//            return "todo_list_detail"; // Vista para detalles de la lista
//        }
//        return "todo_list_not_found"; // Vista de error
//    }

    @PostMapping
    public String createOrUpdateTODOList(@RequestParam String name) {
        todoListService.createTODOList(name);
        return "redirect:/";
    }

    @GetMapping("/{id}/delete")
    public String deleteTODOList(@PathVariable("id") Long id) {
        todoListService.deleteTODOList(id);
        return "redirect:/";
    }


}
