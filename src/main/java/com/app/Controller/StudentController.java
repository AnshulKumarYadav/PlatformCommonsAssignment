package com.app.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.app.DTO.CourseAssignDTO;
import com.app.DTO.StudentLoginDTO;
import com.app.Model.CurrentStudentSession;
import com.app.Model.Student;
import com.app.Service.StudentServiceImpl;

@CrossOrigin
@RestController
public class StudentController {
	
	@Autowired
	private StudentServiceImpl studentServiceImpl;
	
	@PostMapping("/loginStudent")
    public CurrentStudentSession loginStudent(@RequestBody StudentLoginDTO studentLoginDTO)
    {
    	return studentServiceImpl.loginStudent(studentLoginDTO);
    }
	
	@PutMapping("/student")
	public Student updateStudent(Student student)
	{
		return studentServiceImpl.updateStudent(student);
	}
	
	@GetMapping("/student")
	public List<String> courseDetails(String studentCode)
	{
		return studentServiceImpl.courseDetails(studentCode);
	}
	
	@PutMapping("/leaveCourse")
	public Student leaveCourse(CourseAssignDTO courseToBeLeave)
	{
		return studentServiceImpl.leaveCourse(courseToBeLeave);
	}
	
}
