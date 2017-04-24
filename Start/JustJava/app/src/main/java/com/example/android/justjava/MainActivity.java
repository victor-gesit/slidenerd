package com.example.android.justjava;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.text.NumberFormat;

/**
 * This app displays an order from to order coffee.
 */
public class MainActivity extends AppCompatActivity {
    private CheckBox whippedCreamCheckBox;
    private CheckBox chocolateCheckBox;
    private EditText nameEditText;


    private String name;
    int quantity = 2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        whippedCreamCheckBox = (CheckBox) findViewById(R.id.check_box_1);
        chocolateCheckBox = (CheckBox) findViewById(R.id.check_box_2);
        nameEditText = (EditText) findViewById(R.id.name_edit_text);
    }
    /**
     * This method is called when the order button is clicked
     */
    public void submitOrder(View view){
        // TextView quantityTextView = (TextView) findViewById(R.id.quantity_text_view);
        // int quantity = Integer.parseInt(quantityTextView.getText().toString());
        //int price = quantity * 5;
        //String priceMessage = "Amount due $" + price;
        //String priceMessage = "That would be $" + price + " please.";
        //String priceMessage = "You owe me " + price + " bucks, dude!";
        //String priceMessage = price + " dollars for " + quantity + " cups of coffee. Pay up.";
        /*
        String priceMessage = "Total= $" + price;
        priceMessage = priceMessage + "\nThank you!";
        priceMessage = priceMessage + "\nHope to see you another time";
        */

        boolean hasWhippedcream = whippedCreamCheckBox.isChecked();
        boolean hasChocolate = chocolateCheckBox.isChecked();
        name = nameEditText.getText().toString();

        int price = calculatePrice(hasWhippedcream, hasChocolate);
        String orderSummary = createOrderSummary(price, hasWhippedcream, hasChocolate, name);
        //displayMessage(orderSummary);
        /*
        TextView quantityTextView = (TextView) findViewById(R.id.quantity_text_view);
        int quantity = Integer.parseInt(quantityTextView.getText().toString());
        display(quantity);
        displayPrice(quantity * 5);
        */

        Intent intent = new Intent(Intent.ACTION_VIEW);
        intent.setData(Uri.parse("mailto:"));
        intent.setType("message/rfc822");
        intent.putExtra(Intent.EXTRA_EMAIL, new String[] {"victor4l@yahoo.com"});
        intent.putExtra(Intent.EXTRA_SUBJECT, "Coffee for " + name);
        intent.putExtra(Intent.EXTRA_TEXT, orderSummary);
        try {
            startActivity(Intent.createChooser(intent, "Send mail..."));
        } catch (android.content.ActivityNotFoundException ex) {
            Toast.makeText(this, "There are no email clients installed.", Toast.LENGTH_SHORT).show();
        }


    }

    /**
     * A method to create the summary of the order
     * @return orderSummary
     */

    private String createOrderSummary(int price, boolean whipped_cream, boolean chocolate, String name){
        String orderSummary = "Name = " + name + "\n" +
                "Add whipped cream? " + whipped_cream + "\n" +
                "Add chocolate? " + chocolate + "\n" +
                "Quantity = " + quantity + "\n" +
                "Total = $" + price + "\n" +
                "Thank you!";
        return orderSummary;
    }

    /**
     * Calculates the price of the order.
     *
     */

    private int calculatePrice(boolean addWhippedCream, boolean addChocolate) {
        int pricePerCup = 5;
        if(addWhippedCream){
            pricePerCup +=1;
        }
        if(addChocolate){
            pricePerCup += 2;
        }
        int price = quantity * pricePerCup;
        return price;
    }
    /**
     * This method is called to increment the quantity
     */
    public void increment(View view){
        if(quantity >= 100){
            Toast toast = Toast.makeText(this, "You can't order more than hundred", Toast.LENGTH_SHORT);
            toast.show();
            return;
        }
        quantity++;
        displayQuantity(quantity);
    }

    /**
     * This method is called to decrement the quantity
     */
    public void decrement(View view){
        if(quantity <= 1){
            Toast toast = Toast.makeText(this, "You've got to order at least one", Toast.LENGTH_SHORT);
            toast.show();
            return;
        }
        quantity--;
        displayQuantity(quantity);
    }

    /**
     * This method displays the given quantity value on the screen.
     */
    private void displayQuantity(int givenNumber){
        TextView quantityTextView = (TextView)findViewById(R.id.quantity_text_view);
        quantityTextView.setText("" + givenNumber);
    }
    /**
     * This method displays the given text on the screen.
     */
    private void displayMessage(String message) {
        TextView orderSummaryTextView = (TextView) findViewById(R.id.order_summary_text_view);
        orderSummaryTextView.setText(message);
    }
}

