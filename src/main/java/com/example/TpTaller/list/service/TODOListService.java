package com.example.TpTaller.list.service;

import com.example.TpTaller.list.model.TODOList;
import com.example.TpTaller.list.repo.TODOListRepository;
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

    public Optional<TODOList> getTODOListById(Long id) {
        return todoListRepository.findById(id);
    }

    public void createTODOList(String name) {
        TODOList newTODOList = new TODOList();
        newTODOList.setName(name);
        todoListRepository.save(newTODOList);
    }

    public TODOList createOrUpdateTODOList(TODOList todoList) {
        return todoListRepository.save(todoList);
    }

    public void deleteTODOList(Long id) {
        todoListRepository.deleteById(id);
    }
}
