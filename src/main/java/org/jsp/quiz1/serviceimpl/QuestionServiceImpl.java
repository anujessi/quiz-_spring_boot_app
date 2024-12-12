package org.jsp.quiz1.serviceimpl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.jsp.quiz1.dao.QuestionDao;
import org.jsp.quiz1.dto.QuestionDto;
import org.jsp.quiz1.dto.QuizResponse;
import org.jsp.quiz1.dto.TakeQuiz;
import org.jsp.quiz1.entity.Question;
import org.jsp.quiz1.exceptionclassess.InvalidQuestionIdException;
import org.jsp.quiz1.exceptionclassess.NoQuestionFoundException;
import org.jsp.quiz1.responseStructure.ResponseStructure;
import org.jsp.quiz1.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

@Service
public class QuestionServiceImpl implements QuestionService {
	@Autowired
	private QuestionDao dao;

	@Override
	public ResponseEntity<?> saveQuestion(Question question) {
		question = dao.saveQuestion(question);
//		ResponseStructure<Question> structure = new ResponseStructure<>();
//		structure.setHttpStatus(HttpStatus.OK.value());
//		structure.setMessage("Saved succesfull");
//		structure.setBody(question);
//		return new ResponseEntity<>(structure, HttpStatus.OK);
		return ResponseEntity.status(HttpStatus.OK.value()).body(ResponseStructure.builder()
				.httpStatus(HttpStatus.OK.value()).message("Question Added Successfully").body(question).build());
	}
	// take Quiz
	// submit-quiz

//	@Override
//	public ResponseEntity<?> findAllQuestions() {
//		List<Question> questions = dao.findAllQuestions();
//		ResponseStructure<List<Question>> structure = new ResponseStructure<>();
//		structure.setHttpStatus(HttpStatus.OK.value());
//		structure.setMessage("All questions found");
//		structure.setBody(questions);
//		return new ResponseEntity<>(structure, HttpStatus.OK);
//
//	}
	@Override
	public ResponseEntity<?> findAllQuestions() {
		List<Question> questions = dao.findAllActiveQuestions();
		List<QuestionDto> dtolist = new ArrayList<>();
		for (Question q : questions) {

			dtolist.add(new QuestionDto(q.getTittle(), q.getA(), q.getB(), q.getC(), q.getD()));

		}

		if (dtolist.isEmpty()) {
			// throw new NoQuestionFoundException("No data in data base");
			throw NoQuestionFoundException.builder().message("NO data found in data base").build();

		}
//		ResponseStructure structure =ResponseStructure.builder().httpStatus(HttpStatus.OK.value()).message("Data found").body(questions).build();
//		return ResponseEntity.status(HttpStatus.OK ).body(structure);

		return ResponseEntity.status(HttpStatus.OK).body(ResponseStructure.builder().httpStatus(HttpStatus.OK.value())
				.message("All Questions Found").body(dtolist).build());

	}

	@Override
	public ResponseEntity<?> findQuestionById(int id) {
		Optional<Question> optional = dao.findQuestionById(id);
		if (optional.isEmpty()) {
			throw InvalidQuestionIdException.builder().message("Invalid Id").build();
		}
		return ResponseEntity.status(HttpStatus.OK).body(ResponseStructure.builder().httpStatus(HttpStatus.OK.value())
				.message("id found successfully").body(optional.get()).build());

	}

//	@Override
//	public ResponseEntity<?> submitQuiz(List<QuizResponse> quizresponses) {
//		int c = 0;
//
//		for (QuizResponse qr : quizresponses) {
//			Optional<Question> q = dao.findQuestionById(qr.getId());
//			if (q.isEmpty()) {
//
//				throw InvalidQuestionIdException.builder().message("Invalid question id unable to calculate the result").build();
//			}
//				Question question = q.get();
//				if (question.getAns().equalsIgnoreCase(qr.getAns())) {
//					c++;
//				}
//
//			}
//			return ResponseEntity.status(HttpStatus.OK).body(ResponseStructure.builder()
//					.httpStatus(HttpStatus.OK.value()).message("id found").body("Your score"+c).build());
//
//		}
		
	
	@Override
	public ResponseEntity<?> submitQuiz(List<QuizResponse> quizresponses) {
		int c = 0;
		for (QuizResponse qr : quizresponses) {
			Optional<Question> q = dao.findQuestionById(qr.getId());
			if (q.isEmpty()) {
				throw InvalidQuestionIdException.builder().message("Invalid Question Id unable to calulate the result")
						.build();
			}
			Question question = q.get();
			if (question.getAns().equalsIgnoreCase(qr.getAns())) {
				c++;
			}
		}
		return ResponseEntity.status(HttpStatus.OK)
										.body(ResponseStructure.builder()
										.httpStatus(HttpStatus.OK.value())
										.message("Submission succesfull")
										.body("Your score:"+c).build());

	}

	@Override
	public  ResponseEntity<?> takeQuiz() {
		List<Question> questions = dao.findAllActiveQuestions();
		List<TakeQuiz> dtolist = new ArrayList<>();
		for (Question q : questions) {


			dtolist.add(new TakeQuiz(q.getId(),q.getTittle(), q.getA(), q.getB(), q.getC(), q.getD()));

		}

		if (dtolist.isEmpty()) {
			
			throw NoQuestionFoundException.builder().message("No questions found in database").build();
		}

		return ResponseEntity.status(HttpStatus.OK).body(ResponseStructure.builder().httpStatus(HttpStatus.OK.value())
				.message("All questions found").body(dtolist).build());
	}
		
	}
	

