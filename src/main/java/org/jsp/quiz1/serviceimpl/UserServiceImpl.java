package org.jsp.quiz1.serviceimpl;

import org.jsp.quiz1.dao.QuestionDao;
import org.jsp.quiz1.dao.UserDao;
import org.jsp.quiz1.entity.User;
import org.jsp.quiz1.responseStructure.ResponseStructure;
import org.jsp.quiz1.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
	@Autowired
	private UserDao dao;
	
	@Override
	public ResponseEntity<?>saveUser(User user){
		user=dao.saveUser(user);
		return ResponseEntity.status(HttpStatus.OK.value()).body(ResponseStructure.builder()
				.httpStatus(HttpStatus.OK.value()).message("User added successfully").body(user).build()
				);
		
	}

	@Override
	public ResponseEntity<?> findAllUsers() {
		
		return null;
	}
	
}
