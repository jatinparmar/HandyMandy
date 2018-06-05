package com.example.jatin.handymandy;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.Switch;

public class Attendance extends AppCompatActivity {

    private Switch s1;
    private EditText e1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_attendance);
        s1=(Switch)findViewById(R.id.switch1);
        e1=(EditText)findViewById(R.id.editText3);
    }
    public void onAttend(View view){

        String str_location=e1.getText().toString();

        String type = "location";
        BackgroundLocation backgroundLocation = new BackgroundLocation(this);
        backgroundLocation.execute(type,str_location);

    }
}
