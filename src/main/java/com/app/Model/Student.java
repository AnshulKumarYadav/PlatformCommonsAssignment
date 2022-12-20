package com.app.Model;

import java.util.Date;
import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Student {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer studentID;
	
	@NotNull
	private String name;
	
	@NotNull
	@DateTimeFormat(pattern = "dd-MM-yyyy")
	private Date date_of_birth;
	
	@NotNull
	@Pattern(regexp = "[6-9]{1}[0-9]{9}")
	private String mobile;
	private String email;
	private String gender;
	private String studentCode;
	private String fathersName;
	private String mothersName;
	
	@OneToMany(cascade = CascadeType.ALL)
	private List<StudentAddress> addresses;
	
	@ManyToMany(cascade = CascadeType.ALL)
	private List<Course> courses;
	
	

}
