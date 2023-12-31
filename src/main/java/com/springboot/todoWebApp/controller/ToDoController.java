package com.springboot.todoWebApp.controller;


import com.springboot.todoWebApp.entity.ToDo;
import com.springboot.todoWebApp.service.ToDoService;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class ToDoController {

    private ToDoService toDoService;

    public ToDoController (ToDoService toDoService){
        this.toDoService = toDoService;
    }

    @GetMapping("/")
    public String showHomePage(Model model){
        List<ToDo> toDos = toDoService.findAll();
        model.addAttribute("toDos", toDos);
        return "home";
    }

    @GetMapping("/saveForm")
    public String showSaveForm(Model model){
        ToDo toDo = new ToDo();
        model.addAttribute("toDo", toDo);

        return "form";
    }

    @PostMapping("/save")
    public String saveToDo(@Valid @ModelAttribute("toDo") ToDo toDo, Errors errors){

        if(!errors.hasErrors()){
            toDoService.save(toDo);
            return "redirect:/";
        }
        return "form";
    }

    @GetMapping("/delete")
    public String delete(@RequestParam("id") int id){

        toDoService.deleteById(id);
        return "redirect:/";
    }
}
