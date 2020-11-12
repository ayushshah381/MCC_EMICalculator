package com.example.emicalculator2;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import android.view.View.OnClickListener;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    Button btn;
    EditText pa,rate,duration;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btn = (Button) findViewById(R.id.button2);
        pa = findViewById(R.id.pa);
        rate = findViewById(R.id.rate);
        duration = findViewById(R.id.dur);

        //  EMI=[P*(R*(1+R)^n]/[(1+R)^n-1]
        // Capture button clicks
        btn.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                // / Start NewActivity.class
                String paValue= pa.getText().toString();
                int finalpaValue=Integer.parseInt(paValue);
                String rateValue= rate.getText().toString();
                int rate=Integer.parseInt(rateValue);
                double finalrateValue=(double)(rate)/(double)(1200);
                String durationValue= duration.getText().toString();
                double finaldurationValue=Double.parseDouble(durationValue);
                finaldurationValue=finaldurationValue*12;
                double r = (finalpaValue*finalrateValue);
                double re = Math.pow((double)(1+finalrateValue),(double)finaldurationValue);
                double re1 = (Math.pow((double)(1+finalrateValue),(double)(finaldurationValue-1)));
                double result = (r*re)/re1;
                double r1=(finalpaValue*finalrateValue*finaldurationValue)/100;

                Toast.makeText(MainActivity.this, "EMI COST " + result, Toast.LENGTH_SHORT).show();

            }});
    }
}

