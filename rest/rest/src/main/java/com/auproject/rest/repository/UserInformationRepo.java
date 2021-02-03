package com.auproject.rest.repository;

import com.auproject.rest.dao.UserInformation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
import java.util.Set;

public interface UserInformationRepo extends JpaRepository<UserInformation,Integer> {

    @Query(value = "Select email from userinformation where id in :userId",nativeQuery = true)
    List<String> getEmailByUserId(@Param("userId") List<Integer> userId);
}
