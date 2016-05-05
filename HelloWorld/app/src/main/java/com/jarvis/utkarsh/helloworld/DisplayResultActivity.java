package com.jarvis.utkarsh.helloworld;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class DisplayResultActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_result);

        // get the calculated result from the saved intent/context and display to the resultTextView
        int result = 0;
        Bundle extras  = getIntent().getExtras();
        if (extras != null) {
            result = extras.getInt("RESULT", 0);
        }

        TextView textview = (TextView) findViewById(R.id.resulttextView);
        textview.setText(Integer.toString(result));
    }

    protected void goBack(View view) {
        Intent intent = new Intent(getBaseContext(), MainActivity.class);
        startActivity(intent);
    }
}
