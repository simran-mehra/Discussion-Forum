package com.auproject.rest.repository;

import com.auproject.rest.dao.Notification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import javax.transaction.Transactional;

public interface NotificationRepo extends JpaRepository<Notification, Integer> {

    @Transactional
    @Modifying
    @Query(value = "Insert into notification (description,userid,timestamp,visited) values(:description,:userId," +
            ":timestamp,:visited)",nativeQuery = true)
    void insert(@Param("description") String description,
                @Param("userId") int userId,@Param("timestamp") String timestamp,
                @Param("visited") Boolean visited);

}
