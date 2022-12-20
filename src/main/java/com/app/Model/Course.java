package com.app.Model;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Course {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer courseId;
	
	@NotNull
	private String courseName;
	
	@NotNull
	private String description;
	
	@NotNull
	private String courseType;
	
	@NotNull
	private String duration;
	
	@NotNull
	private String topic;
	
	@ManyToMany(cascade = CascadeType.ALL)
	private List<Student> students;

}
