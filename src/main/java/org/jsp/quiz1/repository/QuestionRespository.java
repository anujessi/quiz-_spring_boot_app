package org.jsp.quiz1.repository;

import java.util.List;

import org.jsp.quiz1.entity.Question;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Component;

@Component
public interface QuestionRespository extends JpaRepository<Question, Integer> {
	@Query("select q from Question q where q.status='ACTIVE'")
	List<Question> findAllActiveQuestions();

	@Query("SELECT q FROM Question q ORDER BY FUNCTION('RAND')ASC")
	List<Question> findRandomQuestions(PageRequest pageRequest);

}