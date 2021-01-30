package com.auproject.rest.repository;

import com.auproject.rest.dao.Topic;
import org.hibernate.id.IntegralDataTypeHolder;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TopicRepo extends JpaRepository<Topic, Integer> {
}
