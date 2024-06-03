package com.stefanini.todolist.service;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.stefanini.todolist.domain.entity.Task;
import com.stefanini.todolist.domain.repository.TaskRepository;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class TaskService {

	private TaskRepository taskRepository;
	
	//Create 
		public Task createTask(Task task) {
			return taskRepository.save(task);
		}

		//Read by all
		public List<Task> listAllTasks() {
			return taskRepository.findAll();
		}
		
		//Read by id
		public ResponseEntity<Task> findTaskById(Long id) {
			return taskRepository.findById(id)
					.map(task -> ResponseEntity.ok().body(task))
					.orElse(ResponseEntity.notFound().build());
		}
		
		//Update
		public ResponseEntity<Task> updateTaskById(Task task, Long id) {
			return taskRepository.findById(id)
					.map(taskUpdate -> {
						taskUpdate.setTitle(task.getTitle());
						taskUpdate.setDescription(task.getDescription());
						taskUpdate.setStatus(task.getStatus());
						taskUpdate.setDeadline(task.getDeadline());
						Task updated = taskRepository.save(taskUpdate);
						return ResponseEntity.ok().body(updated);
					}).orElse(ResponseEntity.notFound().build());
		}
		
		//Delete
		public ResponseEntity<Object> deleteById(Long id) {
			return taskRepository.findById(id)
					.map(taskDelete -> {
						taskRepository.deleteById(id);
						return ResponseEntity.noContent().build();
					}).orElse(ResponseEntity.notFound().build());
		}
		
}
