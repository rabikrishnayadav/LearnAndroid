package com.grafexmedia.learnandroid;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.grafexmedia.learnandroid.intent.FirstActivity;
import com.grafexmedia.learnandroid.intent.ImplicitActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView textView = findViewById(R.id.textView);
        Button button = findViewById(R.id.firstActivity);
        Button implicit = findViewById(R.id.implicitActivity);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, FirstActivity.class);
                intent.putExtra("name", "Rabi Kr Yadav");
                intent.putExtra("number", 998019359);
                startActivity(intent);
            }
        });

        implicit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, ImplicitActivity.class));
            }
        });

    }
}