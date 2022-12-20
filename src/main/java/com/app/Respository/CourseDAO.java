package com.app.Respository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.app.Model.Course;

@Repository
public interface CourseDAO extends JpaRepository<Course, Integer> {
	
	public Course findByCourseName(String courseName);
	
}
