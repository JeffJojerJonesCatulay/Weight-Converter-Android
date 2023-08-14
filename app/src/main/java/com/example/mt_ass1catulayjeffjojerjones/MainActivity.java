package com.example.mt_ass1catulayjeffjojerjones;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private TextView converted;
    private EditText forConversion;
    private RadioButton poundsToKilo;
    private RadioButton kilosToPounds;
    public String resultOutput;
    public TextView fromWeight;
    public TextView toWeight;
    public TextView arrow;
    public Button convertionBTN;
    public RadioGroup choices;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        poundsToKilo = findViewById(R.id.lbToKilo);
        kilosToPounds = findViewById(R.id.kiloTolb);
        converted = findViewById(R.id.outputText);
        forConversion = findViewById(R.id.inputText);
        fromWeight = findViewById(R.id.displayFrom);
        toWeight = findViewById(R.id.displayTo);
        arrow = findViewById(R.id.arrow);
        convertionBTN = findViewById(R.id.convert);

        forConversion.requestFocus();


        poundsToKilo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                fromWeight.setText(getText((R.string.lb)));
                arrow.setText(getText((R.string.before)));
                toWeight.setText(getText((R.string.kilo)));
                converted.setText("");
            }
        });

        kilosToPounds.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                fromWeight.setText(getText((R.string.kilo)));
                arrow.setText(getText((R.string.before)));
                toWeight.setText(getText((R.string.lb)));
                converted.setText("");
            }
        });

        forConversion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                fromWeight.setText("");
                arrow.setText("");
                toWeight.setText("");
            }
        });
    }

    public void convert(View view){
        arrow.setText(getText((R.string.after)));
        double weight = Double.valueOf(forConversion.getText().toString());
        boolean poundToKiloRADIO = poundsToKilo.isChecked();
        boolean kiloToPoundsRADIO = kilosToPounds.isChecked();
        //pounds to kilo
        if (poundToKiloRADIO){
            double pounds = weight;
            double kilogram = pounds / 2.2046;
            resultOutput = String.valueOf(kilogram);
            converted.setText(resultOutput);
        }
        //kilo to pounds
        else if (kiloToPoundsRADIO){
            double kilogram = weight;
            double pounds = kilogram / 0.45359237;
            resultOutput = String.valueOf(pounds);
            converted.setText(resultOutput);
        }
        else {
            forConversion.requestFocus();
        }
    }
}
