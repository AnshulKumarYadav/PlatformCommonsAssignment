package com.app.Model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.validation.constraints.NotNull;
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

	public Course(Integer courseId, @NotNull String courseName, @NotNull String description, @NotNull String courseType,
			@NotNull String duration, @NotNull String topic) {
		super();
		this.courseId = courseId;
		this.courseName = courseName;
		this.description = description;
		this.courseType = courseType;
		this.duration = duration;
		this.topic = topic;
	}
	
	

}
