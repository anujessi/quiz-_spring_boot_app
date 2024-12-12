package org.jsp.quiz1.repository;

import org.jsp.quiz1.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Integer> {

}
