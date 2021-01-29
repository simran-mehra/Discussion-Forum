package com.auproject.rest.controller;

import com.auproject.rest.dao.UserInformation;
import com.auproject.rest.service.UserInformationServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

// Class capital
//method camel case

@RestController
public class LoginController {

        @Autowired
        private UserInformationServices services;

    @PostMapping("/login")
    @CrossOrigin("*")
    public ResponseEntity<String> loginCheck(@RequestBody UserInformation user){
        return  new ResponseEntity<>(this.services.login(user), HttpStatus.OK);
    }



    @PostMapping("/register")
    @CrossOrigin("*")
    public  ResponseEntity<String> registerUser(@RequestBody UserInformation user){
    return new ResponseEntity<>(this.services.register(user),HttpStatus.OK);
    }


}


