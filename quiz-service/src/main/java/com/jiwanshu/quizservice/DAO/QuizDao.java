package com.jiwanshu.quizservice.DAO;


import com.jiwanshu.quizservice.model.Quiz;
import org.springframework.data.jpa.repository.JpaRepository;

public interface QuizDao extends JpaRepository<Quiz,Integer> {
}
