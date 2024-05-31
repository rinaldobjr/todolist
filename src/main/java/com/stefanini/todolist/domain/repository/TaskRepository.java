package com.stefanini.todolist.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.stefanini.todolist.domain.entity.Task;

@Repository
public interface TaskRepository extends JpaRepository<Task, Long> {

}
