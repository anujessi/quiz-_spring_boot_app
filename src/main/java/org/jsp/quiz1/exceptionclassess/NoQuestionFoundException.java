package org.jsp.quiz1.exceptionclassess;

import lombok.Builder;

@Builder
public class NoQuestionFoundException extends RuntimeException {

	private String message;

	@Override
	public String getMessage() {
		return this.message = message;
	}

	public NoQuestionFoundException(String message) {
		super();
		this.message = message;
	}

	public NoQuestionFoundException() {

	}

}
