
/* generated by: ControllerGenerator Wed May 18 15:20:45 CEST 2016 */
package com.littleworld.todo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

import com.littleworld.todo.model.*;
import com.littleworld.todo.services.*;

@CrossOrigin(origins = "http://localhost:4200")
@Controller
public class TodoController {
  
  @Autowired  private TodoService todoService;

  //curl -H "Content-Type: application/json" -X POST -d '{"id": 0, "task": "taskTest"}' http://localhost:8080/todo
  @ResponseBody
  @RequestMapping(value = "/todo", method = RequestMethod.POST)
  public int create(@RequestBody Todo todo) {
    return todoService.save(todo).getId();
  }

  //curl -H "Content-Type: application/json" -X PUT -d '{"id": 1, "task": "taskTest"}' http://localhost:8080/todo/1
  @ResponseBody
  @RequestMapping(value = "/todo/{id}", method = RequestMethod.PUT)
  public int updateTodo(@PathVariable  int id, @RequestBody Todo todo) {
    return todoService.save(todo).getId();
  }

  //curl -X DELETE http://localhost:8080/todo/1
  @ResponseStatus(value = HttpStatus.OK)
  @RequestMapping(value = "/todo/{id}", method = RequestMethod.DELETE)
  public void updateTodo(@PathVariable  int id) {
    todoService.deleteById(id);
  }

  //curl  http://localhost:8080/todo
  @ResponseBody
  @RequestMapping(value = "/todo", method = RequestMethod.GET)
  public List<Todo> findAll() {
    return (List<Todo>)todoService.findAll();
  }

  //curl  http://localhost:8080/todo/1
  @ResponseBody
  @RequestMapping(value = "/todo/{id}", method = RequestMethod.GET)
  public Optional<Todo> todoById(@PathVariable  int id) {
    return todoService.findById(id);
  }

  @RequestMapping(value = "/page", method = RequestMethod.GET)
  public String page() {
      return "todo";
  }
}

