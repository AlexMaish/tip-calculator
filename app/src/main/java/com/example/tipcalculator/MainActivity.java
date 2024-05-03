package com.example.tipcalculator;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    private TextView displayTipAndTotal;
    private EditText billAmountField;
    private View buttonCalculate15, buttonCalculate18, buttonCalculate20;


    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        linkUIComponents();
        attachButtonListeners();
    }

    private void linkUIComponents() {
        displayTipAndTotal = findViewById(R.id.txt_results);
        billAmountField = findViewById(R.id.ed_amount);
        buttonCalculate15 = findViewById(R.id.btn_15);
        buttonCalculate18 = findViewById(R.id.btn_18);
        buttonCalculate20 = findViewById(R.id.btn_20);
    }

    private void attachButtonListeners() {
        buttonCalculate15.setOnClickListener(v -> handleTipCalculation(0.15));
        buttonCalculate18.setOnClickListener(v -> handleTipCalculation(0.18));
        buttonCalculate20.setOnClickListener(v -> handleTipCalculation(0.20));
    }

    private void handleTipCalculation(double tipPercentage) {
        try {
            double billAmount = Double.parseDouble(billAmountField.getText().toString());
            double tipAmount = billAmount * tipPercentage;
            double totalAmount = billAmount + tipAmount;
            displayTipAndTotal.setText(getString(R.string.result_format, tipAmount, totalAmount));
        } catch (NumberFormatException e) {
            Toast.makeText(this, "Please enter a valid bill amount.", Toast.LENGTH_SHORT).show();
        }
    }
}