package com.app.Service;

import java.util.List;

import com.app.DTO.CourseAssignDTO;
import com.app.DTO.StudentLoginDTO;
import com.app.Model.CurrentStudentSession;
import com.app.Model.Student;

public interface StudentService {
	
	public CurrentStudentSession loginStudent(StudentLoginDTO studentLoginDTO);
	
	public Student updateStudent(Student student);
	
	public List<String> courseDetails(String studentCode);
	
	public Student leaveCourse(CourseAssignDTO courseToBeLeave);

}
