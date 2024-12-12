package org.jsp.quiz1.exceptionhandler;

import org.jsp.quiz1.exceptionclassess.InvalidQuestionIdException;
import org.jsp.quiz1.exceptionclassess.NoQuestionFoundException;
import org.jsp.quiz1.responseStructure.ResponseStructure;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class QuestionExceptionHandler {
	@ExceptionHandler(NoQuestionFoundException.class)
	public ResponseEntity<?> NoQuestionFoundExceptionHandler(NoQuestionFoundException e) {

		return ResponseEntity.status(HttpStatus.NOT_FOUND)
				.body(ResponseStructure.builder().httpStatus(HttpStatus.NOT_FOUND.value()).message("No question found")
						.body("No question  found in the database").build());
	}
	@ExceptionHandler(InvalidQuestionIdException.class)
	public ResponseEntity<?>InvalidQuestionIdExceptionHandler(InvalidQuestionIdException e){
		return ResponseEntity.status(HttpStatus.NOT_FOUND)
				.body(ResponseStructure.builder().httpStatus(HttpStatus.NOT_FOUND.value()).message("Id not found in database")
						.body("Id not found").build());
	}
}
