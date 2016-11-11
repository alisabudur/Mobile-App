package com.example.alisa.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        System.out.print("");
    }

    public void openTravelList(View view){
        Intent intent = new Intent(this, TravelListActivity.class);
        startActivity(intent);
    }

    public void openForm(View view){
        Intent intent = new Intent(this, SendEmailActivity.class);
        startActivity(intent);
    }
}
