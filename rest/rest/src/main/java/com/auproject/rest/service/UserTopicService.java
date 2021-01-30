package com.auproject.rest.service;

import com.auproject.rest.dao.UserTopic;
import com.auproject.rest.repository.UserTopicRepo;
import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.*;

@Service
public class UserTopicService {

    @Autowired
    private UserTopicRepo userTopicRepo;


    @Transactional
    public void set(List<UserTopic> userTopic){

      for(UserTopic i:userTopic){
            this.userTopicRepo.insert(i.getTopicid(),i.getUserid(),i.getTopicname());
        }

    }

    public Boolean delete(UserTopic userTopic){
        try{
            this.userTopicRepo.deleteTopic(userTopic.getTopicid(), userTopic.getUserid());
            return true;
        }
        catch(Exception e){
            System.out.println(e);
            return false;
        }
    }

    public List<UserTopic> getById(int id) {
        return this.userTopicRepo.findAllTopicById(id);
    }

    public List<UserTopic> unsubscribeId(int id) {
        return this.userTopicRepo.unsubscribeTopic(id);
    }
}
