package org.jsp.quiz1.daoimpl;

import java.util.List;
import java.util.Optional;

import org.jsp.quiz1.dao.UserDao;
import org.jsp.quiz1.entity.Question;
import org.jsp.quiz1.entity.User;
import org.jsp.quiz1.repository.QuestionRespository;
import org.jsp.quiz1.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;

public class UserDaoImpl implements UserDao {
	@Autowired
	private UserRepository  repository;
	
	@Override
	public User saveUser(User user) {
		return repository.save(user);
	}

	@Override
	public List<User> findAllUsers() {
		return repository.findAll();
	}
	
	
	@Override
	public Optional<User> findUserById(int id) {
		// TODO Auto-generated method stub
		return Optional.empty();
	}

	@Override
	public Optional<User> findAllUserById(int id) {
		// TODO Auto-generated method stub
		return Optional.empty();
	}



}
