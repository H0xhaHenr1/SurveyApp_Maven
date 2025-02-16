package org.example;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Survey {
    List<SurveyQuestions> questions;
    private int questionCount;
    private static int surveyCount=0;
    private final int instanceId = surveyCount;
    private final String surveyName;
    private static Boolean isValid;

    public Survey(String surveyName) {
        this.surveyName = surveyName;
        surveyCount++;
    }

    public void addQuestion(String question, int questionNo){
        questions.add(new SurveyQuestions(question, questionNo));
        questionCount++;
    }

    public void removeQuestion(int questionNo){
        questions.remove(questionNo);
    }

    @Override
    public String toString() {
        return "Survey{" +
                "questions=" + questions +
                ", questionCount=" + questionCount +
                ", surveyName='" + surveyName + '\'' +
                '}';
    }

    public void validateSurvey(){
        if (questionCount<10){
            isValid = false;
        } else if (questionCount>40) {
            isValid = false;
        }else if (!hasUniqueQuestions()) {
            isValid = false;
        }

        System.out.println("Survy is: " + isValid);
    }

    public boolean hasUniqueQuestions() {
        Set<String> questionSet = new HashSet<>();
        for (SurveyQuestions question : questions) {
            if (!questionSet.add(question.getQuestion())) {
                return false; // Duplicate found
            }
        }
        return true;
    }
}

