package com.example.ex0811;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class CreditsActivity extends AppCompatActivity {
    TextView tv;
    Intent gi;
    double resNum;
    boolean isRes;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_credits);

        tv = findViewById(R.id.tv);
        gi = getIntent();

        isRes = gi.getBooleanExtra("isR",false);
        resNum = gi.getDoubleExtra("res",0);

        if (isRes)
        {
            tv.setText(resNum + "");
        }
    }

    public void back(View view) {
        finish();
    }
}