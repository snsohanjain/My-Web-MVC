package com.sohan.todo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class TodoRestController {
    private final TodoService todoService;
    @Autowired
    public TodoRestController(TodoService todoService) {
        this.todoService = todoService;
    }

    @RequestMapping(path = "/todos")
    public List<Todo> getAllTodos(){
        return todoService.retrieveTodos("sohanjain");
    }
    @RequestMapping(path = "/todos/{id}")
    public Todo getTodosById(@PathVariable int id){
        return todoService.retrieveTodo(id);
    }
}
