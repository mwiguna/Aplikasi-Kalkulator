package com.mwiguna.kuis1;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class ThirdVersion extends AppCompatActivity {
    TextView input;
    String val;
    Integer operation;
    String tmp = "0";
    List<String> angka     = new ArrayList<>();
    List<Integer> operator = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.third_version);
        input = (TextView)findViewById(R.id.input);
    }

    public void btnNum(View v){
        Button  btn = (Button)v;
        Integer num = Integer.parseInt(btn.getText().toString());
        val = input.getText().toString();

        if(num.equals(0)){
            if(!val.equals("0") && !tmp.equals("0")){ val += 0; tmp += 0; }
        } else {
            if (val.equals("0")){ val = tmp = num.toString(); }
            else { val += num; tmp += num; }
        }
        input.setText(val);
    }

    public void comma(View v){
        if(!tmp.equals("") && !tmp.contains(".")){
            val = input.getText().toString();
            val += ".";
            tmp += ".";
            input.setText(val);
        }
    }

    public void operate(View v){
        if(!tmp.equals("")) {
            Button btn     = (Button)v;
            String operate = btn.getText().toString();

            switch (operate){
                case "+": operation = 1; break;
                case "-": operation = 2; break;
                case "x": operation = 3; break;
                default : operation = 4; break;
            }

            val += operate;
            angka.add(tmp);
            operator.add(operation);
            input.setText(val);
            tmp = "";
        }
    }

    public void equal(View v){
        if(!tmp.equals("")) angka.add(tmp);
        if(operator.size() >= angka.size()) operator.remove(operator.size() - 1);

        Double num1, num2, num;
        Double tmp = 0.0;
        int i = 0;
        while(operator.size() > i){
            num1 = Double.parseDouble(angka.get(i));
            num2 = Double.parseDouble(angka.get(i+1));

            if(operator.get(i).equals(3) || operator.get(i).equals(4)){
                if(operator.get(i).equals(3)) tmp += (num1 * num2);
                else tmp += (num1 / num2);
                angka.set(i, tmp.toString());
                operator.remove(i);
                angka.remove(i+1);
            }

            tmp = 0.0;
            i++;
        }

        i   = 0;
        tmp = Double.parseDouble(angka.get(0));
        boolean first = true;
        while(operator.size() > i) {
            if(first){
                tmp   = Double.parseDouble(angka.get(i));
                first = false;
            }   num   = Double.parseDouble(angka.get(i+1));

            if (operator.get(i) == 1) tmp += num;
            else tmp -= num;
            i++;
        }

        if(tmp % 1 == 0){
            Integer tmpInt = tmp.intValue();
            this.tmp       = tmpInt.toString();
        } else this.tmp    = tmp.toString();

        val = this.tmp;
        input.setText(val);

        angka.clear();
        operator.clear();
    }

    public void btnC(View v){
        input.setText("0");
        val = tmp = "0";
        angka.clear();
        operator.clear();
    }
}