package com.example.android.menu;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void printToLogs(View view) {
        // Find first menu item TextView and print the text to the logs
        TextView textView = (TextView) findViewById(R.id.menu_item_1);
        Log.i("Menu One Message", textView.getText().toString());
        // Find second menu item TextView and print the text to the logs
        TextView textView2 = (TextView) findViewById(R.id.menu_item_2);
        Log.i("Menu Two Message", textView2.getText().toString());
        // Find third menu item TextView and print the text to the logs
        TextView textView3 = (TextView) findViewById(R.id.menu_item_3);
        Log.i("Menu Three Message", textView3.getText().toString());

    }
}