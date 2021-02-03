package com.auproject.rest.repository;

import com.auproject.rest.dao.Keyword;
import org.hibernate.id.IntegralDataTypeHolder;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Set;

public interface KeywordRepo extends JpaRepository<Keyword, Integer> {


}
