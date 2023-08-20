package com.springboot.todoWebApp.service;

import com.springboot.todoWebApp.dao.ToDoRepository;
import com.springboot.todoWebApp.entity.ToDo;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ToDoServiceImpl implements ToDoService{

    private ToDoRepository toDoRepository;

    public ToDoServiceImpl(ToDoRepository toDoRepository){
        this.toDoRepository = toDoRepository;
    }

    @Override
    public List<ToDo> findAll() {
        return toDoRepository.findAll();
    }

    @Override
    public ToDo findById(Integer id) {
        Optional<ToDo> toDo = toDoRepository.findById(id);

        if(toDo.isPresent()){
            return toDo.get();
        } else {
            throw new RuntimeException("To-do with id " + id + "not found.");
        }
    }

    @Override
    public void save(ToDo toDo) {
        toDoRepository.save(toDo);
    }

    @Override
    public void deleteById(Integer id) {
        toDoRepository.deleteById(id);
    }
}
