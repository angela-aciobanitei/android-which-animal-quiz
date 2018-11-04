package com.android.techdegree.interactivegame.ui;

import android.graphics.drawable.Drawable;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.android.techdegree.interactivegame.R;

import static com.android.techdegree.interactivegame.ui.GameActivity.EXTRA_WINNER_IMAGE_ID;
import static com.android.techdegree.interactivegame.ui.GameActivity.EXTRA_WINNER_NAME_ID;
import static com.android.techdegree.interactivegame.ui.CaptionActivity.EXTRA_USER_CAPTION;

public class ResultActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        TextView captionTextView = findViewById(R.id.caption_text_view);
        ImageView resultImageView = findViewById(R.id.result_image_view);

        Bundle extras = getIntent().getExtras();
        if(extras != null) {
            int winnerImageId = extras.getInt(EXTRA_WINNER_IMAGE_ID, R.drawable.animals_panda);
            int winnerNameId = extras.getInt(EXTRA_WINNER_NAME_ID, 0);
            String caption = extras.getString(EXTRA_USER_CAPTION);
            String winner = getString(winnerNameId);

            captionTextView.setText(caption);
            resultImageView.setImageResource(winnerImageId);

            Toast toast = Toast.makeText(ResultActivity.this,
                    "You are a " + winner, Toast.LENGTH_SHORT);
            toast.setGravity(Gravity.CENTER, 0, 0);
            toast.setMargin(0f, 0.3f) ;
            toast.show();
        }
    }
}
