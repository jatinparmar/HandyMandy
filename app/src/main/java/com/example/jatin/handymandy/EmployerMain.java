package com.example.jatin.handymandy;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class EmployerMain extends AppCompatActivity {


    private Button bb, ba;
    private EditText ee;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_employer_main);
        bb = (Button) findViewById(R.id.button12);
        ee = (EditText) findViewById(R.id.editText11);
        ba = (Button) findViewById(R.id.bo);
        onMap();
    }

    public void onCheck(View view) {
        String type = "check";
        String stc_text = ee.getText().toString();
        BackgroundEmployerMain backgroundEmployerMain = new BackgroundEmployerMain(this);
        backgroundEmployerMain.execute(type, stc_text);

    }

    public void onMap() {
        ba.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent("com.example.jatin.handymandy.MapsActivity");
                startActivity(intent);
            }
        });
    }
}