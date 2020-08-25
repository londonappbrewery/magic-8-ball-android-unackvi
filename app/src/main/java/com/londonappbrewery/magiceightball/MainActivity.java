package com.londonappbrewery.magiceightball;

import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.Random;

public class  MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_main);


            final ImageView ballDisplay = (ImageView) findViewById(R.id.img_one);
            //ballDiaplay;

            final int ballArray [] = {
                    R.drawable.ball1,
                    R.drawable.ball2,
                    R.drawable.ball3,
                    R.drawable.ball4,
                    R.drawable.ball5
            };



        final Button askButton;
        askButton = (Button) findViewById(R.id.ask_button);
        askButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int min = 1;
                int max = 5;
                int range = max-min+1;

                int randomNum = calculateRandom(min,max);
                Log.d("Magic8", "The number is: " + randomNum);
                // Fade using Animation
                Animation askButtonAnimate = new AlphaAnimation(1.0f,0.0f);
                askButtonAnimate.setDuration(1000);
                ballDisplay.startAnimation(askButtonAnimate);
                ballDisplay.setImageResource(ballArray[randomNum-1]);
            }
            public int calculateRandom(int min, int max){
                return new Random().nextInt(max-min+1) + min;
            };

        });


    }


}
