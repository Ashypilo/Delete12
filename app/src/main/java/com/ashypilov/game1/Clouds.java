package com.ashypilov.game1;

import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;

import androidx.constraintlayout.widget.ConstraintLayout;

import java.util.HashMap;

public class Clouds {
    private float xImage = 0;
    private float yImage = 0;
    private ImageViewCloud imageViewCloud;
    private ConstraintLayout constraintLayout;
    private PlayGameActivity view;
    private boolean left = true;

    private HashMap<ImageView, ImageViewCloud> map = new HashMap<>();

    public Clouds(PlayGameActivity view, ConstraintLayout constraintLayout) {

        this.view = view;
        this.constraintLayout = constraintLayout;
        for (int i = 0; i < 20; i++) {
            if (i % 2 == 0) {
                xImage = 100.0f;
                imageViewCloud = new ImageViewCloud(view);
                imageViewCloud.setImageView(R.drawable.cloud);
            }
            else if(i % 3 == 0) {
                xImage = 400.0f;
                imageViewCloud = new ImageViewCloud(view);
                imageViewCloud.setImageView(R.drawable.cloud1);
            }
            else {
                xImage = 600.0f;
                imageViewCloud = new ImageViewCloud(view);
                imageViewCloud.setImageView(R.drawable.cloud2);
            }
            map.put(imageViewCloud.getImageView(), imageViewCloud);

            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(200, 200);
            imageViewCloud.getImageView().setLayoutParams(layoutParams);
            imageViewCloud.getImageView().setX(xImage);
            imageViewCloud.getImageView().setY(yImage);
            yImage += 200.0;
            constraintLayout.addView(imageViewCloud.getImageView());
            Log.d("cloud", constraintLayout.getWidth() + "----" + constraintLayout.getHeight());
        }
    }

    public void CloudsMove(float maxWidth) {

        Log.d("move", maxWidth + "");
        for (ImageView view: map.keySet()){
            ImageViewCloud cloud = map.get(view);
            if (cloud.getX() >= maxWidth - 100) {
                left = true;
            }
            if (cloud.getX() < 0) {
                left = false;
            }
            if (cloud.getX() < maxWidth - 100 && !left) {
                cloud.setXMoveRight();
            }
            else if (left && cloud.getX() > 0){
                cloud.setXMoveLeft();
            }
        }
    }

    public void onClickCloud() {
        for (ImageView view: map.keySet()) {
            ImageViewCloud cloud = map.get(view);
            cloud.getImageView().setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Toast.makeText(view.getContext(), "Cloud", Toast.LENGTH_SHORT).show();
                }
            });
        }
    }

}
