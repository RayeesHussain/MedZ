package com.example.medz2;

import static com.example.medz2.DBMain.TABLENAME;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;

public class ViewScreen extends AppCompatActivity {
DBMain dbMain;
    private FloatingActionButton b3;
    ArrayList<String> pill_id,pill_name,pill_type,weeks,form,start_date,stop_date,time;
SQLiteDatabase sqLiteDatabase;
RecyclerView recyclerView;
MyAdapter myAdapter;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_screen);
        b3=findViewById(R.id.back_button);
        recyclerView=findViewById(R.id.recyclerView);
        b3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent1=new Intent(ViewScreen.this,Act3.class);
                startActivity(intent1);
                finish();
            }
        });

        dbMain=new DBMain(ViewScreen.this);
        pill_id=new ArrayList<>();
        pill_name=new ArrayList<>();
        pill_type=new ArrayList<>();
        weeks=new ArrayList<>();
        form=new ArrayList<>();
        start_date=new ArrayList<>();
        stop_date=new ArrayList<>();
        time=new ArrayList<>();

        storedata();
        myAdapter=new MyAdapter(ViewScreen.this,this,pill_id,pill_name,pill_type,weeks,form,start_date,stop_date,time);
        recyclerView.setAdapter(myAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(ViewScreen.this));
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode==1){
            recreate();


        }
    }

    private void storedata() {
       /* sqLiteDatabase=dbMain.getReadableDatabase();
        Cursor cursor=sqLiteDatabase.rawQuery("select * from "+TABLENAME+"",null);
        ArrayList<Model>models=new ArrayList<>();
        while(cursor.moveToNext()){
            String id=cursor.getString(0);
            String pill_name1=cursor.getString(1);
//            String pil_type1=cursor.getString(2);
//            String no_weeks1=cursor.getString(3);
//            String form1=cursor.getString(4);
//            String start1=cursor.getString(5);
//            String stop1=cursor.getString(6);
//            String time=cursor.getString(7)
            models.add(new Model(id,pill_name1));

        }
        cursor.close();
        myAdapter=new MyAdapter(this,models,sqLiteDatabase,R.layout.single_data);
        recyclerView.setAdapter(myAdapter);
    */
        Cursor cursor=dbMain.readAllData();
        if(cursor.getCount()==0) {
            Toast.makeText(this,"no data", Toast.LENGTH_LONG).show();
        }
        else{
            while(cursor.moveToNext()){
                 pill_id.add(cursor.getString(0));
                pill_name.add(cursor.getString(1));
           pill_type.add(cursor.getString(2));
           weeks.add(cursor.getString(3));
          form.add(cursor.getString(4));
            start_date.add(cursor.getString(5));
          stop_date.add(cursor.getString(6));
          time.add(cursor.getString(7));
            }
        }
    }
}