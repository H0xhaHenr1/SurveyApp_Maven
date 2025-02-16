package org.example;





import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SurveyManager {
    String[] data= new String[15];
    List<Candidate> candidates = new ArrayList<>();
    String csvFile = "text.csv";

    public SurveyManager() {
    }

    public void readCSV(String path){

        csvFile = path;
        try (BufferedReader br = new BufferedReader(new FileReader(csvFile))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] data = line.split(",");

                String name = data[0];
                String surname = data[1];
                String email = data[2];

                List<String> answers = new ArrayList<>();
                for (int i = 3; i < data.length; i++) {
                    answers.add(data[i]);
                }

                System.out.println(candidates.size());

                Candidate newCandidate = new Candidate(name,surname,email ,new SurveyResponse(answers))  ;
                if (!candidates.contains(newCandidate)) {
                    candidates.add(newCandidate);
                } else {
                    for (Candidate candidate : candidates)
                        if (candidate.equals(newCandidate)){
                            candidate.addSurveyResponse(new SurveyResponse(answers));
                        }
                    break;
                }

            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        for (Candidate candidate : candidates) {
            System.out.println(candidate);
        }
    }

    public String getCandidateMostSurveys(){
        Candidate candidateMaxSurveys = candidates.getFirst();
        int maxSurveyNumber = candidateMaxSurveys.getSurveyNumber();
        for (Candidate candidate : candidates) {
            int currentSurveys = candidate.getSurveyNumber();
            if (currentSurveys > maxSurveyNumber) {
                maxSurveyNumber = currentSurveys;
                candidateMaxSurveys = candidate;
            }
        }
        return candidateMaxSurveys.getFirstName();
    }

    public void getMostFrequentAnswer(){
        String csvFile = "D:\\JavaProjects\\LufthansaHW1\\src\\text.csv";
        List<List<String>> allAnswers = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(csvFile))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] data = line.split(",");
                List<String> answers = new ArrayList<>();
                for (int i = 3; i < data.length; i++) {
                    answers.add(data[i].trim());
                }

                allAnswers.add(answers);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        for (List<String> answers : allAnswers) {
            System.out.println(answers);
        }

        getMostFrequentAnswerHelper(allAnswers);
    }

    private void getMostFrequentAnswerHelper(List<List<String>> allAnswers) {
        Map<String, Integer> answerFrequency = new HashMap<>();

        for (List<String> answers : allAnswers) {
            for (String answer : answers) {
                answerFrequency.put(answer, answerFrequency.getOrDefault(answer, 0) + 1);
            }
        }

        String mostFrequentAnswer = null;
        int maxFrequency = 0;
        for (Map.Entry<String, Integer> entry : answerFrequency.entrySet()) {
            if (entry.getValue() > maxFrequency) {
                mostFrequentAnswer = entry.getKey();
                maxFrequency = entry.getValue();
            }
        }

        if (mostFrequentAnswer != null) {
            System.out.println("Most frequent answer: " + mostFrequentAnswer + " (appeared " + maxFrequency + " times)");
        } else {
            System.out.println("No answers found.");
        }
    }

    public void getLeastFrequentQuestionAnswered(){
        String csvFile = "D:\\JavaProjects\\LufthansaHW1\\src\\text.csv";
        List<List<String>> allAnswers = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(csvFile))) {
            String line;
            while ((line = br.readLine()) != null) {
                // Split the line by commas
                String[] data = line.split(",");

                List<String> answers = new ArrayList<>();
                for (int i = 3; i < data.length; i++) {
                    answers.add(data[i].trim());
                }

                allAnswers.add(answers);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        getLeastFrequentQuestionAnsweredHelper(allAnswers);
    }

    private void getLeastFrequentQuestionAnsweredHelper(List<List<String>> allAnswers) {
        int numberOfCandidates = allAnswers.size();
        int numberOfQuestions = allAnswers.get(0).size();

        for (int questionIndex=0; questionIndex<numberOfQuestions; questionIndex++){
            int validAnswer = 0;

            for (List<String> answer : allAnswers){
                String answerAtIndex = answer.get(questionIndex);
                if(!answerAtIndex.equals("null")){
                    validAnswer++;
                }
            }
            double answerPerscentage = (double) validAnswer / numberOfCandidates *100;

            if (answerPerscentage < 50) {
                System.out.println("Question " + (questionIndex + 1) + " is answered by less than 50% of the candidates (" + answerPerscentage + "%).");
            } else {
                System.out.println("Question " + (questionIndex + 1) + " is answered by " + answerPerscentage + "% of the candidates.");
            }
        }

    }
}



