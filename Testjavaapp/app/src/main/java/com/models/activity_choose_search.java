package com.models;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.testjavaapp.R;

public class activity_choose_search extends AppCompatActivity implements View.OnClickListener  {

    Button youChooseButton;
    Button weChooseButton;
    Button startOverButton;
    String a,b;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choose_search);

        /*
        yelpApiCall.asshole hello = new yelpApiCall.asshole("Mexican","nashville");
        String bitch = null;
        try {
            bitch = hello.execute().get();
        } catch (ExecutionException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(bitch);
        try {
            JSONConvert gay = new JSONConvert(bitch);
        } catch (JSONException e) {
            e.printStackTrace();
        }*/

        youChooseButton= (Button)findViewById(R.id.youChoose);
        weChooseButton = (Button)findViewById(R.id.weChoose);
        startOverButton = (Button)findViewById(R.id.startOver);
        youChooseButton.setOnClickListener(this);
        weChooseButton.setOnClickListener(this);
        startOverButton.setOnClickListener(this);

    }
    @Override
    public void onClick(View view) {
        if(view.getId()==R.id.youChoose){
            openUserChoose();
        }
        if(view.getId()==R.id.weChoose){
            openRandomChoose();
        }
        if(view.getId()==R.id.startOver){
            openStartOver();
        }
    }
    public void openUserChoose(){
        Intent intent = new Intent(this, UserChoicesActivity.class);
        startActivity(intent);
    }
    public void openRandomChoose(){
        Intent intent = new Intent(this, RandomDisplayActivity.class);
        startActivity(intent);
    }

    public void openStartOver(){
        Intent intent = new Intent(this, LoginActivity.class);
        startActivity(intent);
    }

}
