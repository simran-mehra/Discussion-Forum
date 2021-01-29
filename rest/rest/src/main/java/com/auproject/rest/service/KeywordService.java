package com.auproject.rest.service;

import com.auproject.rest.dao.Keyword;
import com.auproject.rest.repository.KeywordRepo;
import com.sun.el.parser.BooleanNode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.security.Key;
import java.util.List;

@Service
public class KeywordService {

    @Autowired
    private KeywordRepo keywordRepo;

    public Boolean set(Keyword keyword){
        try{
            keywordRepo.save(keyword);
            return true;
        }
        catch(Exception e){
            return false;
        }
    }

    public List<Keyword> get(){
        return keywordRepo.findAll();
    }

}
