package com.ashypilov.game1;

import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;

import androidx.constraintlayout.widget.ConstraintLayout;

import java.util.HashMap;

public class Birds {
    private float xImage;
    private float yImage = 0;
    private ImageViewCloud imageViewCloud;
    private ConstraintLayout constraintLayout;
    private PlayGameActivity view;
    private boolean up = true;

    private HashMap<ImageView, ImageViewCloud> map = new HashMap<>();

    public Birds(PlayGameActivity view, ConstraintLayout constraintLayout) {

        this.view = view;
        this.constraintLayout = constraintLayout;
        xImage = 0;
        CreateBirds(5);
    }

    private void CreateBirds(int num) {
        for (int i = 0; i < num; i++) {
            imageViewCloud = new ImageViewCloud(view);
            imageViewCloud.setImageView(R.drawable.bird);

            map.put(imageViewCloud.getImageView(), imageViewCloud);

            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(200, 200);
            imageViewCloud.getImageView().setLayoutParams(layoutParams);
            imageViewCloud.getImageView().setX(xImage);
            imageViewCloud.getImageView().setY(yImage);
            xImage += 300.0;
            constraintLayout.addView(imageViewCloud.getImageView());
        }

    }

    public void BirdsMove(float maxHeight) {

        for (ImageView view: map.keySet()){
            ImageViewCloud cloud = map.get(view);
            Log.d("Move", maxHeight + "---" + cloud.getY());
            if (cloud.getY() >= maxHeight - 100) {
                up = true;
            }
            if (cloud.getY() <= 0) {
                up = false;
            }
            if (cloud.getY() < maxHeight - 100 && !up) {
                cloud.setYMoveDown();
            }
            else if (up && cloud.getY() > 0){
                cloud.setYMoveUp();
            }
        }
    }

    public void onClickBird() {
        for (ImageView view: map.keySet()) {
            ImageViewCloud cloud = map.get(view);
            cloud.getImageView().setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Toast.makeText(view.getContext(), "Bird", Toast.LENGTH_SHORT).show();
//                    constraintLayout.removeView(cloud.getImageView());
                    cloud.setY(300);
                }
            });
        }
    }
}
