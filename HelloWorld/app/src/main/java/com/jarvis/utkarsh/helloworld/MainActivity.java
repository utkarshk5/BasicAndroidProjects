package com.jarvis.utkarsh.helloworld;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    public int currentNumber = 0, storedNumber = 0, operation=-1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    protected void display() {
        TextView textView = (TextView) findViewById(R.id.result);
        textView.setText(Integer.toString(currentNumber));
    }

    protected void clearScreen(View view) {
        currentNumber = 0;
        storedNumber = 0;
        operation = 0;
        display();
    }

    protected void calculateResult(View view) {
        switch(operation){
            case -1: clearScreen(view); return;
            case 0: currentNumber = currentNumber + storedNumber; storedNumber = 0; operation = 0; break;
            case 1: currentNumber = storedNumber - currentNumber; storedNumber = 0; operation = 0; break;
        }

        // save to the context/intent and pass on to the new activity
        Intent intent = new Intent(getBaseContext(), DisplayResultActivity.class);
        intent.putExtra("RESULT", currentNumber);
        startActivity(intent);
    }

    protected void addNumbers(View view) {
        storedNumber = currentNumber;
        currentNumber = 0;
        display();
        operation = 0;
    }

    protected void minusNumbers(View view) {
        storedNumber = currentNumber;
        currentNumber = 0;
        display();
        operation = 1;
    }

    protected void append(View view) {
        currentNumber = currentNumber*10 + Integer.parseInt(((Button) view).getText().toString());
        display();
    }

}
