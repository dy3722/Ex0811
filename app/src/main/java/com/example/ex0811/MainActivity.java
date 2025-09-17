package com.example.ex0811;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
    Intent si;
    EditText et;
    double num , resNum;
    boolean isNum , isRes , areRes;
    char op;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        si = new Intent(this, CreditsActivity.class);
        et = findViewById(R.id.et);
        op = 'X';
        isRes = false;
        isNum = false;
        areRes = false;
    }


    public void plus(View view) {
        if (et.getText().toString().matches("[^InfityaN]*") && !et.getText().toString().equals("") && (!et.getText().toString().contains(String.valueOf('E')) || (et.getText().toString().indexOf('E') != et.getText().toString().length() - 1 && et.getText().toString().indexOf('E') != 0))  && (!et.getText().toString().contains(String.valueOf('-')) || (et.getText().toString().indexOf('-') == 0) && et.getText().toString().indexOf('-') != et.getText().toString().length() - 1))
        {
            num = Double.parseDouble(et.getText().toString());
            areRes = false;
            if (isNum)
            {
                resNum = calc(resNum,op,Double.parseDouble(et.getText().toString()));
            }
            else
            {
                resNum = Double.parseDouble(et.getText().toString());
                isNum = true;
            }
            op = '+';
            et.setText("");
        }
    }

    public void minus(View view) {
        if (et.getText().toString().matches("[^InfityaN]*") && !et.getText().toString().equals("") && (!et.getText().toString().contains(String.valueOf('E')) || (et.getText().toString().indexOf('E') != et.getText().toString().length() - 1 && et.getText().toString().indexOf('E') != 0))  && (!et.getText().toString().contains(String.valueOf('-')) || (et.getText().toString().indexOf('-') == 0) && et.getText().toString().indexOf('-') != et.getText().toString().length() - 1))
        {
            num = Double.parseDouble(et.getText().toString());
            areRes = false;
            if (isNum)
            {
                resNum = calc(resNum,op,Double.parseDouble(et.getText().toString()));
            }
            else
            {
                resNum = Double.parseDouble(et.getText().toString());
                isNum = true;
            }
            op = '-';
            et.setText("");
        }
    }

    public void multi(View view) {
        if (et.getText().toString().matches("[^InfityaN]*") && !et.getText().toString().equals("") && (!et.getText().toString().contains(String.valueOf('E')) || (et.getText().toString().indexOf('E') != et.getText().toString().length() - 1 && et.getText().toString().indexOf('E') != 0)) && (!et.getText().toString().contains(String.valueOf('-')) || (et.getText().toString().indexOf('-') == 0) && et.getText().toString().indexOf('-') != et.getText().toString().length() - 1))
        {
            num = Double.parseDouble(et.getText().toString());
            areRes = false;
            if (isNum)
            {
                resNum = calc(resNum,op,Double.parseDouble(et.getText().toString()));
            }
            else
            {
                resNum = Double.parseDouble(et.getText().toString());
                isNum = true;
            }
            op = '*';
            et.setText("");
        }
    }

    public void division(View view) {
        if (et.getText().toString().matches("[^InfityaN]*") && !et.getText().toString().equals("") && (!et.getText().toString().contains(String.valueOf('E')) || (et.getText().toString().indexOf('E') != et.getText().toString().length() - 1 && et.getText().toString().indexOf('E') != 0)) && (!et.getText().toString().contains(String.valueOf('-')) || (et.getText().toString().indexOf('-') == 0) && et.getText().toString().indexOf('-') != et.getText().toString().length() - 1))
        {
            num = Double.parseDouble(et.getText().toString());
            areRes = false;
            if (isNum)
            {
                resNum = calc(resNum,op,Double.parseDouble(et.getText().toString()));
            }
            else
            {
                resNum = Double.parseDouble(et.getText().toString());
                isNum = true;
            }
            op = '/';
            et.setText("");
        }
    }

    public void ac(View view)
    {
        et.setText("");
        isNum = false;
        op = 'X';
    }

    public void eq(View view) {
        if (et.getText().toString().matches("[^InfityaN]*") && !et.getText().toString().equals("") && (!et.getText().toString().contains(String.valueOf('E')) || (et.getText().toString().indexOf('E') != et.getText().toString().length() - 1 && et.getText().toString().indexOf('E') != 0)) && (!et.getText().toString().contains(String.valueOf('-')) || (et.getText().toString().indexOf('-') == 0) && et.getText().toString().indexOf('-') != et.getText().toString().length() - 1))
        {
            isRes = true;
            if (op == 'X')
            {
                resNum = Double.parseDouble(et.getText().toString());
            }
            else
            {
                if (areRes)
                {
                    resNum = calc(resNum,op,num);
                }
                else
                {
                    resNum = calc(resNum,op,Double.parseDouble(et.getText().toString()));
                }
            }
            et.setText(resNum + "");
            isNum = false;
            areRes = true;
        }

    }

    public void cred(View view) {
        si.putExtra("isR",isRes);
        si.putExtra("res",resNum);
        startActivity(si);
    }

    private static double calc(double res, char op, double num) {
        switch (op)
        {
            case '+':
                return res + num;
            case '-':
                return res - num;
            case '*':
                return res * num;
            default:
                return res / num;
        }
    }
}