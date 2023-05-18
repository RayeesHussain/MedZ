package com.example.medz2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;

import com.example.medz2.LoginPage;
import com.example.medz2.R;

//<a href="https://www.flaticon.com/free-icons/medicine" title="medicine icons">Edit icons created by Pixel perfect - Flaticon</a>
public class MainActivity extends AppCompatActivity {
    private Button move1,move2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        move1=findViewById(R.id.button);
        move1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent1=new Intent(MainActivity.this, LoginPage.class);
                startActivity(intent1);
                finish();
            }
        });
        move2=findViewById(R.id.button2);
        move2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent2=new Intent(MainActivity.this,RegisterPage.class);
                startActivity(intent2);
                finish();
            }
        });
    }

}