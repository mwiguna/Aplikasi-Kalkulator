package com.mwiguna.kuis1;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class SecondVersion extends AppCompatActivity {
    EditText input;
    String tmp;
    Double angka1, angka2, result;
    Integer operation = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.second_version);
        input = (EditText) findViewById(R.id.input);
    }

    public void btnTambah(View v){
        operate(1);
    }
    public void btnKurang(View v){
        operate(2);
    }
    public void btnKali(View v){
        operate(3);
    }
    public void btnBagi(View v){
        operate(4);
    }
    public void btnC(View v){
        input.setText("");
        operation = 0;
    }

    public void operate(int operation){
        this.operation = operation;
        tmp = input.getText().toString();
        if(!tmp.equalsIgnoreCase("")){
            angka1 = Double.parseDouble(tmp);
            input.setText("");
        }
    }

    public void btnEqual(View v){
        tmp = input.getText().toString();
        if(!tmp.equalsIgnoreCase("")){
            angka2 = Double.parseDouble(tmp);

            switch(operation){
                case 1:  result = angka1 + angka2; break;
                case 2:  result = angka1 - angka2; break;
                case 3:  result = angka1 * angka2; break;
                case 4:  result = angka1 / angka2; break;
                default: result = 0.0; break;
            }
            input.setText(result.toString());
        }
    }
}