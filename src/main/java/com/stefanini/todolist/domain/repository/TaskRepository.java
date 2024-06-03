package com.stefanini.todolist.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.stefanini.todolist.domain.entity.Task;

public interface TaskRepository extends JpaRepository<Task, Long> {

}
