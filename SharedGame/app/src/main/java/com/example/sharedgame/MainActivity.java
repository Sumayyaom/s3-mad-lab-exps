package com.example.sharedgame;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    public static final String SHARED_PREFERENCE_NAME ="com.example.com.shared-preferences";
    public static final String SHARED_PREFERENCE_KEY_NUM1 ="NUM1";
    public static final String SHARED_PREFERENCE_KEY_NUM2 ="NUM2";
    public static final String SHARED_PREFERENCE_KEY_LEVEL ="LEVEL";
    public static final String SHARED_PREFERENCE_KEY_SCORE ="SCORE";
    public static final String SHARED_PREFERENCE_KEY_OPERATOR = "OPERATOR";
    Integer n1,n2,r,l;
    EditText level,res;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        level=findViewById(R.id.l1);
        res = findViewById(R.id.res);
    }

    @Override
    protected void onPause() {
        SharedPreferences sh = getSharedPreferences("MySharedPref", MODE_PRIVATE);

        int s1 = sh.getInt("level", 1);
        int s2 = sh.getInt("res", 0);
        super.onPause();
        level.setText(s1);
        res.setText(String.valueOf(s2));
    }

    @Override
    protected void onResume() {

        super.onResume();
        SharedPreferences sharedPreferences = getSharedPreferences("MySharedPref", MODE_PRIVATE);
        SharedPreferences.Editor myEdit = sharedPreferences.edit();

        // write all the data entered by the user in SharedPreference and apply
//        myEdit.putString("level", level.getText().toString());
        myEdit.putInt("level", Integer.parseInt(level.getText().toString()));
        myEdit.putInt("res", Integer.parseInt(res.getText().toString()));
        myEdit.apply();
    }
}