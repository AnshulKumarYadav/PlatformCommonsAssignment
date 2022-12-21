package com.app.Model;

import java.util.Date;
import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
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
