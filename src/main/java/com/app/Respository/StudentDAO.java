package com.app.Respository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.app.Model.Student;

@Repository
public interface StudentDAO extends JpaRepository<Student, Integer> {
	
	public Student findByStudentCode(String studentCode);
	
}
