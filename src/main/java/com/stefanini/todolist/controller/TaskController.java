package com.stefanini.todolist.controller;

import java.util.List;

import org.slf4j.Logger;
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

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping(path="/api/v1/tasks")
@Slf4j
@AllArgsConstructor
public class TaskController {

	private TaskService taskService;
	private Logger log;
	
	//Create
	@PostMapping(value="/create", produces = "application/json")
	public ResponseEntity<Task> savedTask(@RequestBody Task task) {
		log.info("Criação de nova tarefa e descrição [{}]", task);
		return new ResponseEntity<Task>(this.taskService.createTask(task), HttpStatus.CREATED);
	}
	
	@GetMapping(value="/list", produces = "application/json")
	public ResponseEntity<List<Task>> listTaskAll() {
		log.info("Listando as tarefas cadastradas");
		return new ResponseEntity<List<Task>>(this.taskService.listAllTasks(), HttpStatus.OK);
	}
	
	@GetMapping(value="/{id}", produces = "application/json")
	@ResponseStatus(HttpStatus.OK)
	public ResponseEntity<Task> getTaskById(@PathVariable (value= "id") Long id) {
		log.info("Busca de uma tarefa por Id [{}]", id);
		return this.taskService.findTaskById(id);
	}
	
    @PutMapping(value = "/{id}", produces = "application/json")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<Task> updateTask(@RequestBody Task task, @PathVariable (value = "id") Long id)  {
    	log.info("Atualização de uma tarefa por Id [{}] e as informações : [{}]", id, task);
        return this.taskService.updateTaskById(task,id);
    }
	
    @DeleteMapping(value="/{id}", produces = "application/json")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public ResponseEntity<Object> deleteTask(@PathVariable (value= "id") Long id) {
    	log.info("Exclusão de uma tarefa por Id [{}]", id);
		return this.taskService.deleteById(id);
	}
    
}
