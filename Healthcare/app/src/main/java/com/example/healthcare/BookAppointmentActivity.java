package com.example.healthcare;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.app.AlertDialog;
import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.TimePicker;

import java.util.Calendar;

public class BookAppointmentActivity extends AppCompatActivity {

    EditText ed1, ed2,ed3,ed4;
    TextView tv;

    private DatePickerDialog datePickerDialog;
    private TimePickerDialog timePickerDialog;
    private Button dateButton, timeButton, btnBook, btnBack;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_book_appointment);
        tv=findViewById(R.id.textViewAppTitle);
        ed1=findViewById(R.id.editTextUsername);
        ed2=findViewById(R.id.editTextAddress);
        ed3=findViewById(R.id.editTextContactNumber);
        ed4=findViewById(R.id.Fees);
        dateButton=findViewById(R.id.buttonAppDate);
        timeButton=findViewById(R.id.buttonAppTime);
        btnBook=findViewById(R.id.buttonBootAppointment);
        btnBack=findViewById(R.id.buttonAppBack);


        ed1.setKeyListener(null);
        ed2.setKeyListener(null);
        ed3.setKeyListener(null);
        ed4.setKeyListener(null);


        Intent it=getIntent();
        String title=it.getStringExtra("text1");
        String fullName=it.getStringExtra("text2");
        String Address=it.getStringExtra("text3");
        String contact=it.getStringExtra("text4");
        String fees=it.getStringExtra("text5");



        tv.setText(title);
        ed1.setText(fullName);
        ed2.setText(Address);
        ed3.setText(contact);
        ed4.setText("Cons fees: "+fees+"/-");


      initTimePicker();
      initDatePicker();

      dateButton.setOnClickListener(new View.OnClickListener() {
          @Override
          public void onClick(View v) {
              datePickerDialog.show();
          }
      });

      timeButton.setOnClickListener(new View.OnClickListener() {
          @Override
          public void onClick(View v) {
              timePickerDialog.show();
          }
      });

      btnBack.setOnClickListener(new View.OnClickListener() {
          @Override
          public void onClick(View v) {
             // startActivity(new Intent(getApplicationContext(), FindDoctorActivity.class));
              onBackPressed();
          }
      });

      btnBook.setOnClickListener(new View.OnClickListener() {
          @Override
          public void onClick(View v) {

          }
      });


    }

    private void initDatePicker(){
        DatePickerDialog.OnDateSetListener dateSetListener=new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int i, int i1, int i2) {
                i1+=1;
                dateButton.setText(i2+"/"+i1+"/"+i2);
            }
        };
        Calendar cal=Calendar.getInstance();
        int year=cal.get(Calendar.YEAR);
        int month=cal.get(Calendar.MONTH);
        int day=cal.get(Calendar.DAY_OF_MONTH);
        int style= AlertDialog.THEME_HOLO_DARK;

        datePickerDialog= new DatePickerDialog(this,style,dateSetListener,year,month,day);
        datePickerDialog.getDatePicker().setMinDate(cal.getTimeInMillis()+86400000);



    }


    private void initTimePicker(){
        TimePickerDialog.OnTimeSetListener timeSetListener=new TimePickerDialog.OnTimeSetListener() {
            @Override
            public void onTimeSet(TimePicker view, int i, int i1) {

                timeButton.setText(i+":"+i1);

            }
        };

        Calendar cal=Calendar.getInstance();
        int hrs=cal.get(Calendar.HOUR);
        int mins=cal.get(Calendar.MINUTE);
        int style=AlertDialog.THEME_HOLO_DARK;
        timePickerDialog= new TimePickerDialog(this,style,timeSetListener,hrs,mins,true);

    }
}