package com.models;
import java.util.ArrayList;
import java.util.Arrays;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.TextPaint;
import android.text.method.LinkMovementMethod;
import android.text.method.ScrollingMovementMethod;
import android.text.style.ClickableSpan;
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
    Button newButton;

    TextView apiResponse;

    @Override
    protected void onCreate(Bundle savedInstanceState) {


    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_activity2);

    final String[] stringArray;
    stringArray = new String[]{ "American", "Mexican", "Asian","European", "African", "South American",
            "Indian", "burgers", "Pizza", "Steak", "Desserts", "Breakfast" };

    Random randomIndex = new Random();
    final int n = randomIndex.nextInt(12);

    TextView inputString = (TextView)findViewById(R.id.textView9);

    inputString = (TextView) findViewById(R.id.textView9);
    inputString.setText(stringArray[n]);

    newButton = (Button) findViewById(R.id.button4);
    goBackButton = (Button) findViewById(R.id.goBackBtn);
    apiButton = (Button)findViewById(R.id.apiButton);
    
    apiResponse = (TextView)findViewById(R.id.apiText);
    apiResponse.setMovementMethod(new ScrollingMovementMethod());
        
    apiButton.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            //int i.setValue(n);
            List apiArray;
            apiResponse.setText("");

            yelpApiCall.asshole hello = new yelpApiCall.asshole( stringArray[n],"nashville");


            String yelpInput = null;
            try {
                yelpInput = hello.execute().get();
            } catch (ExecutionException e) {
                e.printStackTrace();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            try {
                JSONConvert convertor = new JSONConvert(yelpInput);
                apiArray = convertor.getResponseArray();
                System.out.println(apiArray.size() + " hey!");
                
                int length = apiArray.size();

                for(int i=0; i < length; i++)
                {
                    int rnd = new Random().nextInt(apiArray.size());
                    apiResponse.append("IMG   " + apiArray.get(rnd)+ "\n");
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

        newButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                newButtonScreen();
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
        Intent intent = new Intent(this, RandomDisplayActivity.class);
        startActivity(intent);
    }

    public void newButtonScreen(){
        Intent intent = new Intent(this, activity_choose_search.class);
        startActivity(intent);
    }

}

/*

SpannableString ss = new SpannableString("Android is a Software stack");
ClickableSpan clickableSpan = new ClickableSpan() {
    @Override
    public void onClick(View textView) {
        startActivity(new Intent(MyActivity.this, NextActivity.class));
    }
    @Override
    public void updateDrawState(TextPaint ds) {
        super.updateDrawState(ds);
        ds.setUnderlineText(false);
    }
};
ss.setSpan(clickableSpan, 22, 27, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);

TextView textView = (TextView) findViewById(R.id.hello);
textView.setText(ss);
textView.setMovementMethod(LinkMovementMethod.getInstance());
textView.setHighlightColor(Color.TRANSPARENT);

 */