package com.auproject.rest.dao;

import javax.persistence.*;

@Entity
@Table(name = "rating")
public class Rating {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private int answerid;
    private int ratingcount;
    private int userid;
    private String timestamp;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getAnswerid() {
        return answerid;
    }

    public void setAnswerid(int answerid) {
        this.answerid = answerid;
    }

    public int getRatingcount() {
        return ratingcount;
    }

    public void setRatingcount(int ratingcount) {
        this.ratingcount = ratingcount;
    }

    public int getUserid() {
        return userid;
    }

    public void setUserid(int userid) {
        this.userid = userid;
    }

    public String getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }

    public Rating() {};

    public Rating(int id, int answerid, int ratingcount, int userid, String timestamp) {
        this.id = id;
        this.answerid = answerid;
        this.ratingcount = ratingcount;
        this.userid = userid;
        this.timestamp = timestamp;
    }

    @Override
    public String toString() {
        return "Rating{" +
                "id=" + id +
                ", answerid=" + answerid +
                ", ratingcount=" + ratingcount +
                ", userid=" + userid +
                ", timestamp='" + timestamp + '\'' +
                '}';
    }
}
