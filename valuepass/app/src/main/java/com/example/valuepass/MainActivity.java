package com.example.valuepass;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    public void onNext(View v)
    {
        EditText e1,e2;
        e1=(EditText)findViewById(R.id.et1);
        e2=(EditText)findViewById(R.id.et2);
        Intent iObj,iObj1;
        iObj=new Intent("activity.sec2");
        iObj.putExtra("val",e1.getText().toString());
        startActivity(iObj);
        iObj1=new Intent("activity.sec2");
        iObj1.putExtra("val",e2.getText().toString());
        startActivity(iObj1);
    }
}