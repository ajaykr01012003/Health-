package com.example.healthcare;


import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.HashMap;

public class LabTestActivity extends AppCompatActivity {

    private String[][] packages = {
            {"Package 1 : Full body Checkup", "", "", "999"},
            {"Package 1 : Full body Checkup", "", "", "999"},
            {"Package 2 : Blood Glucose Fasting", "", "", "299"},
            {"Package 3 : covid19 Antibody", "", "", "899"},
            {"Package 4 : Thyroid body Checkup", "", "", "999"},
            {"Package 5 : Immunity check", "", "", "999"},
    };

    private String[] package_Details={
            "Blood Glucose Fasting\n"+"Complete Hemogram\n"+
                    "HBAlc\n"+
                    "Iron Studies\n"+
                    "Kindly Function Test\n"+
                    "LDH Lactate /Dehydrogegenase, Serum\n"
                    +"Lipid Profile\n"+
                    "Liver Function Test",
            "Blood Glucose Fasting",
            "Blood Glucose", "Lipid Profille","  "
    };

    HashMap<String, String> item;
    ArrayList<HashMap<String, String>> list;
    SimpleAdapter sa;

    Button btnGotoCart, btnBack;
    ListView listView;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lab_test);

        btnGotoCart = findViewById(R.id.btngotoCartBM);
        btnBack = findViewById(R.id.HADbtnBack);
        listView = findViewById(R.id.listviewBM);

        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });

        list = new ArrayList<>();

        for (String[] aPackage : packages) {
            item = new HashMap<>(); // Initialize item HashMap inside the loop

            item.put("line1", aPackage[0]);
            item.put("line2", aPackage[1]);
            item.put("line3", aPackage[2]);
            item.put("line4", aPackage[3]);
            item.put("line5", "Total cost " + aPackage[3] + "/-"); // Adjusted array index

            list.add(item);
        }

        sa = new SimpleAdapter(this, list, R.layout.multi_lines,
                new String[]{"line1", "line2", "line3", "line4", "line5"},
                new int[]{R.id.line_a, R.id.line_b, R.id.line_c, R.id.line_d, R.id.line_e});
        listView.setAdapter(sa);


        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int i, long id) {
                Intent it=new Intent(getApplicationContext(), LabTestActivityDetails.class);
                it.putExtra("text1",packages[i][0]);
                it.putExtra("text2",package_Details[i]);
                it.putExtra("text3",packages[i][4]);
                startActivity(it);
            }
        });
    }
}
