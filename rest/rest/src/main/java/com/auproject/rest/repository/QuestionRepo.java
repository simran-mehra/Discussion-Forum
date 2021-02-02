package com.auproject.rest.repository;

import com.auproject.rest.dao.Question;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface QuestionRepo extends JpaRepository<Question, Integer> {

    @Query(value = "select * from question where topicid = :id", nativeQuery = true)
    List<Question> getQuestionByTopic(@Param("id") int id);

    @Query(value = "select * from question where topicid in (select topicid from usertopic where userid =:userId);", nativeQuery = true)
    List<Question> getAllQuestion(@Param("userId") int userId);


    @Query(value = "select * from question where id = :quesId", nativeQuery = true)
    Question getQuestionById(@Param("quesId") int quesId);


}
