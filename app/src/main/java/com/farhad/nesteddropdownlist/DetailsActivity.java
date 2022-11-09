package com.farhad.nesteddropdownlist;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class DetailsActivity extends AppCompatActivity {


    String divName, disName;

    TextView divTv, disTv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);

        divName = getIntent().getStringExtra("div");
        disName = getIntent().getStringExtra("dis");

        disTv = findViewById(R.id.idDis);
        divTv = findViewById(R.id.idDiv);

        divTv.setText(divName+"\n");
        disTv.setText(disName);

    }
}