package com.farhad.nesteddropdownlist;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {


    String[] divName;
    String[] divDetails;
    String details;
    Button btn;
    TextView tv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn = findViewById(R.id.idBtn);
        tv = findViewById(R.id.idTv);


        Spinner spin = findViewById(R.id.coursesspinner);
        spin.setOnItemSelectedListener(this);

        divName = getResources().getStringArray(R.array.division_name);
        divDetails = getResources().getStringArray(R.array.division_details);

        ArrayAdapter ad
                = new ArrayAdapter(
                this,
                android.R.layout.simple_spinner_item,
                divName);


        ad.setDropDownViewResource(
                android.R.layout
                        .simple_spinner_dropdown_item);

        // Set the ArrayAdapter (ad) data on the
        // Spinner which binds data to spinner
        spin.setAdapter(ad);


        btn.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                tv.setText(details);
            }
        });





    }


    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
//        Toast.makeText(getApplicationContext(),
//                        courses[position],
//                        Toast.LENGTH_LONG)
//                .show();

        details = divDetails[position];

        tv.setText("");


    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}