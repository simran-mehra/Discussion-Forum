package com.auproject.rest.controller;

import com.auproject.rest.QuestionGetList;
import com.auproject.rest.QuestionList;
import com.auproject.rest.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class QuestionController {

    @Autowired
    private QuestionService questionService;

    @GetMapping("/question/topic/{topicId}")
    @CrossOrigin("*")
    public List<QuestionGetList> getQuestion(@PathVariable int topicId){
        return this.questionService.getQuestion(topicId);
    }

    @GetMapping("/question/all/{userId}")
    @CrossOrigin("*")
    public List<QuestionGetList> getAllQuestion(@PathVariable int userId){
        return this.questionService.getAllQuestion(userId);
    }


    @PostMapping("/question")
    @CrossOrigin("*")
    public ResponseEntity<Boolean> insertQuestion(@RequestBody  QuestionList questionList){
        return new ResponseEntity<>(this.questionService.createQuestion(questionList), HttpStatus.OK);
    }

    @GetMapping("/question/user/{userId}/{topicId}")
    @CrossOrigin("*")
    public List<QuestionGetList> getQuestion(@PathVariable int userId, @PathVariable int topicId){
        return this.questionService.getQuestionByUserIdTopicId(userId,topicId);
    }

    @GetMapping("/question/user/{userId}")
    @CrossOrigin("*")
    public List<QuestionGetList> getQuestionByUser(@PathVariable int userId){
        return this.questionService.getAllQuestionByUserId(userId);
    }

    @GetMapping("/question/{quesId}")
    @CrossOrigin("*")
    public Boolean setQuestionAnswered(@PathVariable int quesId){
        return this.questionService.setQuestionAnswered(quesId);
    }

}
