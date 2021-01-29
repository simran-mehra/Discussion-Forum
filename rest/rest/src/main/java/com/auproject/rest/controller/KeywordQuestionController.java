package com.auproject.rest.controller;

import com.auproject.rest.dao.Keyword;
import com.auproject.rest.service.KeywordQuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class KeywordQuestionController {

    @Autowired
    private KeywordQuestionService keywordQuestionService;
    @GetMapping("/question/keywords/get")
    public List<Keyword> getQuestionKeyword(){
        return this.keywordQuestionService.getKeywords();
    }
}
