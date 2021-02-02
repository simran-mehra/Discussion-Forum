package com.auproject.rest.service;

import com.auproject.rest.dao.Answer;
import com.auproject.rest.repository.AnswerRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AnswerService {
    @Autowired
    private AnswerRepo answerRepo;

    public Boolean addAnswer(Answer answer) {
        try {
            this.answerRepo.save(answer);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public List<Answer> getAllAnswerByQuestionId(int questionId) {
        return this.answerRepo.getAnswersByQuestion(questionId);
    }
}
