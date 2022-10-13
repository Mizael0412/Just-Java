package com.example.justjava;
import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

/**
 * This app displays an order form to order coffee.
 */
public class MainActivity extends AppCompatActivity {
    int Quan = 0;
    String whipCream = "No";
    String chocTop = "No";
    String theName;
    int price;
    boolean checked;
    boolean cChecked;
    String orderSummaryD;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void addItem(View view) {
            if(Quan<100)
            {
        Quan++;
            }
        displayQuantity(Quan);
    }

    public void minusItem(View view) {
            if(Quan>0) {
        Quan--;
            }
        displayQuantity(Quan);

    }


    /**
     * This method is called when the order button is clicked.
     */

    public String createOrderSummary( int oPrice, int iC, String wC, String cT, String tName) {
        String orderSummary = ("Name:"+ tName +" \n" + "Quantity: " + iC + "\n" + "Has whipped cream?" + wC + "\n" + "Has chocolate topping?" + cT + "\n" + "Total: $" + oPrice + "\n" + "Thank you!");
        return orderSummary;


    }
    public String addChocTop(View view) {
        cChecked = ((CheckBox) view).isChecked();
        switch(view.getId()) {
            case R.id.choc_Top_Check_Box:
                if (cChecked)
                    chocTop = "Yes";
                if (!cChecked)
                    chocTop = "No";
                break;


        }
        return chocTop;
    }





    public String addWhippedCream(View view) {
        checked = ((CheckBox) view).isChecked();
        switch(view.getId()) {
            case R.id.whip_Cream_Check_Box:
                if (checked)
                    whipCream = "Yes";

            if (!checked)
                whipCream = "No";
                break;


        }
        return whipCream;
    }

    public void submitOrder(View view) {
        int price = calculatePrice(Quan);
        EditText nameField = (EditText) findViewById(R.id.text_input);
        theName = nameField.getText().toString();
        orderSummaryD = createOrderSummary(price, Quan, whipCream, chocTop, theName);
        displayOrderSummary(orderSummaryD);
        }



    /**
     * This method displays the given quantity value on the screen.
     */
    private void displayQuantity(int Num) {
        TextView quantityTextView = (TextView) findViewById(R.id.quantity_text_view);
        quantityTextView.setText("" + Num);
    }

    /**
     * This method displays the given price on the screen.
     */

    private void displayOrderSummary(String message) {
        TextView orderSummary = (TextView) findViewById(R.id.order_summary_text_view);
        orderSummary.setText(message);
    }

    private int calculatePrice(int quantity) {
        if (checked && cChecked){
            price = quantity * 5 + quantity + quantity * 2;
        }
        else if (checked) {
            price = quantity * 5 + quantity;
        }
        else if (cChecked) {
            price = quantity * 5 + quantity * 2;
        }
        return price;


    }
}