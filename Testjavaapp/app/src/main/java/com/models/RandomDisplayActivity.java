package com.models;
import java.util.ArrayList;
import java.util.Arrays;
import android.content.Intent;
import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.backend.JSONConvert;
import com.backend.yelpApiCall;
import com.example.testjavaapp.R;

import java.lang.Object;
import org.json.JSONException;

import java.util.List;
import java.util.Random;
import java.util.concurrent.ExecutionException;
import java.util.Arrays;

public class RandomDisplayActivity extends AppCompatActivity {
    Button goBackButton;
    Button apiButton;
    TextView apiResponse;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_activity2);
        goBackButton = (Button) findViewById(R.id.goBackBtn);
        apiButton = (Button)findViewById(R.id.apiButton);
        apiResponse = (TextView)findViewById(R.id.apiText);
        apiResponse.setMovementMethod(new ScrollingMovementMethod());
        apiButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                List apiArray;
                apiResponse.setText("");

                String[] stringArray;
                stringArray = new String[]{ "American", "Mexican", "Sushi","Chinese", "Thai", "South American",
                                             "Indian", "burgers", "Pizza", "Steak", "Desserts", "Breakfast" };
                Random randomIndex = new Random();
                int n = randomIndex.nextInt(12);

                yelpApiCall.asshole hello = new yelpApiCall.asshole(stringArray[n],"nashville");
                String bitch = null;
                try {
                    bitch = hello.execute().get();
                } catch (ExecutionException e) {
                    e.printStackTrace();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                try {
                    JSONConvert gay = new JSONConvert(bitch);
                    apiArray = gay.getResponseArray();
                    System.out.println(apiArray.size());
                    //apiResponse.append(gay.getOneRandom()+"\n");
                    int length = apiArray.size();

                    //int length2 = 3;

                    for(int i=0; i < length; i++)
                    {
                        int rnd = new Random().nextInt(apiArray.size());
                        apiResponse.append(apiArray.get(rnd)+"\n");
                        apiArray.remove(rnd);
                    }


                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        });
        goBackButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                goBackScreen();
            }
        });
    }
    public void goBackScreen() {
        Intent intent = new Intent(this, activity_choose_search.class);
        startActivity(intent);
    }
}