package com.auproject.rest;

import com.auproject.rest.dao.Keyword;
import com.auproject.rest.dao.Question;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class QuestionGetList {

    private int id;

    private String description;
    private boolean answeredflag;
    private String timestamp;

    private List<String> keywordList;

    public QuestionGetList(){

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public boolean isAnsweredflag() {
        return answeredflag;
    }

    public void setAnsweredflag(boolean answeredflag) {
        this.answeredflag = answeredflag;
    }

    public String getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }



    public List<String> getKeywordList() {
        return keywordList;
    }

    public void setKeywordList(List<String> keywordList) {
        this.keywordList = keywordList;
    }

}
