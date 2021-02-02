package com.auproject.rest.controller;

import com.auproject.rest.dao.Answer;
import com.auproject.rest.service.AnswerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class AnswerController {

    @Autowired
    private AnswerService answerService;

    @PostMapping("/question/answer")
    @CrossOrigin("*")
    public ResponseEntity<Boolean> addAnswer(@RequestBody Answer answer){
        return new ResponseEntity<>(this.answerService.addAnswer(answer), HttpStatus.OK);
    }

    @GetMapping("/question/answer/{questionId}")
    @CrossOrigin("*")
    public List<Answer> getAllAnswer(@PathVariable int questionId) {
        return this.answerService.getAllAnswerByQuestionId(questionId);
    }

}
