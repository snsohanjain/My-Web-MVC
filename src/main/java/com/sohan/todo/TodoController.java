package com.sohan.todo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.text.SimpleDateFormat;
import java.util.Date;

@Controller
@SessionAttributes("name")
public class TodoController {
    private  TodoService service;
    @InitBinder
    protected void initBinder(WebDataBinder binder) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        binder.registerCustomEditor(Date.class, new CustomDateEditor(
                dateFormat, false));
    }
    @Autowired
    public TodoController(TodoService service) {
        this.service = service;
    }
    @RequestMapping(value = "/list-todo", method = RequestMethod.GET)
    public String showTodosList(ModelMap model) {
        String user = getLoggedInUserName();
        model.addAttribute("todos", service.retrieveTodos(user));
        return "list-todo";
    }

    @RequestMapping(value = "/add-todo", method = RequestMethod.GET)
    public String showAddTodoPage(ModelMap model) {
        model.addAttribute("todo", new Todo());
        return "todo";
    }
    @RequestMapping(value = "/add-todo", method = RequestMethod.POST)
    public String addTodo(ModelMap model, @Valid Todo todo, BindingResult result) {

//        throw new RuntimeException("exception");
        if (result.hasErrors())
            return "todo";

        service.addTodo(getLoggedInUserName(), todo.getDesc(),
                todo.getTargetDate(), false);
        model.clear();// to prevent request parameter "name" to be passed
        return "redirect:/list-todo";
    }
    private String getLoggedInUserName() {
        Object principal = SecurityContextHolder.getContext()
                .getAuthentication().getPrincipal();

        if (principal instanceof UserDetails)
            return ((UserDetails) principal).getUsername();

        return principal.toString();
    }
    @RequestMapping(value = "/update-todo", method = RequestMethod.GET)
    public String updateTodo(ModelMap model, @RequestParam int id){
        Todo todo = service.retrieveTodo(id);
        model.addAttribute("todo", todo);
        return "todo";
    }
    @RequestMapping(value = "/update-todo", method = RequestMethod.POST)
    public String updateTodo(ModelMap model, @Valid Todo todo, BindingResult result){
        if (result.hasErrors()) {
            return "todo";
        }
        todo.setUser("sohanjain");
        service.updateTodo(todo);

        System.out.println(todo);
        return "redirect:/list-todo";
    }

    @RequestMapping(value = "/delete-todo", method = RequestMethod.GET)
    public String deleteTodo(ModelMap model, @RequestParam int id){
        service.deleteTodo(id);
        model.clear();
        return "redirect:/list-todo";
    }

}
