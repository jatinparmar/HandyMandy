package com.example.jatin.handymandy;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    private static Button button_x,button_y;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        onClickButtonListener();
    }
    public void onClickButtonListener(){
        button_x=(Button)findViewById(R.id.button);
        button_y=(Button)findViewById(R.id.button2);
        button_x.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent("com.example.jatin.handymandy.Main2Activity");
                startActivity(intent);
            }
        });
        button_y.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Intent intent=new Intent("com.example.jatin.handymandy.Employer");
                        startActivity(intent);
                    }
                }
        );
    }



    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        return super.onOptionsItemSelected(item);
    }
}