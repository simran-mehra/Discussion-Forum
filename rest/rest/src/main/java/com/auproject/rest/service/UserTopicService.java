package com.auproject.rest.service;

import com.auproject.rest.dao.Topic;
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



    public Boolean set(List<Topic> userTopic, int userid){

        try {
            this.userTopicRepo.deleteByUserId(userid);
            for (Topic topic : userTopic) {
                this.userTopicRepo.insert(topic.getId(), userid, topic.getTopicname());
            }
            return true;
        }
        catch(Exception e){
            return false;
        }
    }

    public Boolean delete(List<UserTopic> userTopic){
        try {
            for (UserTopic i : userTopic) {

                this.userTopicRepo.deleteTopic(i.getTopicid(), i.getUserid());

            }
            return true;
        }
        catch(Exception e){
            return false;
        }
    }




}
