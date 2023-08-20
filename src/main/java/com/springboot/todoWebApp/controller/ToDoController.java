package com.springboot.todoWebApp.controller;


import com.springboot.todoWebApp.entity.ToDo;
import com.springboot.todoWebApp.service.ToDoService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

import java.util.List;

@Controller
public class ToDoController {

    private ToDoService toDoService;

    public ToDoController (ToDoService toDoService){
        this.toDoService = toDoService;
    }

    public void getToDos(Model model){
        List<ToDo> toDos = toDoService.findAll();
        model.addAttribute("toDos", toDos);
    }

    @GetMapping("/")
    public String showHomePage(){
        return "home";
    }
}
