package com.models;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;

import com.example.testjavaapp.R;

public class UserChoicesActivity extends AppCompatActivity implements View.OnClickListener  {

    Button newSearchButton;
    Button favoriteButton;
    Button mostRecentButton;
    Button startOverButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_choices);

        newSearchButton= (Button)findViewById(R.id.newSearch);
        favoriteButton = (Button)findViewById(R.id.favorite);
        mostRecentButton = (Button)findViewById(R.id.mostRecent);
        startOverButton = (Button)findViewById(R.id.startOver);
        
        newSearchButton.setOnClickListener(this);
        favoriteButton.setOnClickListener(this);
        mostRecentButton.setOnClickListener(this);
        startOverButton.setOnClickListener(this);
        
        buttonEffect(newSearchButton);
        buttonEffect(favoriteButton);
        buttonEffect(mostRecentButton);
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

    public static void buttonEffect(View button){
        button.setOnTouchListener(new View.OnTouchListener() {

            public boolean onTouch(View v, MotionEvent event) {
                switch (event.getAction()) {
                    case MotionEvent.ACTION_DOWN: {
                        v.getBackground().setColorFilter(0x00FF2400, PorterDuff.Mode.SRC_ATOP);
                        v.invalidate();
                        break;
                    }
                    case MotionEvent.ACTION_UP: {
                        v.getBackground().clearColorFilter();
                        v.invalidate();
                        break;
                    }
                    case MotionEvent.ACTION_BUTTON_RELEASE: {
                        v.getBackground().setColorFilter(0x00000000, PorterDuff.Mode.SRC_ATOP);
                    }
                }
                return false;
            }
        });
    }
}