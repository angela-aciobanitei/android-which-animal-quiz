package com.android.techdegree.interactivegame.ui;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.android.techdegree.interactivegame.R;

import static com.android.techdegree.interactivegame.ui.GameActivity.EXTRA_WINNER_IMAGE_ID;
import static com.android.techdegree.interactivegame.ui.GameActivity.EXTRA_WINNER_NAME_ID;

public class CaptionActivity extends AppCompatActivity {

    public static final String EXTRA_USER_CAPTION = "EXTRA_USER_CAPTION";
    private Button showResultsButton;
    private EditText captionEditText;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_caption);

        captionEditText = findViewById(R.id.caption_edit_text);
        showResultsButton = findViewById(R.id.results_button);

        showResultsButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String caption = captionEditText.getText().toString();

                // Get the extras sent along form GameActivity
                Bundle extras = getIntent().getExtras();
                int imageId = extras.getInt(EXTRA_WINNER_IMAGE_ID, R.drawable.animals_panda);
                int nameId = extras.getInt(EXTRA_WINNER_NAME_ID);

                // Launch ResultActivity to display the result of the game.
                Intent intent = new Intent(CaptionActivity.this, ResultActivity.class);
                Bundle bundle = new Bundle();
                bundle.putInt(EXTRA_WINNER_IMAGE_ID, imageId);
                bundle.putInt(EXTRA_WINNER_NAME_ID, nameId);
                bundle.putString(EXTRA_USER_CAPTION, caption);
                intent.putExtras(bundle);
                startActivity(intent);
            }
        });
    }
}
