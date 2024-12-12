package org.jsp.quiz1.dao;

import java.util.List;
import java.util.Optional;

import org.jsp.quiz1.entity.Question;
import org.jsp.quiz1.entity.User;



public interface QuestionDao {

	Question saveQuestion(Question question);

	List<Question> findAllQuestions();

	Optional<Question> findQuestionById(int id);

	List<Question> findAllActiveQuestions();

	List<Question> takeQui();

	User saveUser();



	
	
}


