package com.example.jatin.handymandy;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class Employer extends AppCompatActivity {
    private Button b5,b6,b7;
    private EditText e4,e5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_employer);
        b5=(Button)findViewById(R.id.button7);
        b6=(Button)findViewById(R.id.button6);
        b7=(Button)findViewById(R.id.button8);
        e4=(EditText)findViewById(R.id.editText4);
        e5=(EditText)findViewById(R.id.editText5);
        setListener();

    }




    public void setListener() {
        b7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent("com.example.jatin.handymandy.RegisterEmployer");
                startActivity(intent);
            }
        });

    }
    public void onEmployer(View view){
        String type = "loginer";
        String st_email=e4.getText().toString();
        String st_password = e5.getText().toString();
        BackgroundTaskEmployer backgroundTaskEmployer = new BackgroundTaskEmployer(this);
        backgroundTaskEmployer.execute(type,st_email, st_password);


    }

}
