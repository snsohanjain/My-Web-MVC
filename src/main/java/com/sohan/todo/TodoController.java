package com.sohan.todo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import java.util.Date;

@Controller
@SessionAttributes("name")
public class TodoController {
    private  TodoService service;
    @Autowired
    public TodoController(TodoService service) {
        this.service = service;
    }
    @RequestMapping(value = "/list-todo", method = RequestMethod.GET)
    public String showTodosList(ModelMap model) {
        model.addAttribute("todos", service.retrieveTodos("SohanJain"));
        return "list-todo";
    }
    @RequestMapping(value = "/add-todo", method = RequestMethod.GET)
    public String showTodoPage(){
        return "todo";
    }
    @RequestMapping(value = "/add-todo", method = RequestMethod.POST)
    public String addTodo(ModelMap model , @RequestParam String desc){
        service.addTodo("SohanJain", desc, new Date(),false);
        model.clear();
        return "redirect:/list-todo";
    }
    @RequestMapping(value = "/delete-todo", method = RequestMethod.GET)
    public String deleteTodo(ModelMap model, @RequestParam int id){
        service.deleteTodo(id);
        model.clear();
        return "redirect:/list-todo";
    }

}
