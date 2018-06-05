package com.example.jatin.handymandy;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class RegisterEmployer extends AppCompatActivity {

    private EditText e10,e11,e12,e13,e14;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        e10=(EditText)findViewById(R.id.fname);
        e11=(EditText)findViewById(R.id.lname);
        e12=(EditText)findViewById(R.id.email);
        e13=(EditText)findViewById(R.id.uname);
        e14=(EditText)findViewById(R.id.pword);
    }
    public void onReg(View view){

        String str_ername=e10.getText().toString();
        String str_erlastname=e11.getText().toString();
        String str_eremail=e12.getText().toString();
        String str_erusername=e13.getText().toString();
        String str_erpassword=e14.getText().toString();
        String type="registerer";
        BackgroundTaskEmployer backgroundTaskEmployer=new BackgroundTaskEmployer(this);
        backgroundTaskEmployer.execute(type,str_ername,str_erlastname,str_eremail,str_erusername,str_erpassword);


    }
}
