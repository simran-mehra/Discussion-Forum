package com.auproject.rest;

import com.auproject.rest.dao.UserInformation;
import com.auproject.rest.dao.UserTopic;
import com.auproject.rest.repository.UserTopicRepo;
import org.apache.catalina.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class UserTopicRepoTest {

    @Autowired
    private TestEntityManager testEntityManager;

    @Autowired
    private UserTopicRepo userTopicRepo;

    @Test
    public void getUserIdByTopicIdTest(){
            UserTopic userTopic=new UserTopic(1,1,2,"testing");
            UserTopic userTopic1= testEntityManager.persist(userTopic);
            List<Integer> result=this.userTopicRepo.getUserIdByTopicId(userTopic1.getId());
            List<Integer> resultCheck=new ArrayList<>();
            resultCheck.add(2);

            assertThat(result).isEqualTo(resultCheck);
    }
}
