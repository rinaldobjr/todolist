package com.stefanini.todolist.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.stefanini.todolist.domain.entity.Task;
import com.stefanini.todolist.service.TaskService;

@RestController
@RequestMapping(path="/api/v1/tasks")
public class TaskController {

	@Autowired
	private TaskService taskService;
	
	@PostMapping(value="/create", produces = "application/json")
	public ResponseEntity<Task> savedTask(@RequestBody Task task) {
		return new ResponseEntity<Task>(this.taskService.createTask(task), HttpStatus.CREATED);
	}
	
	@GetMapping(value="/list", produces = "application/json")
	public ResponseEntity<List<Task>> listTaskAll() {
		return new ResponseEntity<List<Task>>(this.taskService.listAllTasks(), HttpStatus.OK);
	}
	
	@GetMapping(value="/{id}", produces = "application/json")
	@ResponseStatus(HttpStatus.OK)
	public ResponseEntity<Task> getTaskById(@PathVariable (value= "id") Long id) {
		return this.taskService.findTaskById(id);
	}
	
    @PutMapping(value = "/{id}", produces = "application/json")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<Task> updateTask(@RequestBody Task task, @PathVariable (value = "id") Long id)  {
        return this.taskService.updateTaskById(task,id);
    }
	
    @DeleteMapping(value="/{id}", produces = "application/json")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public ResponseEntity<Object> deleteTask(@PathVariable (value= "id") Long id) {
		return this.taskService.deleteById(id);
	}
    
}
