package com.models;
import java.util.ArrayList;
import java.util.Arrays;
import android.content.Intent;
import android.graphics.PorterDuff;
import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.view.MotionEvent;
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

public class UserInputDisplayActivity extends AppCompatActivity {

    Button goBackButton;
    Button apiButton;
    Button newButton;

    TextView apiResponse;
    TextView inputString;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_activity2);

        Intent intent = getIntent();
        final String apiInput = intent.getStringExtra(NewUserSearchActivity.EXTRA_TEXT);

        inputString = (TextView) findViewById(R.id.textView9);
        inputString.setText(apiInput);

        newButton = (Button) findViewById(R.id.button4);
        goBackButton = (Button) findViewById(R.id.goBackBtn);
        apiButton = (Button)findViewById(R.id.apiButton);
        apiResponse = (TextView)findViewById(R.id.apiText);



        apiResponse.setMovementMethod(new ScrollingMovementMethod());
        apiButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                List apiArray;
                apiResponse.setText("");

                yelpApiCall.asshole hello = new yelpApiCall.asshole( apiInput,"nashville");
                String inputString = null;
                try {
                    inputString = hello.execute().get();
                } catch (ExecutionException e) {
                    e.printStackTrace();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                try {
                    JSONConvert ourCon = new JSONConvert(inputString);
                    apiArray = ourCon.getResponseArray();
                    System.out.println(apiArray.size());

                    int length = apiArray.size();

                    for(int i=0; i < length; i++)
                    {
                        int rnd = new Random().nextInt(apiArray.size());
                        apiResponse.append("SAVE -> " + apiArray.get(rnd)+ "\n");
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
                buttonEffect(newButton);
                newButtonScreen();
            }
        });
    }
    public void goBackScreen() {
        Intent intent = new Intent(this, NewUserSearchActivity.class);
        startActivity(intent);
    }

    public void newButtonScreen(){
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