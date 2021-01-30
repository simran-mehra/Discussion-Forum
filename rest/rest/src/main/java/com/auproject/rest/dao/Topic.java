package com.auproject.rest.dao;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="topic")
public class Topic {

    @Id
    private int id;

    private int userid;
    private String name;
    private String timestamp;

    public Topic (){

    }

    public Topic(int id, int userid, String name, String timestamp) {
        this.id = id;
        this.userid = userid;
        this.name = name;
        this.timestamp = timestamp;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUserid() {
        return userid;
    }

    public void setUserid(int userid) {
        this.userid = userid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }

    @Override
    public String toString() {
        return "Topic{" +
                "id=" + id +
                ", userid=" + userid +
                ", name='" + name + '\'' +
                ", timestamp='" + timestamp + '\'' +
                '}';
    }
}
