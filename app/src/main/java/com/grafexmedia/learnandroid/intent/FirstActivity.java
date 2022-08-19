package com.grafexmedia.learnandroid.intent;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.grafexmedia.learnandroid.MainActivity;
import com.grafexmedia.learnandroid.R;

public class FirstActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first);

        TextView textView = findViewById(R.id.textView);
        TextView textView1 = findViewById(R.id.textView1);
        Button button = findViewById(R.id.secondActivity);

        Intent fromPrevActivity = getIntent();
        String name = fromPrevActivity.getStringExtra("name");
        int number = fromPrevActivity.getIntExtra("number", 0);

        textView.setText(name);
//        textView1.setText(number);
        getSupportActionBar().setTitle(name);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(FirstActivity.this, SecondActivity.class);
                startActivity(intent);
            }
        });
    }
}