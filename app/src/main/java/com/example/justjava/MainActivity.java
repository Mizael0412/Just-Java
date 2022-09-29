package com.example.justjava;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import java.text.NumberFormat;

import androidx.appcompat.app.AppCompatActivity;

/**
 * This app displays an order form to order coffee.
 */
public class MainActivity extends AppCompatActivity {
    int Quan = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    public void addItem(View view){

        Quan++;
        display (Quan);
    }

    public void minusItem(View view){

        Quan--;
        display(Quan);

    }



    /**
     * This method is called when the order button is clicked.
     */
    public void submitOrder(View view) {
        displayPrice(Quan*5);
        displayMessage("Total item count: " + Quan + " coffees");
    }

    /**
     * This method displays the given quantity value on the screen.
     */
    private void display(int number) {
        TextView quantityTextView = (TextView) findViewById(R.id.quantity_text_view);
        quantityTextView.setText("" + number);
    }
    /**
     * This method displays the given price on the screen.
     */
    private void displayPrice(int number) {
        TextView priceTextView = (TextView) findViewById(R.id.price_text_view);
        priceTextView.setText(NumberFormat.getCurrencyInstance().format(number));
    }

    private void displayMessage(String message) {
        TextView orderSummary = (TextView) findViewById(R.id.price_text_view);
        orderSummary.setText(message);
    }
}