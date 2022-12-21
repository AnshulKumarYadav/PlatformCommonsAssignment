package com.app.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.app.DTO.AdminLoginDTO;
import com.app.DTO.CourseAssignDTO;
import com.app.Model.Admin;
import com.app.Model.Course;
import com.app.Model.CurrentAdminSession;
import com.app.Model.Student;
import com.app.Service.AdminServiceImpl;


@CrossOrigin
@RestController
public class AdminController {
	
	@Autowired
	private AdminServiceImpl adminServiceImpl;
	
	@PostMapping("/admin")
	public Admin registerAdmin(@RequestBody Admin admin)
	{
		return adminServiceImpl.registerAdmin(admin);
	}
	
	@PostMapping("/adminLogin")
	public CurrentAdminSession loginAdmin(@RequestBody AdminLoginDTO adminLoginDTO)
	{
		return adminServiceImpl.logInAdmin(adminLoginDTO);
	}
	
	@PostMapping("/admitStudent/{key}")
	public Student admitStudent(@RequestBody Student student,@PathVariable String key) {
		return adminServiceImpl.admitStudent(student, key);
	}
	
	@PostMapping("/course/{key}")
	public Course createCourse(@RequestBody Course course,@PathVariable String key)
	{
		return adminServiceImpl.createCourse(course, key);
	}
	
	@PostMapping("/assignCourse/{key}")
	public String assignCourse(@RequestBody CourseAssignDTO courseAssignDTO,@PathVariable String key)
	{
		return adminServiceImpl.assignCourse(courseAssignDTO, key);
	}
	
	@GetMapping("/students/{name}")
	public List<Student> searchStudents(@PathVariable String name,@RequestParam("key") String key)
	{
		return adminServiceImpl.searchStudentsByName(name,key);
	}
	
}
