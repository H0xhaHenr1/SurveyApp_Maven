package org.example;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Candidate {
    private List<SurveyResponse> mySurveys =new ArrayList<>();
    private String FirstName, LastName, Email;

    public Candidate(String name, String surname, String email, SurveyResponse surveyResponse){
        FirstName = name;
        LastName = surname;
        Email = email;
        mySurveys.add(surveyResponse);
    }

    public void addSurveyResponse(SurveyResponse e){
        mySurveys.add(e);
    }

    public int getSurveyNumber(){
        return  mySurveys.size();
    }

    public List<SurveyResponse> getMySurveys() {
        return mySurveys;
    }

    public String getFirstName() {
        return FirstName;
    }

    public String getLastName() {
        return LastName;
    }

    public String getEmail() {
        return Email;
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Candidate candidate = (Candidate) o;

        return Objects.equals(FirstName, candidate.FirstName) &&
                Objects.equals(LastName, candidate.LastName) &&
                Objects.equals(Email, candidate.Email);
    }

    public String toString() {
        return "Candidate{" + "Name='" + FirstName + ", Surname='" + LastName + ", Email='" + Email + " " + mySurveys;
    }
}
