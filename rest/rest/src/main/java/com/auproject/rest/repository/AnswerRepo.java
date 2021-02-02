package com.auproject.rest.repository;

import com.auproject.rest.dao.Answer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface AnswerRepo extends JpaRepository<Answer,Integer> {
    @Query(value = "Select * from answer where questionid=:id", nativeQuery = true)
    List<Answer> getAnswersByQuestion(@Param("id") int id);
}
