package com.models;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.testjavaapp.R;

public class UserChoicesActivity extends AppCompatActivity implements View.OnClickListener  {

    Button newSearchButton;
    Button favoriteButton;
    Button mostRecentButton;
    Button startOverButton;
    String a,b;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_choices);





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

        newSearchButton= (Button)findViewById(R.id.newSearch);
        favoriteButton = (Button)findViewById(R.id.favorite);
        mostRecentButton = (Button)findViewById(R.id.mostRecent);
        startOverButton = (Button)findViewById(R.id.startOver);
        newSearchButton.setOnClickListener(this);
        favoriteButton.setOnClickListener(this);
        mostRecentButton.setOnClickListener(this);
        startOverButton.setOnClickListener(this);


    }
    @Override
    public void onClick(View view) {
        if(view.getId()==R.id.newSearch){
            openNewSearch();
        }
        if(view.getId()==R.id.favorite) {
            openFavorite();
        }
        if(view.getId()==R.id.mostRecent){
            openMostRecent();

        }

        if (view.getId() == R.id.startOver) {
            openStartOver();
        }
    }
    public void openNewSearch(){
        Intent intent = new Intent(this, NewUserSearchActivity.class);
        startActivity(intent);
    }
    public void openFavorite(){
        Intent intent = new Intent(this, FavoriteDisplayActivity.class);
        startActivity(intent);
    }
    public void openMostRecent(){
        Intent intent = new Intent(this, MostRecentDisplayActivity.class);
        startActivity(intent);
    }

    public void openStartOver(){
        Intent intent = new Intent(this, activity_choose_search.class);
        startActivity(intent);
    }



}