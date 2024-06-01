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
	
	@Column(nullable = false )
	private String title;
	
	@Column(nullable = false)
	private String description;
	
	@Column(nullable = false)
	private String status;
	
	@Column(nullable = false)
	private Date deadline;
	
	@CreationTimestamp
	@Column(nullable = false, updatable = false)
	private Date created;
	
	@UpdateTimestamp
	private Date updated;
	
}
