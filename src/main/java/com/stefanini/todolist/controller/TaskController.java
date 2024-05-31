package com.stefanini.todolist.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.stefanini.todolist.domain.entity.Task;
import com.stefanini.todolist.service.TaskService;

@RestController
@RequestMapping(path="/api/v1/tasks")
public class TaskController {

	@Autowired
	private TaskService taskService;
	
	@PostMapping(value="/create", produces = "application/json")
	public ResponseEntity<Task> saved(@RequestBody Task task) {
		return new ResponseEntity<Task>(this.taskService.createTask(task), HttpStatus.CREATED);
	}
	
}
