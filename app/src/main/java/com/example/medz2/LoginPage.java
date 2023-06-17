package com.example.medz2;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class LoginPage extends AppCompatActivity {
    private FloatingActionButton b3;
    private Button b2;
    DBHelper DB;
    EditText username,password;
    @SuppressLint({"WrongViewCast", "MissingInflatedId"})
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_page);
        username=findViewById(R.id.username);
        password=findViewById(R.id.password);
        DB = new DBHelper(this);
        b2=findViewById(R.id.button3);
        b3=findViewById(R.id.floatingActionButton3);

        b3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent1=new Intent(LoginPage.this,MainActivity.class);
                startActivity(intent1);
                finish();
            }
        });
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String user = username.getText().toString();
                String pass = password.getText().toString();

                if(user.equals("")||pass.equals(""))
                    Toast.makeText(LoginPage.this, "Please Enter all the details.", Toast.LENGTH_SHORT).show();
                else{
                    Boolean checkusrpass = DB.checkusernamepassword(user,pass);
                    if(checkusrpass==true) {
                        Toast.makeText(LoginPage.this, "Login Successfull", Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent(getApplicationContext(),Bottom_nav.class);
                        startActivity(intent);
                    }
                    else
                        Toast.makeText(LoginPage.this, "Invalid Credentials", Toast.LENGTH_SHORT).show();
                }



            }
        });

    }
    }