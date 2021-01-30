package com.auproject.rest.controller;


import com.auproject.rest.dao.UserTopic;
import com.auproject.rest.service.UserTopicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserTopicController {

    @Autowired
    private UserTopicService userTopicService;

    @GetMapping("/topic/get/{id}")
    public List<UserTopic> getById(@PathVariable int id){
        return this.userTopicService.getById(id);
    }

    @PostMapping("/topic/subscribe")
    public void setTopic(@RequestBody List<UserTopic> userTopic){
        this.userTopicService.set(userTopic);
    }

    @DeleteMapping("/topic/unsubscribe")
    public ResponseEntity<Boolean> deleteTopic(@RequestBody UserTopic userTopic ){
        return new ResponseEntity<>(this.userTopicService.delete(userTopic), HttpStatus.OK);
    }

    @GetMapping("/topic/unsubscribe/get/{id}")
    public List<UserTopic> unsubscribeId(@PathVariable int id){
        return this.userTopicService.unsubscribeId(id);
    }

}

