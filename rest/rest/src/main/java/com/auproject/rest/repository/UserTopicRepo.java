package com.auproject.rest.repository;

import com.auproject.rest.dao.UserTopic;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import javax.transaction.Transactional;
import java.util.List;

public interface UserTopicRepo extends JpaRepository<UserTopic,Integer> {

    @Query(value = "Select * from usertopic where userid= :userid", nativeQuery = true)
    List<UserTopic> findAllTopicById(@Param("userid")  int userid);

    @Transactional
    @Modifying
    @Query(value = "Delete from usertopic where userid= :userid and topicid= :topicid",nativeQuery = true)
    void deleteTopic(@Param("topicid") int topicid,@Param("userid") int userid);


    @Query(value="Select distinct * from usertopic where userid!= :userid",nativeQuery = true)
    List<UserTopic> unsubscribeTopic(@Param("userid") int userid);

    @Transactional
    @Modifying
    @Query(value= "Insert into usertopic (topicid,userid,topicname) values(:topicid,:userid,:topicname)",nativeQuery = true)
    void insert(@Param("topicid") int topicid,@Param("userid") int userid,@Param("topicname") String topicname);

}
