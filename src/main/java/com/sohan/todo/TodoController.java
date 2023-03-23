package com.sohan.todo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import javax.validation.Valid;
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
    public String showAddTodoPage(ModelMap model) {
        model.addAttribute("todo", new Todo());
        return "todo";
    }
    @RequestMapping(value = "/add-todo", method = RequestMethod.POST)
    public String addTodo(ModelMap model, @Valid Todo todo, BindingResult result) {

        if (result.hasErrors())
            return "todo";

        System.out.println(todo.getDesc());

        service.addTodo("SohanJain",todo.getDesc(), new Date(), false);
        model.clear();// to prevent request parameter "name" to be passed
        return "redirect:/list-todo";
    }

    @RequestMapping(value = "/delete-todo", method = RequestMethod.GET)
    public String deleteTodo(ModelMap model, @RequestParam int id){
        service.deleteTodo(id);
        model.clear();
        return "redirect:/list-todo";
    }

}
