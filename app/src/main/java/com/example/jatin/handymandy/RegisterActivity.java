package com.example.jatin.handymandy;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;

public class RegisterActivity extends AppCompatActivity {

    private EditText e1,e2,e3,e4,e5;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        e1=(EditText)findViewById(R.id.fname);
        e2=(EditText)findViewById(R.id.lname);
        e3=(EditText)findViewById(R.id.email);
        e4=(EditText)findViewById(R.id.uname);
        e5=(EditText)findViewById(R.id.pword);
    }
    public void onReg(View view){

        String str_name=e1.getText().toString();
        String str_lastname=e2.getText().toString();
        String str_email=e3.getText().toString();
        String str_username=e4.getText().toString();
        String str_password=e5.getText().toString();
        String type="register";
        BackgroundTask backgroundTask=new BackgroundTask(this);
        backgroundTask.execute(type,str_name,str_lastname,str_email,str_username,str_password);



    }

}
