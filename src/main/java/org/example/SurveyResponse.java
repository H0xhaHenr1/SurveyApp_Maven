package org.example;

import java.util.List;

public class SurveyResponse {
    private  List<String> answers;
    public int surveyID;

    public SurveyResponse(List<String> answers){
        this.answers = answers;
//        this.surveyID = surveyID;
    }
//    public SurveyResponse(List<String> answers, int surveyID){
//        this.answers = answers;
//        this.surveyID = surveyID;
//    }

    public List<String > getAnswers() {
        return answers;
    }

    public String toString() {
        return  "Answers: " + answers;
    }

}
