package com.grafexmedia.learnandroid.intent;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.grafexmedia.learnandroid.R;

public class ImplicitActivity extends AppCompatActivity {

    Button dialBtn, msgBtn, emailBtn, shareBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_implicit);

        dialBtn = findViewById(R.id.btnDial);
        msgBtn = findViewById(R.id.btnMsg);
        emailBtn = findViewById(R.id.btnEmail);
        shareBtn = findViewById(R.id.btnShare);

        dialBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent dialIntent = new Intent(Intent.ACTION_DIAL);
//                dialIntent.setAction(Intent.ACTION_DIAL) // both are same thing
                dialIntent.setData(Uri.parse("tel: +919980193592"));
                startActivity(dialIntent);
            }
        });

        msgBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent msgIntent = new Intent(Intent.ACTION_SENDTO);
                msgIntent.setData(Uri.parse("smsto:"+Uri.encode("+919980193592")));
                msgIntent.putExtra("sms_body", "Test message from my app");
                startActivity(msgIntent);
            }
        });

        emailBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent emailIntent = new Intent(Intent.ACTION_SEND);
                emailIntent.setType("message/rfc822");
                emailIntent.putExtra(Intent.EXTRA_EMAIL, new String[]{"rabikumar23154@gmail.com","rabikrishnayadav@gmail.com"});
                emailIntent.putExtra(Intent.EXTRA_SUBJECT, "Queries");
                emailIntent.putExtra(Intent.EXTRA_TEXT, "This is for testing");
                startActivity(Intent.createChooser(emailIntent, "Email via"));
            }
        });

        shareBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent shareIntent = new Intent(Intent.ACTION_SEND);
                shareIntent.setType("text/plain");
                shareIntent.putExtra(Intent.EXTRA_TEXT, "Download this Amazing App, https://play.google.com/");
                startActivity(Intent.createChooser(shareIntent, "Share Via"));
            }
        });
    }
}