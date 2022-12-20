package com.app.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.DTO.AdminLoginDTO;
import com.app.DTO.CourseAssignDTO;
import com.app.Exception.AdminException;
import com.app.Exception.StudentException;
import com.app.Model.Admin;
import com.app.Model.Course;
import com.app.Model.CurrentAdminSession;
import com.app.Model.Student;
import com.app.Respository.AdminDAO;
import com.app.Respository.AdminSessionDAO;
import com.app.Respository.CourseDAO;
import com.app.Respository.StudentDAO;

import net.bytebuddy.utility.RandomString;

@Service
public class AdminServiceImpl implements AdminService {
	
	@Autowired
	private AdminDAO adminDAO;
	
	@Autowired
	private AdminSessionDAO adminSessionDAO;
	
	@Autowired
	private StudentDAO studentDAO;
	
	@Autowired
	private CourseDAO courseDAO;

	@Override
	public Admin registerAdmin(Admin admin) {
		Admin existingAdmin = adminDAO.findByMobile(admin.getMobile());
		if(existingAdmin==null)
		{
			return adminDAO.save(admin);
		}
		throw new AdminException("Admin already exists please try login or create with another credentials");
	}

	@Override
	public CurrentAdminSession logInAdmin(AdminLoginDTO adminLoginDTO) {
		Admin existingAdmin = adminDAO.findByMobile(adminLoginDTO.getMobile());
		if(existingAdmin!=null)
		{
			Optional<CurrentAdminSession> currentAdminSession = adminSessionDAO.findByAdminId(existingAdmin.getAdminId());
			if(currentAdminSession.isPresent()) {
				throw new AdminException("Admin already logged in");
			}
			if(existingAdmin.getPassword().equals(adminLoginDTO.getPassword()))
			{
				String adminCode = RandomString.make(8);
				CurrentAdminSession adminSession = new CurrentAdminSession(existingAdmin.getAdminId(), adminCode, LocalDateTime.now());
				adminSessionDAO.save(adminSession);
				return adminSession;
			}
			throw new AdminException("Incorrect Password Please Try Again!");
		}
		throw new AdminException("Admin does not exists with this creadentials");
	}

	@Override
	public Student admitStudent(Student student,String key) {
		Optional<CurrentAdminSession> currentAdmin = adminSessionDAO.findByAdminCode(key);
		if(currentAdmin.isPresent())
		{			
			Student existingStudent = studentDAO.findByStudentCode(student.getStudentCode());
			if(existingStudent==null)
			{
				return studentDAO.save(student);
			}
			throw new AdminException("Student already exists with this student code");
		}
		throw new AdminException("Admin is not logged in ! ");
		
	}

	@Override
	public Course createCourse(Course course,String key) {
		Optional<CurrentAdminSession> currentAdmin = adminSessionDAO.findByAdminCode(key);
		if(currentAdmin.isPresent())
		{
			Course existingCourse = courseDAO.findByCourseName(course.getCourseName());
			
			if(existingCourse==null)
			{
				return courseDAO.save(course);
			}
			throw new AdminException("Course already exists !");
			
		}
		throw new AdminException("Admin is not logged in ! ");
	}

	@Override
	public String assignCourse(CourseAssignDTO courseAssignDTO , String key) {
		Optional<CurrentAdminSession> currentAdmin = adminSessionDAO.findByAdminCode(key);
		if(currentAdmin.isPresent())
		{
			Student student = studentDAO.findByStudentCode(courseAssignDTO.getStudentCode());
			Course course = courseDAO.findByCourseName(courseAssignDTO.getCourseName());
			
			if(student!=null && course!=null)
			{
				List<Course> courses = new ArrayList<>();
				courses.add(course);
				student.setCourses(courses);
				
				List<Student> students = new ArrayList<>();
				students.add(student);
				course.setStudents(students);
				
				studentDAO.save(student);
				courseDAO.save(course);
				return student.getName()+" ( "+ courseAssignDTO.getStudentCode()+" ) is assigned "+ course.getCourseName() ;
			}
			throw new StudentException("Student Code or Course is invalid ! ");
			
		}
		throw new AdminException("Admin is not logged in ! ");
	}

	@Override
	public List<Student> searchStudentsByName(String name, String key) {
		Optional<CurrentAdminSession> currentAdmin = adminSessionDAO.findByAdminCode(key);
		if(currentAdmin.isPresent())
		{
			List<Student> students = studentDAO.findByName(name);
			if(students.isEmpty())
			{
				throw new StudentException("No student found with this name");
			}
			return students;
			
		}
		throw new AdminException("Admin is not logged in ! ");
	}
	
	
	
	

	

}
