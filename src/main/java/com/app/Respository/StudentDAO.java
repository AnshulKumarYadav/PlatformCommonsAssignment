package com.app.Respository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.app.Model.Student;

@Repository
public interface StudentDAO extends JpaRepository<Student, Integer> {
	
	public Student findByStudentCode(String studentCode);
	
	public List<Student> findByName(String name);
	
//	public Student findByName(String name);
	
}
