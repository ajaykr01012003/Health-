package com.example.healthcare;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class LabTestActivityDetails extends AppCompatActivity {

    TextView tvPackageName,tvTotalCost;
    EditText edDetails;

    Button btnAddToCart,btnBack;


    @SuppressLint({"MissingInflatedId", "SetTextI18n"})
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lab_test_details);

        tvPackageName=findViewById(R.id.BMDdetail);
          edDetails=findViewById(R.id.BmdEditText);
          tvTotalCost=findViewById(R.id.bmdTotalCost);
          btnBack=findViewById(R.id.HADbtnBack);
          btnAddToCart=findViewById(R.id.BUYMdicineDetailstbn);

          edDetails.setKeyListener(null);

        Intent intent=getIntent();
        tvPackageName.setText(intent.getStringExtra("text1"));
        edDetails.setText(intent.getStringExtra("text2"));
        tvTotalCost.setText("Total Cost : "+intent.getStringExtra("text3")+"/-");


        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
                finish();
            }
        });





    }
}