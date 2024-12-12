package org.jsp.quiz1.daoimpl;

import java.util.List;
import java.util.Optional;

import org.jsp.quiz1.dao.QuestionDao;
import org.jsp.quiz1.entity.Question;
import org.jsp.quiz1.entity.User;
import org.jsp.quiz1.repository.QuestionRespository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Repository;

@Repository

public class QuestionDaoImpl implements QuestionDao
{
	@Autowired
	private QuestionRespository repository;

	@Override
	public Question saveQuestion(Question question) {
		
		return repository.save(question);
	}

	@Override
	public List<Question> findAllQuestions() {
		
		return repository.findAll();
	}

	@Override
	public Optional<Question> findQuestionById(int id) {
		return repository.findById(id);
	}
	@Override
	public List<Question>findAllActiveQuestions(){
		return repository.findAllActiveQuestions();
	}
	@Override
	public List<Question> takeQui(){
		return repository.findRandomQuestions(PageRequest.of(0, 2));
	}

	@Override
	public User saveUser() {
		// TODO Auto-generated method stub
		return null;
	}

		
	

	
}
