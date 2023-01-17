package com.example.progressbardemo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.RatingBar;
import android.widget.SeekBar;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button startBtn=(Button) findViewById(R.id.button);
        Button endBtn=(Button) findViewById(R.id.button2);
        Button reBtn=(Button) findViewById(R.id.button3);
        ProgressBar roundBar=(ProgressBar)findViewById(R.id.progressBar2);
        ProgressBar horBar=(ProgressBar)findViewById(R.id.progressBar);
        RatingBar rBar=(RatingBar)findViewById(R.id.ratingBar2);
        SeekBar sBar=(SeekBar)findViewById(R.id.seekBar);

        startBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                horBar.incrementProgressBy(10);
                if(horBar.getProgress()>=100){
                    horBar.setVisibility(View.GONE);
                }
            }
        });

        endBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                roundBar.setVisibility(View.INVISIBLE);
            }
        });

        reBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                horBar.setProgress(25);
                roundBar.setVisibility(View.VISIBLE);
            }
        });

        rBar.setOnRatingBarChangeListener(new RatingBar.OnRatingBarChangeListener() {
            @Override
            public void onRatingChanged(RatingBar ratingBar, float v, boolean b) {
                Toast.makeText(MainActivity.this, "您給分數為："+rBar.getRating()+" 顆星", Toast.LENGTH_SHORT).show();
            }
        });

        sBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                Toast.makeText(MainActivity.this, "您給分數為："+sBar.getProgress()+" 分", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });


    }
}