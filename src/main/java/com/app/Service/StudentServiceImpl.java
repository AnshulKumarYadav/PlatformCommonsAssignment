package com.app.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.DTO.CourseAssignDTO;
import com.app.DTO.StudentLoginDTO;
import com.app.Exception.StudentException;
import com.app.Model.Course;
import com.app.Model.CurrentStudentSession;
import com.app.Model.Student;
import com.app.Respository.CourseDAO;
import com.app.Respository.StudentDAO;
import com.app.Respository.StudentSessionDAO;

@Service
public class StudentServiceImpl implements StudentService {	
	
	@Autowired
	private StudentDAO studentDAO;
	
	@Autowired
	private StudentSessionDAO studentSessionDAO;
	
	@Autowired
	private CourseDAO courseDAO;

	@Override
	public CurrentStudentSession loginStudent(StudentLoginDTO studentLoginDTO) {
		Student student = studentDAO.findByStudentCode(studentLoginDTO.getStudentCode());
		if (student!=null) {
			
			CurrentStudentSession studentSession = studentSessionDAO.findByStudentCode(studentLoginDTO.getStudentCode());
			if(studentSession!=null)
			{
				throw new StudentException("Student already logged in");
			}
			
			if(student.getDate_of_birth().equals(studentLoginDTO.getDob()))
			{
				CurrentStudentSession currentStudentSession = new CurrentStudentSession(student.getStudentID(), student.getStudentCode(), LocalDateTime.now());
				
				return studentSessionDAO.save(currentStudentSession);
				
				
			}
			throw new StudentException("Student date of birth is incorrect");
			
		}
		throw new StudentException("Student does not exist with this credentials");
	}

	@Override
	public Student updateStudent(Student student) {
		CurrentStudentSession currentStudentSession = studentSessionDAO.findByStudentCode(student.getStudentCode());
		if(currentStudentSession!=null)
		{
			Student existingStudent = studentDAO.findByStudentCode(student.getStudentCode());
			if(existingStudent!=null)
			{
				existingStudent.setName(student.getName());
				existingStudent.setDate_of_birth(student.getDate_of_birth());
				existingStudent.setFathersName(student.getFathersName());
				existingStudent.setMothersName(student.getMothersName());
				existingStudent.setAddresses(student.getAddresses());
				existingStudent.setMobile(student.getMobile());
				existingStudent.setEmail(student.getEmail());
				
				return studentDAO.save(existingStudent);
			}
			throw new StudentException("Student does not exist");
		}
		throw new StudentException("Student not logged in !");
		
	}

	@Override
	public List<String> courseDetails(String studentCode) {
		Student student = studentDAO.findByStudentCode(studentCode);
		if(student!=null)
		{
			List<String> s = new ArrayList<>();
			for(Course c: student.getCourses())
			{
				String string ="Course is: "+ c.getCourseName()+" Topic : "+c.getTopic();
				s.add(string);
			}
			return s;
		}
		throw new StudentException("Student does not exists!");
	}
	

	@Override
	public Student leaveCourse(CourseAssignDTO courseToBeLeave) {
		CurrentStudentSession currentStudentSession = studentSessionDAO.findByStudentCode(courseToBeLeave.getStudentCode());
		if(currentStudentSession!=null)
		{
			Student student = studentDAO.findByStudentCode(courseToBeLeave.getStudentCode());
			Course course = courseDAO.findByCourseName(courseToBeLeave.getCourseName());
			List<Course> courses = student.getCourses();
			for(Course c: courses)
			{
				if(c.getCourseName().equals(course.getCourseName()))
				{
					courses.remove(c);
				}
			}
			student.setCourses(courses);
			return student;
			
		}
		throw new StudentException("Student is not logged in");
	}

}
