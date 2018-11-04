package com.android.techdegree.interactivegame.model;

import android.util.SparseArray;

import com.android.techdegree.interactivegame.R;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * A Game data model consists of a list of questions, a list of possible
 * animals and the result (the animal with the highest score).
 */
public class Game {

    private List<Question> questions;
    private List<Animal> animals;
    private Animal winner;

    public Game() {
        initQuestionList();
        initAnimalsList();
    }

    private void initQuestionList() {
        questions = new ArrayList<>();
        questions.add(new Question(
                // the question ID
                Question.QUESTION_ID_NOCTURNAL,
                // the text ID for the question (from strings.xml)
                R.string.question_0,
                // the list of text IDs for all the choices (from strings.xml)
                // the image ID (from res/drawable)
                R.drawable.animals_fox,
                // is this the last question in the list?
                false));

        questions.add(new Question(
                Question.QUESTION_ID_DIET_VEGGIES,
                R.string.question_1,
                R.drawable.animals_giraffe,
                false));

        questions.add(new Question(
                Question.QUESTION_ID_SOCIABILITY,
                R.string.question_2,
                R.drawable.animals_penguin,
                false));

        questions.add(new Question(
                Question.QUESTION_ID_MEMORY,
                R.string.question_3,
                R.drawable.animals_elephant,
                false));

        questions.add(new Question(
                Question.QUESTION_ID_SWIMMING,
                R.string.question_4,
                R.drawable.animals_penguin,
                false));

        questions.add(new Question(
                Question.QUESTION_ID_AGGRESSIVENESS,
                R.string.question_5,
                R.drawable.animals_bear,
                false));

        questions.add(new Question(
                Question.QUESTION_ID_AUTHORITY,
                R.string.question_6,
                R.drawable.animals_lion,
                false));

        questions.add(new Question(
                Question.QUESTION_ID_SHYNESS,
                R.string.question_7,
                R.drawable.animals_raccoon,
                false));

        questions.add(new Question(
                Question.QUESTION_ID_JOGGING,
                R.string.question_8,
                R.drawable.animals_rabbit,
                false));

        questions.add(new Question(
                Question.QUESTION_ID_DIET_PICKY,
                R.string.question_9,
                R.drawable.animals_panda,
                false));

        questions.add(new Question(
                Question.QUESTION_ID_HABITAT,
                R.string.question_10,
                R.drawable.animals_zebra,
                false));

        questions.add(new Question(
                Question.QUESTION_ID_TREEHOUSE,
                R.string.question_11,
                R.drawable.animals_fox,
                true));
    }

