package com.auproject.rest.controller;

import com.auproject.rest.dao.Keyword;
import com.auproject.rest.dao.KeywordQuestion;
import com.auproject.rest.service.KeywordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class KeywordController {

    @Autowired
    private KeywordService keywordService;

    @GetMapping("/keyword")
    @CrossOrigin("*")
    public List<Keyword> getAllKeywords() {
        return this.keywordService.getAllKeywords();
    }

    @PostMapping("/keyword/add")
    @CrossOrigin("*")
    public Optional<Keyword> createKeyword(@RequestBody Keyword keyword) {

        return this.keywordService.create(keyword);
    }

    @GetMapping("/trytry")
    public List<KeywordQuestion> get(){
        return this.keywordService.getKeywords();
    }
}
