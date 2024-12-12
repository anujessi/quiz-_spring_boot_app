package org.jsp.quiz1.service;

import java.util.List;

import org.jsp.quiz1.dto.QuizResponse;
import org.jsp.quiz1.entity.Question;
import org.springframework.http.ResponseEntity;

public interface QuestionService {

	ResponseEntity<?> saveQuestion(Question question);

	ResponseEntity<?> findAllQuestions();



	ResponseEntity<?> submitQuiz(List<QuizResponse> quizresponses);

	ResponseEntity<?> findQuestionById(int id);

	<TakeQuiz> ResponseEntity<?> takeQuiz();



	
	}
	


