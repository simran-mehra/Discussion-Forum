package com.auproject.rest.service;

import com.auproject.rest.dao.Topic;
import com.auproject.rest.repository.TopicRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TopicService {

    @Autowired
    private TopicRepo topicRepo;

    public List<Topic> getAllTopics() {
        return this.topicRepo.findAll();
    }

    public Boolean create(Topic topic){
        try{
            this.topicRepo.save(topic);
            return true;
        }
        catch(Exception e){
            return false;
        }
    }
}
