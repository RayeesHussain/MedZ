package com.example.medz2;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class Act3 extends AppCompatActivity {
    CardView view,buy,insulin,schedule;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_act3);
        BottomNavigationView bottomNavigationView = (BottomNavigationView) findViewById(R.id.bottomNavigation);
        bottomNavigationView.setSelectedItemId(R.id.more);
        bottomNavigationView.setOnItemSelectedListener(item -> {
            switch (item.getItemId()) {
                case R.id.bottom_home:
                    startActivity(new Intent(getApplicationContext(),Bottom_nav.class));
                    overridePendingTransition(R.anim.slide_in, R.anim.slide_out);
                    finish();
                    return true;
                case R.id.add:
                    startActivity(new Intent(getApplicationContext(), Act2.class));
                    overridePendingTransition(R.anim.slide_in, R.anim.slide_out);
                    finish();
                    return true;
                case R.id.more:
                    return true;

            }
            return true;
        });
        view=findViewById(R.id.viewCard);
        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(Act3.this,ViewScreen.class);
                startActivity(intent);
            }
        });

        buy=findViewById(R.id.buyCard);
        buy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(Act3.this,BuyScreen.class);
                startActivity(intent);
            }
        });

        insulin=findViewById(R.id.insulinCard);
        insulin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(Act3.this,MainActivity.class);
                startActivity(intent);
            }
        });

        schedule=findViewById(R.id.scheduleCard);
        schedule.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(Act3.this,ScheduleScreen.class);
                startActivity(intent);
            }
        });

    }
}