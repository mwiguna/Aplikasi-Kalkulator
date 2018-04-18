package com.mwiguna.kuis1;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    TextView hasil;
    EditText num1, num2;
    String tmp1, tmp2;
    Double angka1, angka2, result;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void btnTambah(View v){
        result(1);
    }

    public void btnKurang(View v){
        result(2);
    }

    public void btnKali(View v){
        result(3);
    }

    public void btnBagi(View v){
        result(4);
    }

    public void result(int operate){
        num1   = (EditText) findViewById(R.id.num1);
        num2   = (EditText) findViewById(R.id.num2);
        tmp1   = num1.getText().toString();
        tmp2   = num2.getText().toString();
        hasil  = (TextView) findViewById(R.id.hasil);

        if(tmp1.equalsIgnoreCase("") || tmp2.equalsIgnoreCase("")) hasil.setText("0");
        else {
            angka1 = Double.parseDouble(tmp1);
            angka2 = Double.parseDouble(tmp2);

            switch(operate){
                case 1 : result = angka1 + angka2; break;
                case 2 : result = angka1 - angka2; break;
                case 3 : result = angka1 * angka2; break;
                default: result = angka1 / angka2; break;
            }

            hasil.setText(result.toString());
        }
    }

    public void next(View v){
        Intent intent = new Intent("com.mwiguna.kuis1.SecondVersion");
        startActivity(intent);
    }

    public void finalCalc(View v){
        Intent intent = new Intent("com.mwiguna.kuis1.ThirdVersion");
        startActivity(intent);
    }
}