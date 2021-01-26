package com.ashypilov.game1;

import android.util.Log;
import android.view.View;
import android.widget.ImageView;

public class ImageViewCloud {

    private float x = -30;
    private float y = -30;
    private ImageView imageView;
    private int resourceImage;
    private PlayGameActivity view;

    public ImageViewCloud(PlayGameActivity view) {
        this.view = view;
    }

    public ImageViewCloud(View childAt) {
        x = childAt.getX();
        y = childAt.getY();
        imageView = (ImageView) childAt;
    }


    public void setImageView(int imageView) {
        if (this.imageView == null) {
            this.imageView = new ImageView(this.view);
            this.imageView.setImageResource(imageView);
            this.resourceImage = imageView;
        }
        Log.d("ImageView", "" + this.imageView);
    }

    public PlayGameActivity getView() {
        return view;
    }

    public float getX() {
        return x;
    }

    public float getY() {
        return y;
    }

    public void setXMoveRight() {
        switch (resourceImage) {
            case R.drawable.cloud:
                this.x += 5;
                break;
            case R.drawable.cloud1:
                this.x += 7;
                break;
            case R.drawable.cloud2:
                this.x += 13;
                break;
        }
        imageView.setX(this.x);
    }

    public void setXMoveLeft() {
        switch (resourceImage) {
            case R.drawable.cloud:
                this.x -= 5;
                break;
            case R.drawable.cloud1:
                this.x -= 7;
                break;
            case R.drawable.cloud2:
                this.x -= 13;
                break;
        }
        imageView.setX(this.x);
    }

    public void setYMoveUp() {
        this.y -= 5;
        imageView.setY(this.y);
    }

    public void setYMoveDown() {
        this.y += 5;
        imageView.setY(this.y);
    }

    public void setY(float y) {
        this.y = y;
    }

    public void setX(float x) {
        this.x = x;
    }

    public ImageView getImageView() {
        return imageView;
    }
}
