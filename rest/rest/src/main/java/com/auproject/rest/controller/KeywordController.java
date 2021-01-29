package com.auproject.rest.controller;

import com.auproject.rest.dao.Keyword;
import com.auproject.rest.service.KeywordService;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
public class KeywordController {

    @Autowired
    private KeywordService keywordService;

    @PostMapping("/keyword/set")
    public ResponseEntity<Boolean> setKeyword(@RequestBody Keyword keyword){
        return new ResponseEntity<>(this.keywordService.set(keyword), HttpStatus.OK);
    }

    @GetMapping("/keyword/get")
    public List<Keyword> getKeyword(){
        return this.keywordService.get();
    }


}

