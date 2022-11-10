package com.farhad.nesteddropdownlist;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    String[] ConvertType;

    Button btn;
    TextView tv;

    Spinner spinnerType;

    ArrayAdapter typeAdapter;

    EditText ed;

    int selectedIndex = 0;

    double result;

    double valueTemp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn = findViewById(R.id.idBtn);
        tv = findViewById(R.id.idTv);
        ed = findViewById(R.id.idET);

        ed.setText(""+0);
        spinnerType = findViewById(R.id.idSpinnerType);

        ConvertType = getResources().getStringArray(R.array.typeConvert);

        typeAdapter = new ArrayAdapter(
                this,
                android.R.layout.simple_spinner_item,
                ConvertType);

        typeAdapter.setDropDownViewResource(
                android.R.layout
                        .simple_spinner_dropdown_item);

        spinnerType.setAdapter(typeAdapter);

        spinnerType.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {

            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view,
                                       int position, long id) {

                selectedIndex = position;

                if(selectedIndex == 0){
                    tv.setText("°F");
                }else {
                    tv.setText("°C");
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {
                // TODO Auto-generated method stub

            }
        });
    }

    public void onBtnClick(View view) {

        String value = getData();
        Intent in = new Intent(MainActivity.this, DetailsActivity.class);
        in.putExtra("result", value);

        startActivity(in);
    }

    String getData(){


        String text =ed.getText().toString();
        if(!text.isEmpty()){
            try
            {
                valueTemp= 0.0+Double.parseDouble(text);
            } catch (Exception e1) {
                e1.printStackTrace();
            }
        }


        if(selectedIndex == 0){
            result =  (valueTemp - 32.0)*(5.0/9.0);
            return result+" °C";
        }else{
            result = (valueTemp*1.8)+32.0;
            return result+" °F";
        }
    }
}