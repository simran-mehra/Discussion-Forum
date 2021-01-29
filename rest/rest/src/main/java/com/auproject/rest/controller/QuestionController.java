package com.auproject.rest.controller;

import com.auproject.rest.dao.Question;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class QuestionController {

    @PostMapping("/question/set")
    public Boolean setQuestion(Question question){
        return true;
    }
}
