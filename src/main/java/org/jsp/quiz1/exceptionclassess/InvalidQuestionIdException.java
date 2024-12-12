package org.jsp.quiz1.exceptionclassess;

import lombok.Builder;

@Builder
public class InvalidQuestionIdException extends RuntimeException {
	private String message;

	

	public InvalidQuestionIdException(String message) {
		super();
		this.message = message;
	}

	public InvalidQuestionIdException() {

	}

	@Override
	public String getMessage() {
		return this.message;
	}
	
	
}
