package com.example.android.cookies;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity {
    Boolean hungry = true;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    /**
     * Called when the cookie should be eaten.
     */
    public void eatCookie(View view) {
        // TODO: Find a reference to the ImageView in the layout. Change the image.

        ImageView imageView = (ImageView) findViewById(R.id.android_cookie_image_view);
        TextView textView = (TextView) findViewById(R.id.status_text_view);
        Button button = (Button) findViewById(R.id.switch_button);

        // TODO: Find a reference to the TextView in the layout. Change the text.
        if(hungry) {
            imageView.setImageResource(R.drawable.after_cookie);
            textView.setText("I'm so full");
            button.setText("Jog! Jog! Jog!");
            hungry = false;
        } else {
            imageView.setImageResource(R.drawable.before_cookie);
            textView.setText("I'm so hungry");
            button.setText("Eat Cookie");
            hungry = true;
        }
    }
}