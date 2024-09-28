package com.example.healthcare;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import java.util.ArrayList;
import java.util.HashMap;

public class HealthArticleActivity extends AppCompatActivity {

    private String[][] health_Details={
        {"Walking Daily "," "," ", " ", "click more Details"},
        {"Home care of the Covid-19","","","","Click More Details"},
        {"Home Smocking","","","",""," click more details"},
        {"Home Smocking","","","",""," click more details"},
        {"Home Smocking","","","",""," click more details"} };

    private int[]images={R.drawable.health1,R.drawable.health2,
                         R.drawable.health3, R.drawable.health4,R.drawable.health5};



        HashMap<String,String>item;
        ArrayList list;
        SimpleAdapter sa;
        ListView listView;
   Button btnHAback;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_health_article);
        btnHAback=findViewById(R.id.HADbtnBack);
        listView=findViewById(R.id.ImageviewHAD);
        btnHAback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });

        list=new ArrayList<>();
        for (int i=0; i<health_Details.length; i++){
            item=new HashMap<String,String>();
            item.put("line1",health_Details[i][0]);
            item.put("line2",health_Details[i][1]);
            item.put("line3",health_Details[i][2]);
            item.put("line4",health_Details[i][3]);
            item.put("line5","cons Fees"+health_Details[i][4]+"/-");
            list.add(item);
        }
        sa = new SimpleAdapter(this, list, R.layout.multi_lines,
                new String[]{"line1", "line2", "line3", "line4", "line5"},
                new int[]{R.id.line_a, R.id.line_b, R.id.line_c, R.id.line_d, R.id.line_e});
        listView.setAdapter(sa);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int i, long id) {
                Intent it=new Intent(getApplicationContext(), HealthArticlesDetails.class);
                it.putExtra("text1",health_Details[i][0]);
                it.putExtra("text2",images[i]);
                startActivity(it);
            }
        });
    }
}