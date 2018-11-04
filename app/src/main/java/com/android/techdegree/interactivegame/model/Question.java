package com.android.techdegree.interactivegame.model;

import java.util.List;

/**
 * A Question data model has
 *      the question ID,
 *      the text ID for the question,
 *      the image ID,
 *      the selected choice index.
 *
 */
public class Question {

    public static final int QUESTION_ID_NOCTURNAL = 0;
    public static final int QUESTION_ID_DIET_VEGGIES = 1;
    public static final int QUESTION_ID_SOCIABILITY = 2;
    public static final int QUESTION_ID_MEMORY = 3;
    public static final int QUESTION_ID_SWIMMING = 4;
    public static final int QUESTION_ID_AGGRESSIVENESS = 5;
    public static final int QUESTION_ID_AUTHORITY = 6;
    public static final int QUESTION_ID_SHYNESS = 7;
    public static final int QUESTION_ID_JOGGING = 8;
    public static final int QUESTION_ID_DIET_PICKY = 9;
    public static final int QUESTION_ID_HABITAT = 10;
    public static final int QUESTION_ID_TREEHOUSE = 11;

    private int questionId;
    private int textId;
    private int choiceIndex;
    private int imageId;
    private boolean isFinal;

    public Question(int questionId, int textId, int imageId, boolean isFinal) {
        this.questionId = questionId;
        this.textId = textId;
        this.imageId = imageId;
        this.isFinal = isFinal;
    }

    public int getQuestionId() {
        return questionId;
    }

    public void setQuestionId(int questionId) {
        this.questionId = questionId;
    }

    public int getTextId() {
        return textId;
    }

    public void setTextId(int textId) {
        this.textId = textId;
    }

    public int getImageId() {
        return imageId;
    }

    public void setImageId(int imageId) {
        this.imageId = imageId;
    }

    public int getChoiceIndex() {
        return choiceIndex;
    }

    public void setChoiceIndex(int choiceIndex) {
        this.choiceIndex = choiceIndex;
    }

    public boolean isFinal() {
        return isFinal;
    }

    public void setFinal(boolean aFinal) {
        isFinal = aFinal;
    }
}
