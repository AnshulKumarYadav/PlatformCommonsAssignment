package com.app.Model;



import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Admin {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer adminId;
	
	@NotNull
	private String name;
	
	@NotNull
	@Pattern(regexp = "[6-9]{1}[0-9]{9}")
	private String mobile;
	
	@NotNull
	@Pattern(regexp = "[a-zA-Z0-9]{6,12}")
	private String password;

}
