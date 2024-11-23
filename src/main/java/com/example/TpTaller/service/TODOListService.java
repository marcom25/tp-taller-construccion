package com.example.TpTaller.service;

import com.example.TpTaller.model.TODOList;
import com.example.TpTaller.repo.TODOListRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TODOListService {

    @Autowired
    private TODOListRepository todoListRepository;

    public List<TODOList> getAllTODOLists() {
        return todoListRepository.findAll();
    }

    public TODOList getTODOListById(Long id) {
        Optional<TODOList> opTodoList = todoListRepository.findById(id);
        TODOList todoList = null;
        if (opTodoList.isEmpty()) {
            throw new RuntimeException("TODO No encontrado");
        }
        todoList = opTodoList.get();
        return todoList;
    }

    public void createTODOList(TODOList todoList) {
        todoListRepository.save(todoList);
    }

    public void deleteTODOList(Long id) {
        todoListRepository.deleteById(id);
    }
}
