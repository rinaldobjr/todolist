package com.stefanini.todolist.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.stefanini.todolist.domain.entity.Task;
import com.stefanini.todolist.domain.repository.TaskRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class TaskService {
	
	@Autowired
	private TaskRepository taskRepository;
	
	
	public Task createTask(Task task) {
		return taskRepository.save(task);
	}

}
