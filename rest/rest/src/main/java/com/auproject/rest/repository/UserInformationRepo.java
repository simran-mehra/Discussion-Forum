package com.auproject.rest.repository;

import com.auproject.rest.dao.UserInformation;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserInformationRepo extends JpaRepository<UserInformation,Integer> {
}
