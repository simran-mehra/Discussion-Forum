package com.auproject.rest.service;

import com.auproject.rest.EmailService;
import com.auproject.rest.dao.Notification;
import com.auproject.rest.dao.Question;
import com.auproject.rest.repository.*;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Service
public class EmailNotificationService {

    @Autowired
    private NotificationRepo notificationRepo;

    @Autowired
    private UserInformationRepo userInformationRepo;

    @Autowired
    private UserTopicRepo userTopicRepo;

    @Autowired
    private EmailRepo emailRepo;

    @Autowired
    QuestionRepo questionRepo;

    @Autowired
    EmailService emailService;


    public void newQuestion(int topicId, String topicName) {
        List<Integer> userIdSet=this.userTopicRepo.getUserIdByTopicId(topicId);
        String date = new SimpleDateFormat("yyyy-MM-dd").format(new Date());
        String text="New question has been added to "+topicName;
        for( int i: userIdSet){

            this.notificationRepo.insert(text,i,date,false);
        }

        List<String> emailList=this.userInformationRepo.getEmailByUserId(userIdSet);

        Boolean result=true;
        try {
            result=true;
            this.emailService.sendEmail(emailList,text,topicName);
        }
        catch(Exception e) {
            result=false;
        }
        finally {
            for (int i = 0; i < userIdSet.size(); i++) {
                this.emailRepo.insert(emailList.get(i), date, result, text, "New Question", userIdSet.get(i));
            }
        }

    }

    public void addAnswerNotification(int questionId) {

        Question question =this.questionRepo.search(questionId);

        String questionName = question.getDescription();
        int topicId=question.getTopicid();

        String text = "New Answer has been added for Question : " + questionName;

        String subject = "New Answer";
        List<Integer> userIds = this.userTopicRepo.getUserIdByTopicId(topicId);
        String date = new SimpleDateFormat("yyyy-MM-dd").format(new Date());

        for(int i=0;i<userIds.size();i++) {
            this.notificationRepo.insert(text,userIds.get(i),date,false);
        }

        List<String> emails = this.userInformationRepo.getEmailByUserId(userIds);
        Boolean result = true;
        try {
            result = true;
            this.emailService.sendEmail(emails, text, subject);
        } catch (Exception e) {
            result = false;
        } finally {
            for(int i=0;i<userIds.size();i++) {
                this.emailRepo.insert(emails.get(i),date,result,text,subject,userIds.get(i));
            }
        }
    }

    public List<Notification> showNotifications(int userId) {
        return this.notificationRepo.findByUserId(userId);
    }
}
