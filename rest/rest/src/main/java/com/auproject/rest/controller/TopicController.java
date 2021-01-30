package com.auproject.rest.controller;

import com.auproject.rest.dao.Topic;
import com.auproject.rest.service.TopicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class TopicController {

    @Autowired
    private TopicService topicService;

    @GetMapping("/topic")
    @CrossOrigin("*")
    public List<Topic> getTopics() {
        return this.topicService.getAllTopics();
    }

    @PostMapping("/topic/create")
    public ResponseEntity<Boolean> createTopic(Topic topic){
        return new ResponseEntity<>(this.topicService.create(topic), HttpStatus.OK);
    }

}
