package org.jsp.quiz1.dao;

import java.util.List;
import java.util.Optional;

import org.jsp.quiz1.entity.User;

public interface UserDao {

	User saveUser(User user);
	List<User>findAllUsers();
	Optional<User>findAllUserById(int id);
	Optional<User> findUserById(int id);

}
