package com.android.techdegree.interactivegame.ui;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.android.techdegree.interactivegame.R;
import com.android.techdegree.interactivegame.model.Animal;
import com.android.techdegree.interactivegame.model.Game;
import com.android.techdegree.interactivegame.model.Question;

public class GameActivity extends AppCompatActivity
                        implements AdapterView.OnItemSelectedListener {

    public static final String EXTRA_WINNER_IMAGE_ID = "EXTRA_WINNER_IMAGE_ID";
    public static final String EXTRA_WINNER_NAME_ID = "EXTRA_WINNER_NAME_ID";

    private ImageView questionImageView;
    private TextView questionTextView;
    private Spinner choiceSpinner;
    private Button nextQuestionButton;

    private Game game;
    private Animal winner;
    private int currentQuestionIndex;
    ArrayAdapter<String> choiceSpinnerAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);

        questionImageView =findViewById(R.id.question_image_view);
        questionTextView = findViewById(R.id.question_text_view);
        choiceSpinner = findViewById(R.id.choice_spinner);
        nextQuestionButton = findViewById(R.id.next_question_button);

        game = new Game();
        currentQuestionIndex = 0;
        loadQuestion(game.getQuestions().get(0));
    }

    private void loadQuestion(final Question question) {
        // Set the appropriate image for the question.
        questionImageView.setImageResource(question.getImageId());

        // Set the appropriate question text to be displayed.
        questionTextView.setText(getString(question.getTextId()));

        // Set up the Spinner.
        setUpSpinner(question);

        // Pay special attention to the last question from the list of questions.
        if(!question.isFinal()) {
            handleNextQuestionButton(question);
        } else {
            handleFinalQuestion(question);
        }
    }



    private void setUpSpinner(Question question) {
        // Create an adapter for the spinner.
        choiceSpinnerAdapter = new ArrayAdapter<String>(
                this, android.R.layout.simple_spinner_dropdown_item) {
            @NonNull
            @Override
            public View getView(int position, View convertView, @NonNull ViewGroup parent) {
                View view = super.getView(position, convertView, parent);
                // Handle the hint for the spinner.
                // Source: https://stackoverflow.com/questions/6602339/android-spinner-hint
                if (position == getCount()) {
                    TextView itemTextView = view.findViewById(android.R.id.text1);
                    itemTextView.setText("");
                    itemTextView.setHint(getItem(getCount()));
                }
                return view;
            }

            @Override
            public int getCount() {
                // Don't display last item. It is used as hint.
                return super.getCount() - 1;
            }
        };

        // Specify the layout to use when the list of choices appears.
        choiceSpinnerAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        // Populate adapter with the appropriate choices (all possible answers for this question).
        choiceSpinnerAdapter.add(getString(R.string.choice_0));
        choiceSpinnerAdapter.add(getString(R.string.choice_1));
        choiceSpinnerAdapter.add(getString(R.string.choice_2));
        choiceSpinnerAdapter.add(getString(R.string.choice_3));
        choiceSpinnerAdapter.add(getString(R.string.choice_4));

        // Add the hint as the last item in the adapter.
        choiceSpinnerAdapter.add(getString(R.string.choice_hint));

        // Apply the adapter to the spinner.
        choiceSpinner.setAdapter(choiceSpinnerAdapter);

        // Display the spinner hint.
        choiceSpinner.setSelection(choiceSpinnerAdapter.getCount());

        // Handle on-item-selected events.
        choiceSpinner.setOnItemSelectedListener(this);
    }

    private void handleNextQuestionButton(final Question question) {
        // Set the click listener for the button.
        nextQuestionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                currentQuestionIndex++;
                // If user did not select an item from the the spinner,
                // i.e. the hint is still displayed, then show a Toast.
                if(choiceSpinner.getSelectedItemPosition() == choiceSpinnerAdapter.getCount()) {
                    Toast toast = Toast.makeText(GameActivity.this,
                            "Please select an answer.", Toast.LENGTH_SHORT);
                    toast.setGravity(Gravity.CENTER, 0, 0);
                    toast.setMargin(0f, 0.3f) ;
                    toast.show();
                } else {
                    // The user has selected an answer for this question.
                    // Save the choice(answer) index in this Question object.
                    question.setChoiceIndex(choiceSpinner.getSelectedItemPosition());
                    // As long as the question list still has items left in it,
                    // load the next question.
                    if(currentQuestionIndex < game.getQuestions().size()) {
                        loadQuestion(game.getQuestions().get(currentQuestionIndex));
                    }
                }
            }
        });
    }

    private void handleFinalQuestion(final Question question) {
        // Modify the button's text to display "SUBMIT"
        nextQuestionButton.setText(getString(R.string.submit_button_text));
        nextQuestionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // If user did not select an item from the the spinner,
                // i.e. the hint is still displayed, then show a Toast.
                if(choiceSpinner.getSelectedItemPosition() == choiceSpinnerAdapter.getCount()) {
                    Toast toast = Toast.makeText(GameActivity.this,
                            "Please select an answer.", Toast.LENGTH_SHORT);
                    toast.setGravity(Gravity.CENTER, 0, 0);
                    toast.setMargin(0f, 0.3f) ;
                    toast.show();
                } else {
                    // Save the choice the user has selected.
                    question.setChoiceIndex(choiceSpinner.getSelectedItemPosition());
                    // Determine which animal is the winner for this game.
                    winner = game.findWinner();
                    // Launch Caption Activity to prompt the user for caption.
                    startCaptionActivity();

                }
            }
        });
    }




    private void startCaptionActivity() {
        Intent intent = new Intent(GameActivity.this, CaptionActivity.class);
        Bundle extras = new Bundle();
        extras.putInt(EXTRA_WINNER_IMAGE_ID, winner.getImageId());
        extras.putInt(EXTRA_WINNER_NAME_ID, winner.getNameId());
        intent.putExtras(extras);
        startActivity(intent);
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {}

    @Override
    public void onNothingSelected(AdapterView<?> parent) {}
}
