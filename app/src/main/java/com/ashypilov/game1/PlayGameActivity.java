package com.ashypilov.game1;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.os.Bundle;
import android.os.Handler;
import android.view.View;

public class PlayGameActivity extends AppCompatActivity {

    private Clouds clouds;
    private Birds birds;
    private float x;
    private float y;
    private Handler handler;
    private ConstraintLayout constraintLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_play_game);

        final View view = new View(this);
        constraintLayout = findViewById(R.id.layout_play_game);

        constraintLayout.post(new Runnable() {
            @Override
            public void run() {
                (constraintLayout).addView(view);
            }
        });

        birds = new Birds(this, constraintLayout);
        clouds = new Clouds(this, constraintLayout);

    }

    @Override
    protected void onResume() {
        super.onResume();
        handler = new Handler();
        handler.post(new Runnable() {
            @Override
            public void run() {
                birds.BirdsMove(constraintLayout.getHeight());
                clouds.CloudsMove(constraintLayout.getWidth());
                handler.postDelayed(this::run, 5);
                birds.onClickBird();
                clouds.onClickCloud();
            }
        });
    }

}
