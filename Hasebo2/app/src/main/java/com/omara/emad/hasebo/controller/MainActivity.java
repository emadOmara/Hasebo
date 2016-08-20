package com.omara.emad.hasebo.controller;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.CheckBox;
import android.widget.Toast;

import com.omara.emad.hasebo.R;
import com.omara.emad.hasebo.business.HaseboBusiness;
import com.omara.emad.hasebo.model.Worship;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Logger;

public class MainActivity extends AppCompatActivity {

    Worship worship;
    private CheckBox fajr;
    private CheckBox zohr;
    private CheckBox asr;
    private CheckBox maghreb;
    private CheckBox eshaa;
    private CheckBox doha;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        String selectedDate = getIntent().getStringExtra("date");

        initializeComponents();
try {
    loadPreviousRecord(selectedDate);
}catch (Throwable e){
    e.printStackTrace();
}
    }

    private void loadPreviousRecord(String selectedDate) {
        worship=  HaseboBusiness.getInstance(this).getWorship(selectedDate);
        worship=worship!=null?worship: new Worship();
        worship.setDate(selectedDate);
        fajr.setChecked(worship.isFajr());
        zohr.setChecked(worship.isZohr());
        asr.setChecked(worship.isAsr());
        maghreb.setChecked(worship.isMaghreb());
        eshaa.setChecked(worship.isEshaa());
        doha.setChecked(worship.isDoha());
    }

    private void initializeComponents() {
        fajr = (CheckBox) findViewById(R.id.fajrCheckBox);
        zohr = (CheckBox) findViewById(R.id.zohrCheckBox);
        asr = (CheckBox) findViewById(R.id.asrCheckBox);
        maghreb = (CheckBox) findViewById(R.id.maghrebCheckBox);
        eshaa = (CheckBox) findViewById(R.id.eshaaCheckBox);
        doha = (CheckBox) findViewById(R.id.dohaCheckBox);
    }

    public void back(View view) {
        Intent intent = new Intent(this, SplashActivity.class);
        startActivity(intent);
        finish();
    }

    public void save(View view) {

        worship.setFajr(fajr.isChecked());
        worship.setZohr(zohr.isChecked());
        worship.setAsr(asr.isChecked());
        worship.setMaghreb(maghreb.isChecked());
        worship.setEshaa(eshaa.isChecked());
        worship.setDoha(doha.isChecked());



       int result= HaseboBusiness.getInstance(this).save(worship);
        if(result>0){
            Toast.makeText(this,"Record updated successfully",Toast.LENGTH_LONG);
            Intent intent=new Intent(this,SplashActivity.class);
            startActivity(intent);
            finish();
        }

    }
}
