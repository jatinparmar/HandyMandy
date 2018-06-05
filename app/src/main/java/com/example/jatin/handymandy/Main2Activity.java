package com.example.jatin.handymandy;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Main2Activity extends AppCompatActivity {
    private static Button button_z,button_a;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        existEmpBtn();
    }
    public void existEmpBtn(){
        button_a=(Button)findViewById(R.id.button4);
        button_z=(Button)findViewById(R.id.button3);
        button_a.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Intent intent=new Intent("com.example.jatin.handymandy.LoginEmployee");
                        startActivity(intent);
                    }
                }
        );
        button_z.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Intent intent=new Intent("com.example.jatin.handymandy.RegisterActivity");
                        startActivity(intent);
                    }
                }
        );

    }

}
