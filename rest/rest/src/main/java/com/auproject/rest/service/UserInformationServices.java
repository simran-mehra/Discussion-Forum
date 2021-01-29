package com.auproject.rest.service;

import com.auproject.rest.dao.UserInformation;
import com.auproject.rest.repository.UserInformationRepo;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class UserInformationServices {
    @Autowired
    private UserInformationRepo userinformationrepo;

    public String login(UserInformation user) {
        Optional<UserInformation> id=userinformationrepo.findById(user.getId());
        if(id.isEmpty()==true){
            return "User doesn't exist";
        }
        else{
            String encryptedPassword = Base64.getEncoder().encodeToString(user.getPassword().getBytes());
            if(StringUtils.isNotEmpty(user.getPassword()) && encryptedPassword.equals(id.get().getPassword()) )
            {
                return "User matched";
            }
            else
            {
                return "Incorrect password";
            }
        }

    }

    public String register(UserInformation user) {
        Optional<UserInformation> id=userinformationrepo.findById(user.getId());
        if(id.isEmpty()==true) {

            try {
                String password = user.getPassword();
                String encryptedPassword = Base64.getEncoder().encodeToString(password.getBytes());
                //System.out.println(encryptedPassword);
                user.setPassword(encryptedPassword);
                userinformationrepo.save(user);
                return "User inserted into table";
            } catch (Exception e) {
                System.out.println(e);
                return "Error";
            }
        }
        else{
            return "User already exist";
        }
    }




}
