package com.todo.todo;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/employees")
public class TodoController{
  @Autowired
  private TodoRepository repo;
  
  @RequestMapping(method = RequestMethod.GET)
  public List<Todo> findItems() {
    return repo.findAll();
  }
  
  @RequestMapping(value = "/{id}",method = RequestMethod.GET)
  public Todo findone(@PathVariable Integer id) {
    return  repo.findOne(id);
  }
  
  @RequestMapping(method = RequestMethod.POST)
  public Todo addItem(@RequestBody Todo employee) {
	  employee.setId(null);
    return repo.saveAndFlush(employee);
  }
  
  @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
  public Todo updateemployee(@RequestBody Todo updatedemployee, @PathVariable Integer id) {
    updatedemployee.setId(id);
    return repo.saveAndFlush(updatedemployee);
  }
  
  @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
  public void deleteItem(@PathVariable Integer id) {
    repo.delete(id);
  }
}         