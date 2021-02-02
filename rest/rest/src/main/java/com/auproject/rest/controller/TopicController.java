package com.auproject.rest.controller;

import com.auproject.rest.dao.Topic;
import com.auproject.rest.service.TopicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

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
    @CrossOrigin("*")
    public Optional<Topic> createTopic(@RequestBody Topic topic){
        return this.topicService.create(topic);
    }

    @GetMapping("/topic/subscribe/get/{userid}")
    @CrossOrigin("*")
    public List<Topic> subscribe(@PathVariable int userid){
       return this.topicService.subscribe(userid);
    }

    @GetMapping("/topic/unsubscribe/get/{userid}")
    @CrossOrigin("*")
    public List<Topic> unSubscribe(@PathVariable int userid){
        return this.topicService.unSubscribe(userid);
    }

}
