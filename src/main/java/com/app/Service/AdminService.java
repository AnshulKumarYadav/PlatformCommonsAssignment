package com.app.Service;

import com.app.DTO.AdminLoginDTO;
import com.app.DTO.CourseAssignDTO;
import com.app.Model.Admin;
import com.app.Model.Course;
import com.app.Model.CurrentAdminSession;
import com.app.Model.Student;

import java.util.List;

public interface AdminService {
	
	public Admin registerAdmin(Admin admin);
	
	public CurrentAdminSession logInAdmin(AdminLoginDTO adminLoginDTO);
	
	public Student admitStudent(Student student,String key);
	
	public Course createCourse(Course course,String key);
	
	public String assignCourse(CourseAssignDTO courseAssignDTO , String key);
	
	public List<Student> searchStudentsByName(String name,String key);
	

}
