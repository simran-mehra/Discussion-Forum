package com.auproject.rest.dao;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="keywordquestion")
public class KeywordQuestion {

    private int userid;
    private int questionid;

    public KeywordQuestion(){

    }

    public int getUserid() {
        return userid;
    }

    public void setUserid(int userid) {
        this.userid = userid;
    }

    public int getQuestionid() {
        return questionid;
    }

    public void setQuestionid(int questionid) {
        this.questionid = questionid;
    }

}
