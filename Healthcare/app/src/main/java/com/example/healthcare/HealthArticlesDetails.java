package com.example.healthcare;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

public class HealthArticlesDetails extends AppCompatActivity {

    TextView tv1;
    ImageView img;
    Button HADBack;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_health_articles_details);

        HADBack=findViewById(R.id.HADbtnBack);
        tv1=findViewById(R.id.textViewHAD);
        img=findViewById(R.id.ImageviewHAD);

        Intent intent=getIntent();
        tv1.setText(intent.getStringExtra("text1"));

        Bundle bundle=getIntent().getExtras();

        if (bundle!=null){
            int reID=bundle.getInt("text2");

       }


    }
}