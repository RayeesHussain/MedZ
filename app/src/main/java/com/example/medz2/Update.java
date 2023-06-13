package com.example.medz2;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.DialogInterface;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Update extends AppCompatActivity {
    private TextView t_select_start2,t_select_stop2,t_select_time2;
    EditText e_t002,e_start_date2,e_stop_date2,e_time12,pill_name2,pill_type2,no_of_weeks2,form2;
    DBMain dbMain;
    SQLiteDatabase sqLiteDatabase;
    int id=0;
    Button update,delete;
    String pill_id; String pill_name ; String pill_type;String weeks; String form; String start_date; String stop_date; String time;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update);
        //e_t002=findViewById(R.id.t002);
        pill_name2=findViewById(R.id.t12);
        pill_type2=findViewById(R.id.t22);
        no_of_weeks2=findViewById(R.id.t212);
        form2=findViewById(R.id.t32);
        e_start_date2=findViewById(R.id.start_date2);
        e_stop_date2=findViewById(R.id.stop_date2);
        e_time12=findViewById(R.id.time12);
        update=findViewById(R.id.button42);
        delete=findViewById(R.id.button43);
        getIntentData();
        ActionBar ab=getSupportActionBar();
        if(ab!=null) {
            ab.setTitle(pill_name);
        }
        update.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DBMain myDB=new DBMain(Update.this);
                pill_name=pill_name2.getText().toString().trim();
                pill_type=pill_type2.getText().toString().trim();
                weeks=no_of_weeks2.getText().toString().trim();
                form=form2.getText().toString().trim();
                start_date=e_start_date2.getText().toString().trim();
                stop_date=e_stop_date2.getText().toString().trim();
                time=e_time12.getText().toString().trim();



                myDB.updateData(pill_id,pill_name,pill_type,weeks,form,start_date,stop_date,time);

            }
        });
        delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                confirmDialog();


            }
        });


    }
    void getIntentData() {
        if(getIntent().hasExtra("pill_id") && getIntent().hasExtra("pill_name") &&getIntent().hasExtra("pill_type") &&getIntent().hasExtra("weeks")
        && getIntent().hasExtra("form") && getIntent().hasExtra("start_date") && getIntent().hasExtra("stop_date") && getIntent().hasExtra("time")){

            pill_id=getIntent().getStringExtra("pill_id");
            pill_name=getIntent().getStringExtra("pill_name");
            pill_type=getIntent().getStringExtra("pill_type");
            weeks=getIntent().getStringExtra("weeks");
            form=getIntent().getStringExtra("form");
            start_date=getIntent().getStringExtra("start_date");
            stop_date=getIntent().getStringExtra("stop_date");
            time=getIntent().getStringExtra("time");
            //e_t002.setText(pill_id);
            pill_name2.setText(pill_name);
            pill_type2.setText(pill_type);
            no_of_weeks2.setText(weeks);
            form2.setText(form);
            e_start_date2.setText(start_date);
            e_stop_date2.setText(stop_date);
            e_time12.setText(time);


        }else {
            Toast.makeText(this,"no data",Toast.LENGTH_SHORT).show();
        }
    }
    void confirmDialog() {
        AlertDialog.Builder builder=new AlertDialog.Builder(this);
        builder.setTitle("Delete" + this + "?");
        builder.setTitle("are you sure you want to delete" + pill_name + "?");
        builder.setPositiveButton("yes", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                DBMain myDB=new DBMain(Update.this);
                myDB.deleteData(pill_id);
                finish();

            }
        });
        builder.setNegativeButton("No", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {

            }
        });
        builder.create().show();

    }
}