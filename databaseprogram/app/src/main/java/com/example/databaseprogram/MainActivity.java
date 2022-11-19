package com.example.databaseprogram;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class MainActivity extends AppCompatActivity {
    EditText e1,e2,e3,e4,e5,e6;
    CDB db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        e1=(EditText)findViewById(R.id.et1);
        e2=(EditText)findViewById(R.id.et2);
        e3=(EditText)findViewById(R.id.et3);
        e4=(EditText)findViewById(R.id.et4);
        e5=(EditText)findViewById(R.id.et5);
        e6=(EditText)findViewById(R.id.et6);
        db=new CDB(this);
    }
    public void onInsert(View view)
    {
        String fname,sname,dob,phone,place;
        fname=e2.getText().toString();
        sname=e3.getText().toString();
        dob=e4.getText().toString();
        phone=e5.getText().toString();
        place=e6.getText().toString();
        Toast.makeText(this,fname+sname+dob+phone+place,3).show();
        db.addContact(fname,sname,dob,phone,place);
        e1.setText("");
        e2.setText("");
        e3.setText("");
        e4.setText("");
        e5.setText("");
        e6.setText("");
    }
    public void onSelect(View view)
    {
        String a[];
        try {
            String cno=e1.getText().toString();
            a=db.getOneContact(Integer.parseInt(cno));
            if(a[0]!="")
            {
                e2.setText(a[0]);
                e3.setText(a[1]);
                e3.setText(a[2]);
                e4.setText(a[3]);
                e5.setText(a[4]);
                e6.setText(a[5]);
            }
            else
            {
                Toast.makeText(this,"Not Found....",3).show();

            }
        }
        catch(Exception e)
        {

        }
    }
    public void onDelete(View view)
    {
        String cno=e1.getText().toString();
        db.deleteContact(Integer.parseInt(cno));
        e1.setText("");
        e2.setText("");
        e3.setText("");
        e4.setText("");
        e5.setText("");
        e6.setText("");
    }
    public void onUpdate(View view)
    {
        String cno=e1.getText().toString();
        String fname;
        String sname;
        String dob;
        String phone;
        String place;
        fname=e2.getText().toString();
        sname=e3.getText().toString();
        dob=e4.getText().toString();
        phone=e5.getText().toString();
        place=e6.getText().toString();
        db.update(Integer.parseInt(cno),fname,sname,dob,phone,place);
        e1.setText("");
        e2.setText("");
        e3.setText("");
        e4.setText("");
        e5.setText("");
        e6.setText("");
    }
}
