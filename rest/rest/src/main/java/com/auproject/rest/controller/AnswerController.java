package com.auproject.rest.controller;

import com.auproject.rest.dao.Answer;
import com.auproject.rest.service.AnswerService;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class AnswerController {

    @Autowired
    private AnswerService answerService;

    @PostMapping("/question/answer")
    @CrossOrigin("*")
    public Optional<Answer> addAnswer(@RequestBody Answer answer){

        return this.answerService.addAnswer(answer);
    }

    @GetMapping("/question/answer/{questionId}")
    @CrossOrigin("*")
    public List<Answer> getAllAnswer(@PathVariable int questionId) {
        return this.answerService.getAllAnswerByQuestionId(questionId);
    }

    @PostMapping("/question/answer/update")
    @CrossOrigin("*")
    public Boolean updateAnswer(@RequestBody Answer answer){

        return this.answerService.updateAnswer(answer);
    }

    @DeleteMapping("/question/answer/delete")
    @CrossOrigin("*")
    public Boolean deleteAnswer(@RequestBody Answer answer){

        return this.answerService.deleteAnswer(answer);
    }

}
