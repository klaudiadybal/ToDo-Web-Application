package com.springboot.todoWebApp.service;

import com.springboot.todoWebApp.entity.ToDo;

import java.util.List;

public interface ToDoService {

    public List<ToDo> findAll();

    public ToDo findById(Long id);

    public void save(ToDo toDo);

    public void deleteById(Long id);

}
