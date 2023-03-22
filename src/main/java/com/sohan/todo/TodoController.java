package com.sohan.todo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

@Controller
@SessionAttributes("name")
public class TodoController {
    private final TodoService service;
    @Autowired
    public TodoController(TodoService service) {
        this.service = service;
    }
    @RequestMapping(value = "/list-todo", method = RequestMethod.GET)
    public String listTodos(ModelMap model, String name){
        model.addAttribute("todos",service.retrieveTodos("in28Minutes"));
        System.out.println(service.retrieveTodos("in28Minutes"));
        return "list-todo";
    }
    @RequestMapping(value = "/add-todo", method = RequestMethod.GET)
    public String showTodosPage(){
        return "todo";
    }

}
