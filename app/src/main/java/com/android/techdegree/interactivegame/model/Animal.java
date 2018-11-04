package com.android.techdegree.interactivegame.model;


import android.util.SparseArray;

import java.util.List;

public class Animal implements  Comparable<Animal> {

    private String name; // for debugging purposes only
    private int nameId;
    private int imageId;
    // Not all questions are relevant for a specific animal, so each animal will
    // only keep track of the questions that are considered relevant for that animal.
    // The "scoreConfig" member variable will map relevant question IDs
    // to a score corresponding to all possible question choices (0, 1, 2, 3, 4).
    private SparseArray<List<Integer>> scoreConfig;
    private Integer score;

    public Animal(String name, int nameId, int imageId, SparseArray<List<Integer>> scoreConfig ) {
        this.name = name;
        this.nameId = nameId;
        this.imageId = imageId;
        this.scoreConfig = scoreConfig;
        score = 0;
    }

    public int getNameId() {
        return nameId;
    }

    public void setNameId(int nameId) {
        this.nameId = nameId;
    }

    public int getImageId() {
        return imageId;
    }

    public void setImageId(int imageId) {
        this.imageId = imageId;
    }

    public SparseArray getScoreConfig() {
        return scoreConfig;
    }

    public void setScoreConfig(SparseArray<List<Integer>> scoreConfig) {
        this.scoreConfig = scoreConfig;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public void calculateScore(List<Question> questions) {
        for(int i = 0; i < scoreConfig.size(); i++) {
            int questionID = scoreConfig.keyAt(i);
            List<Integer> questionScores = scoreConfig.get(questionID);
            Question currentQuestion = findQuestionById(questionID, questions);
            if (currentQuestion != null){
                score += questionScores.get(currentQuestion.getChoiceIndex());
            }
        }
    }

    @Override
    public int compareTo(Animal other) {
        // We always want to sort by last name then first name
        if (equals(other)) return 0;
        return score.compareTo(other.score);
}

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Animal)) return false;
        Animal animal = (Animal) o;
        return score.equals(animal.score);

    }

    @Override
    public int hashCode() {
        return nameId;
    }


    private Question findQuestionById(int id, List<Question> questions) {
        for (Question question : questions) {
            if(question.getQuestionId() == id){
                return question;
            }
        }
        return null;
    }


}
