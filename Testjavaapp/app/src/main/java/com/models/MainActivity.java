package com.models;
import com.example.testjavaapp.R;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;

/*
public class practice_activity extends AppCompatActivity {

    private static int SPLASH_TIME_OUT = 4000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_practice_activity);
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                intent homeIntent = new Intent (MainActivity.this, LoginActivity.class);
                startActivity(homeIntent);
                finish();
            }
        }, SPLASH_TIME_OUT);
    }
}

*/

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    Button workButton;

    Button loginButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        workButton= (Button)findViewById(R.id.workButton);
        loginButton = (Button)findViewById(R.id.loginButton);
        workButton.setOnClickListener(this);
        loginButton.setOnClickListener(this);

    }
    @Override
    public void onClick(View view) {
        if(view.getId()==R.id.workButton){
            openScreen2();
        }
        if(view.getId()==R.id.loginButton){
            openLoginScreen();
        }
    }

    public void openScreen2(){
        Intent intent = new Intent(this, activity_choose_search.class);
        startActivity(intent);
    }

    public void openLoginScreen(){
        Intent intent = new Intent(this, LoginActivity.class);
        startActivity(intent);
    }

}
