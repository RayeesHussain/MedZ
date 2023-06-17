package com.example.medz2;

import static android.view.View.GONE;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.ActionMode;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.List;

public class Bottom_nav extends AppCompatActivity  {
    TextView month,day,year;
    FloatingActionButton mCreateRem;


    Button b3;

    @SuppressLint("MissingInflatedId")
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bottom_nav);
        /*month=findViewById(R.id.textView5);
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
        Log.d("myLog",splitDate[2].trim());*/

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
        b3=findViewById(R.id.button3);
        b3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(),RemindersActivity.class);
                startActivity(intent);
            }
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