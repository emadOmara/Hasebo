package com.omara.emad.hasebo.controller;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CalendarView;
import android.widget.TextView;

import com.omara.emad.hasebo.R;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

public class DateSelectionActivity extends AppCompatActivity {
    private CalendarView calendarView;
    private TextView dateTextView;
    private Date selectedDate;
    private static SimpleDateFormat df=new SimpleDateFormat("yyyy-MM-dd");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_date_selection);

        dateTextView = (TextView) findViewById(R.id.dateTextView);
        calendarView = (CalendarView) findViewById(R.id.calendarView);
        selectedDate=Calendar.getInstance().getTime();
        calendarView.setOnDateChangeListener(new CalendarView.OnDateChangeListener() {
            @Override
            public void onSelectedDayChange(CalendarView view, int year, int month, int dayOfMonth) {
                Calendar calendar=Calendar.getInstance(Locale.getDefault());
                calendar.set(Calendar.YEAR,year);
                calendar.set(Calendar.MONTH,month);
                calendar.set(Calendar.DATE,dayOfMonth);

                selectedDate = calendar.getTime();
            }
        });

    }

    public void selectDate(View view) {
        long date = calendarView.getDate();
        dateTextView.setText("Selected Date :" + df.format(selectedDate));
        Intent intent=new Intent(this,MainActivity.class);
        intent.putExtra("date",df.format(selectedDate));
        startActivity(intent);
        finish();
    }


}
