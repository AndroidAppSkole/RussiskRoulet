package com.example.russiskroulet;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {
   int bulletSlot = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button rulBtn = (Button) findViewById(R.id.rulButton);
        Button skudBtn = (Button) findViewById(R.id.skudButton);

        rulBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TextView rulText = (TextView) findViewById(R.id.rulText);
                Random ran = new Random();
                bulletSlot = ran.nextInt(6 - 1) + 1;
                rulText.setText("Bullet er rullet, Nu Skud");
            }
        });

        skudBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TextView playText = (TextView) findViewById(R.id.playText);
                LinearLayout layout = (LinearLayout) findViewById(R.id.layout);
                Random ran = new Random();
                int currentSlot = ran.nextInt(6 - 1) + 1;

                if(currentSlot == bulletSlot) {
                    playText.setText("Du er Død");
                    layout.setBackgroundColor(Color.RED);
                }
                else{
                    playText.setText("Øffff, Du overlever");
                    layout.setBackgroundColor(Color.GREEN);

                }
            }
        });
    }
}