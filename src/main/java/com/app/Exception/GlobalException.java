package com.app.Exception;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

@ControllerAdvice
public class GlobalException {
	
	@ExceptionHandler(AdminException.class)
	public ResponseEntity<ErrorDetails> adminExceptionHandler(AdminException adminException,WebRequest wr)
	{
		ErrorDetails errorDetails = new ErrorDetails(LocalDateTime.now(), adminException.getMessage(), wr.getDescription(false));
		return new ResponseEntity<ErrorDetails>(errorDetails,HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(StudentException.class)
	public ResponseEntity<ErrorDetails> studentExceptionHandler(StudentException studentException,WebRequest wr)
	{
		ErrorDetails errorDetails = new ErrorDetails(LocalDateTime.now(), studentException.getMessage(), wr.getDescription(false));
		return new ResponseEntity<ErrorDetails>(errorDetails,HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(Exception.class)
	public ResponseEntity<ErrorDetails> adminExceptionHandler(Exception ae, WebRequest wr)
	{
		
		ErrorDetails me = new ErrorDetails(LocalDateTime.now(), ae.getMessage(), wr.getDescription(false));
		return new ResponseEntity<ErrorDetails>(me,HttpStatus.BAD_REQUEST);
		
	}
	
}
