package com.example.medz2;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

public class Bottom_nav extends AppCompatActivity {
    TextView month,day,year;
    FloatingActionButton mCreateRem;


    @SuppressLint("MissingInflatedId")
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bottom_nav);
        month=findViewById(R.id.textView5);
        day=findViewById(R.id.textView8);
        year=findViewById(R.id.textView7);


        Date currentTime= Calendar.getInstance().getTime();
        String formatDate=DateFormat.getDateInstance(DateFormat.FULL).format(currentTime);
        String[] splitDate=formatDate.split(",");
        Log.d("myLog",currentTime.toString());
        Log.d("myLog",formatDate);
        month.setText(splitDate[1]);
        day.setText(splitDate[0]);
        year.setText(splitDate[2]);
        Log.d("myLog",splitDate[0].trim());
        Log.d("myLog",splitDate[1].trim());
        Log.d("myLog",splitDate[2].trim());

        BottomNavigationView bottomNavigationView = findViewById(R.id.bottomNavigation);
        bottomNavigationView.setSelectedItemId(R.id.bottom_home);
        bottomNavigationView.setOnItemSelectedListener(item -> {
            switch (item.getItemId()) {
                case R.id.bottom_home:
                    return true;
                case R.id.add:
                    startActivity(new Intent(getApplicationContext(), Act2.class));
                    overridePendingTransition(R.anim.slide_in, R.anim.slide_out);
                    finish();
                    return true;
                case R.id.more:
                    startActivity(new Intent(getApplicationContext(), Act3.class));
                    overridePendingTransition(R.anim.slide_in, R.anim.slide_out);
                    finish();
                    return true;

            }
            return true;
        });





    }
//    @Override
//    public void onBackPressed() {
//        finish();
//        // exit form the app
//        super.onBackPressed();
//
//    }
}