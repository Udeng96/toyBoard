package com.example.toyboard.controller.menu.note;

import com.example.toyboard.domain.menu.note.TodoData;
import com.example.toyboard.service.menu.note.TodoService;
import com.google.gson.Gson;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/todo")
public class TodoController {

    private static final Logger logger = LoggerFactory.getLogger(TodoController.class);
    Gson gson = new Gson();

    @Autowired
    TodoService todoService;

    @GetMapping(value = "/list")
    public String getTodoList(
        @RequestParam(value = "authority", defaultValue = "")String authority,
        @RequestParam(value = "todoId", required = false,defaultValue = "")String todoId
    ){
        List<TodoData> list = todoService.getTodayTodoList(authority,todoId);
        return gson.toJson(list);
    }

    @PostMapping(value = "/add")
    public boolean addTodoItem(
        @RequestBody TodoData todoData
    ){
        return todoService.addTodayTodo(todoData);
    }

    @PostMapping(value = "/modify")
    public boolean modifyTodoItem(
            @RequestBody TodoData todoData,
            @RequestParam(value = "todoId",defaultValue = "")String todoId
    ){
        return todoService.modifyTodayTodo(todoData,todoId);
    }

    @PostMapping(value = "/delete")
    public boolean deleteTodoItem(
            @RequestParam(value = "todoId",defaultValue = "")String todoId
    ){
        return todoService.deleteTodayTodo(todoId);
    }


}
