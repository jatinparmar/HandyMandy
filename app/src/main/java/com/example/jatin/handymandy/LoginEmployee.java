package com.example.jatin.handymandy;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class LoginEmployee extends AppCompatActivity {

    private EditText e1, e2;
    private Button b1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_employee);
        e1 = (EditText) findViewById(R.id.editText);
        e2 = (EditText) findViewById(R.id.editText2);
        b1=(Button)findViewById(R.id.button9);

    }


    public void onLogin(View view) {
        String str_email=e1.getText().toString();
        String str_password = e2.getText().toString();

        String type = "login";
        BackgroundTaskLogin backgroundTaskLogin = new BackgroundTaskLogin(this);
        backgroundTaskLogin.execute(type,str_email, str_password);

    }
}
