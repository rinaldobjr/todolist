package com.stefanini.todolist.domain.entity;

import java.util.Date;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import jakarta.persistence.Basic;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@Entity
@ToString
@Table(name="tasks")
public class Task {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	@Basic(optional = false)
	private Long id;
	
	@Column(name = "title_task", nullable = false)
	private String titleTask;
	
	@Column(name = "description_task", nullable = false)
	private String descriptionTask;
	
	
	@Column(name = "status_task")
	private String statusTask;
	
	@Column(name = "deadline_task")
	private Date deadLineTask;
	
	@CreationTimestamp
	@Column(name = "created_task", nullable = false, updatable = false)
	private Date createdTask;
	
	@UpdateTimestamp
	@Column(name = "update_task")
	private Date updateTask;
	
}
