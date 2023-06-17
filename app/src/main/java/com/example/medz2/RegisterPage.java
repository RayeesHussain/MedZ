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

public class RegisterPage extends AppCompatActivity {
    DBHelper DB=new DBHelper(this);
    private Button b3;
    private FloatingActionButton b2;
    EditText userName,password,repassword;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register_page);
        b3=findViewById(R.id.button4);
        userName=findViewById(R.id.usernames);
        password=findViewById(R.id.password1);
        repassword=findViewById(R.id.password2);
        b2=findViewById(R.id.floatingActionButton);
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent1 = new Intent(RegisterPage.this, MainActivity.class);
                startActivity(intent1);
                finish();
            }

        });

        b3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String users = userName.getText().toString();
                String passs = password.getText().toString();
                String repass = repassword.getText().toString();
                if (users.equals("") || passs.equals("")) {
                    Toast.makeText(RegisterPage.this, "Please Enter all the details.", Toast.LENGTH_SHORT).show();
                }
                else {
                    if(passs.equals(repass)) {
                        Boolean checkuser = DB.checkusername(users);
                        if (checkuser == false) {
                            Boolean insert = DB.insertData(users, passs);
                            if (insert == true) {
                                Toast.makeText(RegisterPage.this, "Signup Successfully!", Toast.LENGTH_SHORT).show();
                                Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                                startActivity(intent);
                            } else {
                                Toast.makeText(RegisterPage.this, "Signup Failed!", Toast.LENGTH_SHORT).show();
                            }
                        } else {
                            Toast.makeText(RegisterPage.this, "User already exists! Please login", Toast.LENGTH_SHORT).show();
                        }
                    }
                    else{
                        Toast.makeText(RegisterPage.this, "Invalid Password!", Toast.LENGTH_SHORT).show();
                    }
                }
            }

        });

    }


}