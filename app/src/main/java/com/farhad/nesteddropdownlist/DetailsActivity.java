package com.farhad.nesteddropdownlist;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class DetailsActivity extends AppCompatActivity {


    String result;

    TextView tv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);

        result = getIntent().getStringExtra("result");


        tv = findViewById(R.id.idTv);

        tv.setText(result+"\n");


    }
}