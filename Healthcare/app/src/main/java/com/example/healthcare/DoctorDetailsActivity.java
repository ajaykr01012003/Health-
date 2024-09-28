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
import android.widget.TextView;

import java.util.ArrayList;
import java.util.HashMap;

public class DoctorDetailsActivity extends AppCompatActivity {

    private String[][] doctorDetails1={
            {"Doctor Name : Ajit Saste","Hospital Address : Pimpari"," Exp : 5years"," Moibible No : 9894589898","600"},
            {"Doctor Name : Pappu Saste","Hospital Address : Banaur"," Exp : 3years"," Moibible No : 98989895898","600"},
            {"Doctor Name : Nagendra singh Saste","Hospital Address : Madhura"," Exp : 5years"," Moibible No : 9898989898","600"},
            {"Doctor Name : vijay Saste","Hospital Address : Pimpari"," Exp : 2years"," Moibible No : 98989898546598","600"},
            {"Doctor Name : vinay Saste","Hospital Address : meraj"," Exp : 1years"," Moibible No : 9898989898","600"},
    };

    private String[][] doctorDetails2={
            {"Doctor Name : nilam Saste","Hospital Address : Pimpari"," Exp : 5years"," Moibible No : 9894589898","600"},
            {"Doctor Name : Pappu Saste","Hospital Address : Banaur"," Exp : 3years"," Moibible No : 98989895898","600"},
            {"Doctor Name : pimpari singh Saste","Hospital Address : Madhura"," Exp : 5years"," Moibible No : 9898989898","600"},
            {"Doctor Name : vijay Saste","Hospital Address : Pimpari"," Exp : 2years"," Moibible No : 98989898546598","600"},
            {"Doctor Name : vaisali Saste","Hospital Address : meraj"," Exp : 1years"," Moibible No : 9898989898","600"},
    };
    private String[][] doctorDetails3={
            {"Doctor Name : amarit Saste","Hospital Address : Pimpari"," Exp : 5years"," Moibible No : 9894589898","600"},
            {"Doctor Name : saluki Saste","Hospital Address : Banaur"," Exp : 3years"," Moibible No : 98989895898","600"},
            {"Doctor Name : Nagendra singh Saste","Hospital Address : Madhura"," Exp : 5years"," Moibible No : 9898989898","600"},
            {"Doctor Name : narmada Saste","Hospital Address : Pimpari"," Exp : 2years"," Moibible No : 98989898546598","600"},
            {"Doctor Name : vinay Saste","Hospital Address : meraj"," Exp : 1years"," Moibible No : 9898989898","600"},
    };
    private String[][] doctorDetails4={
            {"Doctor Name : bhagwan yadav","Hospital Address : Pimpari"," Exp : 5years"," Moibible No : 9894589898","600"},
            {"Doctor Name : Pappu sahu","Hospital Address : Banaur"," Exp : 3years"," Moibible No : 98989895898","600"},
            {"Doctor Name : Nagendra singh Saste","Hospital Address : Madhura"," Exp : 5years"," Moibible No : 9898989898","600"},
            {"Doctor Name : vijay Saste","Hospital Address : Pimpari"," Exp : 2years"," Moibible No : 98989898546598","600"},
            {"Doctor Name : vinay gupta","Hospital Address : meraj"," Exp : 1years"," Moibible No : 9898989898","600"},
    };
    private String[][] doctorDetails5={
            {"Doctor Name : vikash Saste","Hospital Address : Pimpari"," Exp : 5years"," Moibible No : 9894589898","600"},
            {"Doctor Name : Pappu fulmender","Hospital Address : Banaur"," Exp : 3years"," Moibible No : 98989895898","600"},
            {"Doctor Name : Nagendra singh Saste","Hospital Address : Madhura"," Exp : 5years"," Moibible No : 9898989898","600"},
            {"Doctor Name : tonny Saste","Hospital Address : Pimpari"," Exp : 2years"," Moibible No : 98989898546598","600"},
            {"Doctor Name : moni Saste","Hospital Address : meraj"," Exp : 1years"," Moibible No : 9898989898","600"},
    };

    String[][]doctorDetails={};

    ArrayList list;
    SimpleAdapter sa;

    HashMap<String,String>item;




    TextView tv;
     Button btn;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_doctor_details);

        tv=findViewById(R.id.textViwODDTitle);
        btn=findViewById(R.id.ODback);


        Intent it=getIntent();
        String title=it.getStringExtra("title");
        tv.setText(title);

       if (title.compareTo("Family physisian")==0){
           doctorDetails=doctorDetails1;
       } else if (title.compareTo("dietesian")==0) {
           doctorDetails=doctorDetails2;
       } else if (title.compareTo("dentists")==0) {
           doctorDetails=doctorDetails3;
       } else if (title.compareTo("surgeon")==0) {
           doctorDetails=doctorDetails4;
       }else {
           doctorDetails=doctorDetails5;
       }


        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), DoctorDetailsActivity.class));
            }
        });

       list=new ArrayList<>();
       for (int i=0; i<doctorDetails.length; i++){
           item=new HashMap<String,String>();
           item.put("line1",doctorDetails[i][0]);
           item.put("line2",doctorDetails[i][1]);
           item.put("line3",doctorDetails[i][2]);
           item.put("line4",doctorDetails[i][3]);
           item.put("line5","cons Fees"+doctorDetails[i][4]+"/-");
           list.add(item);
       }
       sa=new SimpleAdapter(this,list,R.layout.multi_lines,new String[]{
               "line1","line2","line3","line4","line5"
       },new int[]{R.id.line_a,R.id.line_b,R.id.line_c,R.id.line_d,R.id.line_e});

        ListView lst=findViewById(R.  id.ListOd);
        lst.setAdapter(sa);

        lst.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int i, long id) {
                Intent it=new Intent(getApplicationContext(), BookAppointmentActivity.class);
                it.putExtra("text1",title);
                it.putExtra("text2",doctorDetails[i][0]);
                it.putExtra("text3",doctorDetails[i][1]);
                it.putExtra("text4",doctorDetails[i][2]);
                it.putExtra("text5",doctorDetails[i][4]);

                startActivity(it);

            }
        });
    }
}