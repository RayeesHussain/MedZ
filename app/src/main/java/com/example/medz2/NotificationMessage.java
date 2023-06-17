package com.example.medz2;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;



import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

//this class creates the Reminder Notification Message

public class NotificationMessage extends AppCompatActivity {
    TextView textView;
    Button b1,b2;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notification_message);
        textView = findViewById(R.id.tv_message);
        Bundle bundle = getIntent().getExtras();                                                    //call the data which is passed by another intent
        textView.setText(bundle.getString("message"));
        b1=findViewById(R.id.button6);
        b2=findViewById(R.id.button7);

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent1=new Intent(NotificationMessage.this,ReminderActivity.class);
                startActivity(intent1);
                finish();

            }
        });
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent1=new Intent(NotificationMessage.this,ScheduleScreen.class);
                startActivity(intent1);
                finish();


            }
        });


    }




}