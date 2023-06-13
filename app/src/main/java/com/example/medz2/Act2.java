package com.example.medz2;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.TimePicker;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class Act2 extends AppCompatActivity {
    private  TextView t_select_start,t_select_stop,t_select_time;
     EditText e_t0,e_start_date,e_stop_date,e_time1,pill_name,pill_type,no_of_weeks,form;
    DBMain dbMain;
    SQLiteDatabase sqLiteDatabase;
    int id=0;
    Button done,display,edit;




    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_act2);
        done=(Button)findViewById(R.id.button4);
        e_t0=(EditText)findViewById(R.id.t0);
        pill_name=(EditText)findViewById(R.id.t1);
        pill_type=(EditText)findViewById(R.id.t2);
        no_of_weeks=(EditText)findViewById(R.id.t21);
        form=(EditText)findViewById(R.id.t3);
        e_start_date=(EditText)findViewById(R.id.start_date) ;
        e_stop_date=(EditText)findViewById(R.id.stop_date1) ;
        e_time1=(EditText)findViewById(R.id.time1) ;

        BottomNavigationView bottomNavigationView = findViewById(R.id.bottomNavigation);
                bottomNavigationView.setSelectedItemId(R.id.add);
                bottomNavigationView.setOnItemSelectedListener(item -> {
                    switch (item.getItemId()) {
                        case R.id.bottom_home:
                            startActivity(new Intent(getApplicationContext(), Bottom_nav.class));
                            overridePendingTransition(R.anim.slide_in, R.anim.slide_out);
                            finish();
                            return true;
                        case R.id.add:
                            return true;
                        case R.id.more:
                            startActivity(new Intent(getApplicationContext(), Act3.class));
                            overridePendingTransition(R.anim.slide_in, R.anim.slide_out);
                            finish();
                            return true;

                    }
                    return true;
                });
        t_select_start=findViewById(R.id.select_start);
        t_select_stop=findViewById(R.id.select_stop);
        e_start_date=findViewById(R.id.start_date);
        e_stop_date=findViewById(R.id.stop_date1);
        t_select_time=findViewById(R.id.select_time);
        e_time1=findViewById(R.id.time1);

        final Calendar calendar=Calendar.getInstance();
        final int year=calendar.get(Calendar.YEAR);
        final int month=calendar.get(Calendar.MONTH);
        final int day=calendar.get(Calendar.DAY_OF_MONTH);

               /* t_select_start.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        DatePickerDialog dialog = new DatePickerDialog(Act2.this, new DatePickerDialog.OnDateSetListener() {
                            @Override
                            public void onDateSet(DatePicker datePicker, int i, int i1, int i2) {
                                i1 = i1 + 1;
                                String date = i2 + "/" + i1 + "/" + i;
                                t_select_start.setText(date);


                            }
                        }, year, month, day);
                        dialog.show();

                    }
                });*/
                e_start_date.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        DatePickerDialog dialog = new DatePickerDialog(Act2.this, new DatePickerDialog.OnDateSetListener() {
                            @Override
                            public void onDateSet(DatePicker datePicker, int i, int i1, int i2) {
                                i1 = i1 + 1;
                                String date = i2 + "/" + i1 + "/" + i;
                                e_start_date.setText(date);


                            }
                        }, year, month, day);
                        dialog.show();

                    }
                });
        t_select_stop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DatePickerDialog dialog = new DatePickerDialog(Act2.this, new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker datePicker, int i, int i1, int i2) {
                        i1 = i1 + 1;
                        String date = i2 + "/" + i1 + "/" + i;
                        t_select_stop.setText(date);


                    }
                }, year, month, day);
                dialog.show();

            }
        });
        e_stop_date.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DatePickerDialog dialog = new DatePickerDialog(Act2.this, new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker datePicker, int i, int i1, int i2) {
                        i1 = i1 + 1;
                        String date = i2 + "/" + i1 + "/" + i;
                        e_stop_date.setText(date);


                    }
                }, year, month, day);
                dialog.show();

            }
        });
        t_select_time.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                TimePickerDialog timePickerDialog=new TimePickerDialog(Act2.this, new TimePickerDialog.OnTimeSetListener() {
                    @Override
                    public void onTimeSet(TimePicker timePicker, int i, int i1) {
                        Calendar calendar1=Calendar.getInstance();
                        calendar1.set(0,0,0,i,i1);
                        SimpleDateFormat sdf=new SimpleDateFormat("hh:mm aa");
                        e_time1.setText(sdf.format(calendar1.getTime()));

                    }
                },12,0,false);
                timePickerDialog.show();

            }
        });
        done.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DBMain mydb=new DBMain(Act2.this);
                //e_t0,e_start_date,e_stop_date,e_time1,pill_name,pill_type,no_of_weeks,form;
                mydb.add(e_t0.getText().toString().trim(),
                        pill_name.getText().toString().trim(),
                        pill_type.getText().toString().trim(),
                        no_of_weeks.getText().toString().trim(),
                        form.getText().toString().trim(),
                        e_start_date.getText().toString().trim(),
                        e_stop_date.getText().toString().trim(),
                        e_time1.getText().toString().trim());
                e_t0.setText("");
                pill_name.setText("");
                pill_type.setText("");
                no_of_weeks.setText("");
                form.setText("");
                e_start_date.setText("");
                e_stop_date.setText("");
                e_time1.setText("");



            }

        });




            }

}