package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.google.android.material.button.MaterialButton;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    TextView Sol_tv,Res_tv,Operation;
    MaterialButton Ac,OpBracket,ClBracket,Div,Ml,Pl,Min,b0,b1,b2,b3,b4,b5,b6,b7,b8,b9,Eq,Del,Point;
    int var1,var2,var3;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Res_tv= findViewById(R.id.Res_tv);
        Operation= findViewById(R.id.operation);
        Sol_tv= findViewById(R.id.Sol_tv);
        assignId(b0, R.id.button_0);
        assignId(b1, R.id.button_1);
        assignId(b2, R.id.button_2);
        assignId(b3, R.id.button_3);
        assignId(b4, R.id.button_4);
        assignId(b5, R.id.button_5);
        assignId(b6, R.id.button_6);
        assignId(b7, R.id.button_7);
        assignId(b8, R.id.button_8);
        assignId(b9, R.id.button_9);

        assignId(Ac, R.id.button_Ac);
        assignId(OpBracket, R.id.button_OpBracket);
        assignId(ClBracket, R.id.button_ClBracket);
        assignId(Div, R.id.button_Div);
        assignId(Ml, R.id.button_Mult);


        assignId(Pl, R.id.button_Plus);
        assignId(Min, R.id.button_Min);
        assignId(Eq, R.id.button_Equal);
        assignId(Del, R.id.button_C);
        assignId(Point, R.id.button_Point);
    }
    void assignId(MaterialButton btn, int id) {
        btn = findViewById(id);
        btn.setOnClickListener(this);
    }
    @Override
    public void onClick(View view) {
        MaterialButton button = (MaterialButton) view;
        String buttonText = button.getText().toString();
        String dataToCalculate = Res_tv.getText().toString();

        if (buttonText.equals("AC"))
        {
            var1=0;
            var2=0;
            var3=0;
            Sol_tv.setText("0");
            Res_tv.setText("0");
            Operation.setText("");
            return;
        }
        if(buttonText.equals("DEL"))
        {
            Res_tv.setText(dataToCalculate.substring(0,dataToCalculate.length()-1));
        }
        if(buttonText.equals("="))
        {
            if(Operation.getText().toString().equals("+")||Operation.getText().toString().equals("-")||Operation.getText().toString().equals("÷")||Operation.getText().toString().equals("X"))
            {
                var2 = Integer.parseInt(Res_tv.getText().toString());
                switch(Operation.getText().toString()) {
                    case "+":
                        var3 = var1+var2;
                        break;
                    case "-":
                        var3 = var1-var2;
                        break;
                    case "X":
                        var3 = var1*var2;
                        break;
                    case "÷":
                        var3 = var1/var2;
                        break;

                }

                Res_tv.setText(Integer. toString(var3));
                var1=var3;
                var3=0;
                var2=0;
            }
            Operation.setText("=");


        }
        if(buttonText.equals("+"))
        {
            if(var1==0)
            var1 = Integer.parseInt(Res_tv.getText().toString());
            Operation.setText("+");
            Sol_tv.setText(Integer. toString(var1));
            dataToCalculate = "0";
            Res_tv.setText(dataToCalculate);
            return;
        }
        if(buttonText.equals("-"))
        {
            if(var1==0)
                var1 = Integer.parseInt(Res_tv.getText().toString());
            Operation.setText("-");
            Sol_tv.setText(Integer. toString(var1));
            dataToCalculate = "0";
            Res_tv.setText(dataToCalculate);
            return;
        }
        if(buttonText.equals("X"))
        {
            if(var1==0)
                var1 = Integer.parseInt(Res_tv.getText().toString());
            Operation.setText("X");
            Sol_tv.setText(Integer. toString(var1));
            dataToCalculate = "0";
            Res_tv.setText(dataToCalculate);
            return;
        }
        if(buttonText.equals("/"))
        {
            if(var1==0)
                var1 = Integer.parseInt(Res_tv.getText().toString());
            Operation.setText("÷");
            Sol_tv.setText(Integer. toString(var1));
            dataToCalculate = "0";
            Res_tv.setText(dataToCalculate);
            return;
        }

        if (buttonText.equals("0")||buttonText.equals("1")||buttonText.equals("2")||buttonText.equals("3")||buttonText.equals("4")||buttonText.equals("5")||buttonText.equals("6")||buttonText.equals("7")||buttonText.equals("8")||buttonText.equals("9"))
        {
            if(Integer.parseInt(Res_tv.getText().toString())==0)
            {
                dataToCalculate="";
            }

            dataToCalculate = dataToCalculate+buttonText;
            Res_tv.setText(dataToCalculate);
            return;
        }

    }
}