    private void initAnimalsList() {
        animals = new ArrayList<>();

        // Not all questions are relevant for a specific animal, so each animal will
        // only keep track of the questions that are considered relevant for that animal.
        // The map below will map relevant question IDs to a score corresponding to all
        // possible question choices (0 - strongly disagree, 1 - disagree, 2 - maybe,
        // 3 - agree, 4 - strongly agree).

        // Bear: diurnal, omnivore, solitary+++, aggressive, not shy, fast runner, forest.
        SparseArray<List<Integer>> scoreConfig ;
        scoreConfig= new SparseArray<>();
        scoreConfig.put(Question.QUESTION_ID_NOCTURNAL, Arrays.asList(-20, -10, 0, +10, +20));
        scoreConfig.put(Question.QUESTION_ID_DIET_VEGGIES, Arrays.asList(+10, +5, 0, -5, -10));
        scoreConfig.put(Question.QUESTION_ID_SOCIABILITY, Arrays.asList(+40, +20, 0, -20, -40));
        scoreConfig.put(Question.QUESTION_ID_AGGRESSIVENESS, Arrays.asList(+40, +20, 0, -20, -40));
        scoreConfig.put(Question.QUESTION_ID_SHYNESS, Arrays.asList(+20, +10, 0, -10, -20));
        scoreConfig.put(Question.QUESTION_ID_JOGGING, Arrays.asList(-20, -10, 0, +10, +20));
        scoreConfig.put(Question.QUESTION_ID_TREEHOUSE, Arrays.asList(-20, -10, 0, +10, +20));
        animals.add(new Animal(
                "bear",
                R.string.animals_bear,
                R.drawable.animals_bear,
                scoreConfig));


        // Fox: nocturnal+++, omnivore, solitary+++, shy+++, fast runner, forest.
        scoreConfig= new SparseArray<>();
        scoreConfig.put(Question.QUESTION_ID_NOCTURNAL, Arrays.asList(-20, -10, 0, +10, +20));
        scoreConfig.put(Question.QUESTION_ID_DIET_VEGGIES, Arrays.asList(+10, +5, 0, -5, -10));
        scoreConfig.put(Question.QUESTION_ID_SOCIABILITY, Arrays.asList(+40, +20, 0, -20, -40));
        scoreConfig.put(Question.QUESTION_ID_SHYNESS, Arrays.asList(-40, -20, 0, +20, +40));
        scoreConfig.put(Question.QUESTION_ID_JOGGING, Arrays.asList(-20, -10, 0, +10, +20));
        scoreConfig.put(Question.QUESTION_ID_TREEHOUSE, Arrays.asList(-20, -10, 0, +10, +20));
        animals.add(new Animal(
                "fox",
                R.string.animals_fox,
                R.drawable.animals_fox,
                scoreConfig));


        // Rabbit: nocturnal+++, herbivore, sociable++, shy, fast runner, forest.
        scoreConfig= new SparseArray<>();
        scoreConfig.put(Question.QUESTION_ID_NOCTURNAL, Arrays.asList(-20, -10, 0, +10, +20));
        scoreConfig.put(Question.QUESTION_ID_DIET_VEGGIES, Arrays.asList(-20, -10, 0, +10, +20));
        scoreConfig.put(Question.QUESTION_ID_SOCIABILITY, Arrays.asList(-20, -10, 0, +10, +20));
        scoreConfig.put(Question.QUESTION_ID_SHYNESS, Arrays.asList(-40, -20, 0, +20, +40));
        scoreConfig.put(Question.QUESTION_ID_JOGGING, Arrays.asList(-20, -10, 0, +10, +20));
        scoreConfig.put(Question.QUESTION_ID_TREEHOUSE, Arrays.asList(-20, -10, 0, +10, +20));
        animals.add(new Animal(
                "rabbit",
                R.string.animals_rabbit,
                R.drawable.animals_rabbit,
                scoreConfig));

        // Squirrel: diurnal, herbivore, bad memory, not shy, fast runner, forest.
        scoreConfig= new SparseArray<>();
        scoreConfig.put(Question.QUESTION_ID_NOCTURNAL, Arrays.asList(+20, +10, 0, -10, -20));
        scoreConfig.put(Question.QUESTION_ID_DIET_VEGGIES, Arrays.asList(-20, -10, 0, +10, +20));
        scoreConfig.put(Question.QUESTION_ID_MEMORY, Arrays.asList(-40, -20, 0, +20, +40));
        scoreConfig.put(Question.QUESTION_ID_SHYNESS, Arrays.asList(+20, +10, 0, -10, -20));
        scoreConfig.put(Question.QUESTION_ID_JOGGING, Arrays.asList(-20, -10, 0, +10, +20));
        scoreConfig.put(Question.QUESTION_ID_TREEHOUSE, Arrays.asList(-20, -10, 0, +10, +20));
        animals.add(new Animal(
                "squirrel",
                R.string.animals_squirrel,
                R.drawable.animals_squirrel,
                scoreConfig));

        // Raccoon: nocturnal, omnivore, sociable, not shy, forest.
        scoreConfig= new SparseArray<>();
        scoreConfig.put(Question.QUESTION_ID_NOCTURNAL, Arrays.asList(-20, -10, 0, +10, +20));
        scoreConfig.put(Question.QUESTION_ID_DIET_VEGGIES, Arrays.asList(+10, +5, 0, -5, -10));
        scoreConfig.put(Question.QUESTION_ID_SOCIABILITY, Arrays.asList(-20, -10, 0, +10, +20));
        scoreConfig.put(Question.QUESTION_ID_SWIMMING, Arrays.asList(-40, -20, 0, +20, +40));
        scoreConfig.put(Question.QUESTION_ID_SHYNESS, Arrays.asList(+20, +10, 0, -10, -20));
        scoreConfig.put(Question.QUESTION_ID_TREEHOUSE, Arrays.asList(-20, -10, 0, +10, +20));
        animals.add(new Animal(
                "raccoon",
                R.string.animals_raccoon,
                R.drawable.animals_raccoon,
                scoreConfig));

        // Lion: highly carnivore+++, highly sociable+++, aggressive, not shy, fast runner, hot habitat.
        scoreConfig= new SparseArray<>();
        scoreConfig.put(Question.QUESTION_ID_DIET_VEGGIES, Arrays.asList(+40, +20, 0, -20, -40));
        scoreConfig.put(Question.QUESTION_ID_SOCIABILITY, Arrays.asList(-40, -20, 0, +20, +40));
        scoreConfig.put(Question.QUESTION_ID_AGGRESSIVENESS, Arrays.asList(+40, +20, 0, -20, -40));
        scoreConfig.put(Question.QUESTION_ID_AUTHORITY, Arrays.asList(-40, -20, 0, +20, +40));
        scoreConfig.put(Question.QUESTION_ID_SHYNESS, Arrays.asList(+20, +10, 0, -10, -20));
        scoreConfig.put(Question.QUESTION_ID_JOGGING, Arrays.asList(-20, -10, 0, +10, +20));
        scoreConfig.put(Question.QUESTION_ID_HABITAT, Arrays.asList(-40, -20, 0, +20, +40));
        animals.add(new Animal(
                "lion",
                R.string.animals_lion,
                R.drawable.animals_lion,
                scoreConfig));

        // Elephant: diurnal, herbivore, sociable, good memory, hot habitat.
        scoreConfig= new SparseArray<>();
        scoreConfig.put(Question.QUESTION_ID_NOCTURNAL, Arrays.asList(+20, +10, 0, -10, -20));
        scoreConfig.put(Question.QUESTION_ID_DIET_VEGGIES, Arrays.asList(-20, -10, 0, +10, +20));
        scoreConfig.put(Question.QUESTION_ID_SOCIABILITY, Arrays.asList(-20, -10, 0, +10, +20));
        scoreConfig.put(Question.QUESTION_ID_MEMORY, Arrays.asList(+40, +20, 0, -20, -40));
        scoreConfig.put(Question.QUESTION_ID_HABITAT, Arrays.asList(-40, -20, 0, +20, +40));
        animals.add(new Animal(
                "elephant",
                R.string.animals_elephant,
                R.drawable.animals_elephant,
                scoreConfig));

        // Giraffe: diurnal, herbivore, sociable,  hot habitat.
        scoreConfig= new SparseArray<>();
        scoreConfig.put(Question.QUESTION_ID_NOCTURNAL, Arrays.asList(+20, +10, 0, -10, -20));
        scoreConfig.put(Question.QUESTION_ID_DIET_VEGGIES, Arrays.asList(-20, -10, 0, +10, +20));
        scoreConfig.put(Question.QUESTION_ID_SOCIABILITY, Arrays.asList(-20, -10, 0, +10, +20));
        scoreConfig.put(Question.QUESTION_ID_HABITAT, Arrays.asList(-40, -20, 0, +20, +40));
        animals.add(new Animal(
                "giraffe",
                R.string.animals_giraffe,
                R.drawable.animals_giraffe,
                scoreConfig));

        // Zebra: diurnal, herbivore, highly sociable+++,  hot habitat.
        scoreConfig= new SparseArray<>();
        scoreConfig.put(Question.QUESTION_ID_NOCTURNAL, Arrays.asList(+20, +10, 0, -10, -20));
        scoreConfig.put(Question.QUESTION_ID_DIET_VEGGIES, Arrays.asList(-20, -10, 0, +10, +20));
        scoreConfig.put(Question.QUESTION_ID_SOCIABILITY, Arrays.asList(-40, -20, 0, +20, +40));
        scoreConfig.put(Question.QUESTION_ID_HABITAT, Arrays.asList(-40, -20, 0, +20, +40));
        animals.add(new Animal(
                "zebra",
                R.string.animals_zebra,
                R.drawable.animals_zebra,
                scoreConfig));

        // Panda: herbivore, solitary +++, only eats bamboo, cold habitat (mountains).
        scoreConfig= new SparseArray<>();
        scoreConfig.put(Question.QUESTION_ID_DIET_VEGGIES, Arrays.asList(-20, -10, 0, +10, +20));
        scoreConfig.put(Question.QUESTION_ID_SOCIABILITY, Arrays.asList(+40, +20, 0, -20, -40));
        scoreConfig.put(Question.QUESTION_ID_DIET_PICKY, Arrays.asList(-40, -20, 0, +20, +40));
        scoreConfig.put(Question.QUESTION_ID_HABITAT, Arrays.asList(+40, +20, 0, -20, -40));
        animals.add(new Animal(
                "panda",
                R.string.animals_panda,
                R.drawable.animals_panda,
                scoreConfig));

        // Penguin: highly sociable +++, not shy, swims fast, cold habitat.
        scoreConfig= new SparseArray<>();
        scoreConfig.put(Question.QUESTION_ID_SOCIABILITY, Arrays.asList(-40, -20, 0, +20, +40));
        scoreConfig.put(Question.QUESTION_ID_SWIMMING, Arrays.asList(-40, -20, 0, +20, +40));
        scoreConfig.put(Question.QUESTION_ID_SHYNESS, Arrays.asList(+40, +20, 0, -20, -40));
        scoreConfig.put(Question.QUESTION_ID_HABITAT, Arrays.asList(+40, +20, 0, -20, -40));
        animals.add(new Animal(
                "penguin",
                R.string.animals_penguin,
                R.drawable.animals_penguin,
                scoreConfig));
    }

    // Getters and Setters
    public List<Question> getQuestions() {
        return questions;
    }

    public void setQuestions(List<Question> questions) {
        this.questions = questions;
    }

    public List<Animal> getAnimals() {
        return animals;
    }

    public void setAnimals(List<Animal> animals) {
        this.animals = animals;
    }

    public Animal getWinner() {
        return winner;
    }

    public void setWinner(Animal winner) {
        this.winner = winner;
    }

    public Animal findWinner() {
        // Calculate scores for all the animals
        for (Animal animal: animals) {
            animal.calculateScore(questions);
        }

        // Sort the animals by score, highest score first.
        Collections.sort(animals, Collections.reverseOrder());

        // Return the animal with the highest score.
        return animals.get(0);
    }
}
