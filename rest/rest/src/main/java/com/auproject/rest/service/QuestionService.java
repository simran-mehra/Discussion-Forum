package com.auproject.rest.service;

import com.auproject.rest.QuestionGetList;
import com.auproject.rest.QuestionList;
import com.auproject.rest.dao.KeywordQuestion;
import com.auproject.rest.dao.Question;
import com.auproject.rest.repository.KeywordQuestionRepo;
import com.auproject.rest.repository.QuestionRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class QuestionService {

    @Autowired
    private QuestionRepo questionRepo;
    @Autowired
    private KeywordQuestionRepo keywordQuestionRepo;


    public List<QuestionGetList> getAllQuestion(int userId){

        List<Question> questionList= this.questionRepo.getAllQuestion(userId);
        List<QuestionGetList> mainList=new ArrayList<>();
        for(Question ques : questionList){
            QuestionGetList list= new QuestionGetList();
            int quesId=ques.getId();
            list.setId(ques.getId());
            list.setAnsweredflag(ques.getAnsweredflag());
            list.setKeywordList(this.keywordQuestionRepo.getKeywordId(quesId));
            list.setDescription(ques.getDescription());
            list.setTimestamp(ques.getTimestamp());
            mainList.add(list);

        }
        return mainList;

    }

    public List<QuestionGetList> getQuestion(int topicId){
        //topicid
        List<Question> questionList= this.questionRepo.getQuestionByTopic(topicId);
        List<QuestionGetList> mainList=new ArrayList<>();
        for(Question ques : questionList){
            QuestionGetList list= new QuestionGetList();
            int quesId=ques.getId();
            list.setId(ques.getId());
            list.setAnsweredflag(ques.getAnsweredflag());
            list.setKeywordList(this.keywordQuestionRepo.getKeywordId(quesId));
            list.setDescription(ques.getDescription());
            list.setTimestamp(ques.getTimestamp());
            mainList.add(list);

        }
        return mainList;
    }

    public Boolean createQuestion(QuestionList questionList) {
        Question question = questionList.getQuestion();
        List<KeywordQuestion> keywordList = questionList.getKeywordQuestionList();

        System.out.println(questionList);
        System.out.println(question);
        System.out.println(keywordList);
//        System.out.println(this.questionRepo.find(this.questionRepo.save(question).getId()));
//        this.questionRepo.save(question).getId();
        int quesId= this.questionRepo.save(question).getId();
        System.out.println(quesId);
        for(KeywordQuestion keywordQuestion: keywordList){
            System.out.println(keywordQuestion);
            this.keywordQuestionRepo.insert(keywordQuestion.getKeywordid(),quesId,keywordQuestion.getKeywordName());
        }

        return true;

    }

    public QuestionGetList getSpecificQuestion(int quesId){
        //topicid
        Question ques=  this.questionRepo.getQuestionById(quesId);
        QuestionGetList questionGetList= new QuestionGetList();
        questionGetList.setId(ques.getId());
        questionGetList.setAnsweredflag(ques.getAnsweredflag());
        questionGetList.setKeywordList(this.keywordQuestionRepo.getKeywordId(quesId));
        questionGetList.setDescription(ques.getDescription());
        questionGetList.setTimestamp(ques.getTimestamp());

        return questionGetList;
    }



}
