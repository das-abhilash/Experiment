package com.example.abhilashdas.experiment;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.widget.ImageView;
import android.widget.TextView;

public class ImageAnimationActivity extends AppCompatActivity {

    ImageView imageView;
    TextView textView;
    boolean toggle = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_image_animation);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        imageView = (ImageView) findViewById(R.id.city_image);
        textView = (TextView) findViewById(R.id.city_name);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                toggle = !toggle;
                if(toggle){
                    showText();
                } else {
                    hideText();
                }

            }
        });
    }
    public void showText() {
        int parentHeight = ((View) imageView.getParent()).getHeight();
        float scale = (parentHeight - textView.getHeight()) / (float) imageView.getHeight();
        imageView.setPivotX(imageView.getWidth() * 0.5f);
        imageView.setPivotY(0);
        /*imageView.setRotation(40);
        imageView.setRotationX(0);
        imageView.setRotationY(0);*/

        imageView.animate().scaleX(scale)
                .withEndAction(new Runnable() {
                    @Override
                    public void run() {
                        textView.setVisibility(View.VISIBLE);
                    }
                })
                .scaleY(scale)
                .setInterpolator(new AccelerateDecelerateInterpolator())
                .setDuration(300)
                .start();
    }

    public void hideText() {
        textView.setVisibility(View.INVISIBLE);
        imageView.animate().scaleX(1f).scaleY(1f)
                .setDuration(200)
                .start();
    }
}
