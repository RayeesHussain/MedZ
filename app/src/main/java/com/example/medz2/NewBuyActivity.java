package com.example.medz2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class NewBuyActivity extends AppCompatActivity {

    // creating a variables for our button and edittext.
    private EditText pillNameEdt,pillQuanEdt;
    private Button courseBtn;

    // creating a constant string variable for our
    // course name, description and duration.
    public static final String EXTRA_ID = "com.example.medz2.EXTRA_ID";
    public static final String EXTRA_PILL_NAME = "com.example.medz2.EXTRA_PILL_NAME";
    public static final String EXTRA_PILL_QUANTITY = "com.example.medz2.EXTRA_PILL_QUANTITY";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_buy);

        // initializing our variables for each view.
        pillNameEdt = findViewById(R.id.idEdtPillName);
        pillQuanEdt = findViewById(R.id.idEdtPillQuantity);

        courseBtn = findViewById(R.id.idBtnSaveCourse);

        // below line is to get intent as we
        // are getting data via an intent.
        Intent intent = getIntent();
        if (intent.hasExtra(EXTRA_ID)) {
            // if we get id for our data then we are
            // setting values to our edit text fields.
            pillNameEdt.setText(intent.getStringExtra(EXTRA_PILL_NAME));
            pillQuanEdt.setText(intent.getStringExtra(EXTRA_PILL_QUANTITY));

        }
        // adding on click listener for our save button.
        courseBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // getting text value from edittext and validating if
                // the text fields are empty or not.
                String pillName = pillNameEdt.getText().toString();
                String pillQuantity = pillQuanEdt.getText().toString();
                if (pillName.isEmpty() || pillQuantity.isEmpty() ) {
                    Toast.makeText(NewBuyActivity.this, "Please enter the valid course details.", Toast.LENGTH_SHORT).show();
                    return;
                }
                // calling a method to save our course.
                saveCourse(pillName, pillQuantity);
//                pillNameEdt.setText("");
//                pillQuanEdt.setText("");
 //               Intent intent1=new Intent(NewBuyActivity.this,BuyScreen.class);
    //           startActivity(intent1);
                finish();
            }
        });
    }

    private void saveCourse(String pillName, String pillQuantity) {
        // inside this method we are passing
        // all the data via an intent.
        Intent data = new Intent();

        // in below line we are passing all our course detail.
        data.putExtra(EXTRA_PILL_NAME, pillName);
        data.putExtra(EXTRA_PILL_QUANTITY, pillQuantity);

        int id = getIntent().getIntExtra(EXTRA_ID, -1);
        if (id != -1) {
            // in below line we are passing our id.
            data.putExtra(EXTRA_ID, id);
        }

        // at last we are setting result as data.
        setResult(RESULT_OK, data);

        // displaying a toast message after adding the data
        Toast.makeText(this, "Course has been saved to Room Database. ", Toast.LENGTH_SHORT).show();
    }
}
