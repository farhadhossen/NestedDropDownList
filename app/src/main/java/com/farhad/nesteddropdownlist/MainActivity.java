package com.farhad.nesteddropdownlist;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    String[] divName;
    String[] disName;
    String divDetails="", disDetails="";
    Button btn;
    TextView tv;

    Spinner spinnerDiv, spinnerDis;

    ArrayAdapter divAdapter, disAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn = findViewById(R.id.idBtn);
        tv = findViewById(R.id.idTv);


        spinnerDiv = findViewById(R.id.idSpinnerDiv);
        spinnerDis = findViewById(R.id.idSpinnerDis);


        divName = getResources().getStringArray(R.array.division_name);



        divAdapter = new ArrayAdapter(
                this,
                android.R.layout.simple_spinner_item,
                divName);

        divAdapter.setDropDownViewResource(
                android.R.layout
                        .simple_spinner_dropdown_item);


        spinnerDiv.setAdapter(divAdapter);




        spinnerDiv.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {

            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view,
                                       int position, long id) {
                Object item = adapterView.getItemAtPosition(position);

                divDetails = item.toString();


                if (item != null) {



                    switch (position){
                        case 0:
                            disName = getResources().getStringArray(R.array.dhaka_items);
                            break;
                        case 1:
                            disName = getResources().getStringArray(R.array.chottogram_items);
                            break;
                        case 2:
                            disName = getResources().getStringArray(R.array.rajshahi_items);
                            break;
                        case 3:
                            disName = getResources().getStringArray(R.array.khulna_items);
                            break;
                        case 4:
                            disName = getResources().getStringArray(R.array.barishal_items);
                            break;
                        case 5:
                            disName = getResources().getStringArray(R.array.sylhet_items);
                            break;
                        case 6:
                            disName = getResources().getStringArray(R.array.rongpur_items);
                            break;
                        case 7:
                            disName = getResources().getStringArray(R.array.moymonshing_items);
                            break;
                        default:
                            disName = getResources().getStringArray(R.array.dhaka_items);
                            break;

                    }


                    disAdapter = new ArrayAdapter(MainActivity.this,
                            android.R.layout.simple_spinner_item,
                            disName);




                    disAdapter.setDropDownViewResource(
                            android.R.layout
                                    .simple_spinner_dropdown_item);
                    spinnerDis.setAdapter(disAdapter);


                }


            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {
                // TODO Auto-generated method stub

            }
        });

        spinnerDis.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {

            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view,
                                       int position, long id) {
                Object item = adapterView.getItemAtPosition(position);
                if (item != null) {

                    disDetails = item.toString();


                }


            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {
                // TODO Auto-generated method stub

            }
        });


//        btn.setOnClickListener(new View.OnClickListener() {
//            public void onClick(View v) {
//                tv.setText(divDetails);
//
//                Intent in = new Intent(MainActivity.this, DetailsActivity.class);
//                in.putExtra("div", divDetails);
//                in.putExtra("dis", disDetails);
//                startActivity(in);
//            }
//        });




    }

    public void onBtnClick(View view) {
        Intent in = new Intent(MainActivity.this, DetailsActivity.class);
        in.putExtra("div", divDetails);
        in.putExtra("dis", disDetails);
        startActivity(in);
    }
}