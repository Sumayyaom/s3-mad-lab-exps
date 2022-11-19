package com.example.valuepass;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

public class second extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.second);
        Bundle bObj=getIntent().getExtras();
        String a=bObj.getString("val");
        EditText e3;
        e3=(EditText)findViewById(R.id.et1);
        Bundle bObj1=getIntent().getExtras();
        String b=bObj1.getString("val");
        e3=(EditText)findViewById(R.id.et2);
        e3.setText(a+b);

    }
    public void onHide(View v)
    {
        finish();
    }

}