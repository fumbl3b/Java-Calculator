package com.example.calculatorfunctional.view;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.example.calculatorfunctional.R;
import com.example.calculatorfunctional.databinding.ActivityMainBinding;
import com.example.calculatorfunctional.databinding.CalculatorBinding;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private CalculatorBinding binding;
    private double totalVal;
    private String currentVal;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = CalculatorBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());


        binding.calculatorScreen.setText("onCreate working ;)");
        currentVal = "0";
        binding.calculatorScreen.setText(currentVal);

        binding.acButton.setOnClickListener(this);
        binding.plusMinusButton.setOnClickListener(this);
        binding.modulusButton.setOnClickListener(this);
        binding.divisionButton.setOnClickListener(this);
        binding.sevenButton.setOnClickListener(this);
        binding.eightButton.setOnClickListener(this);
        binding.nineButton.setOnClickListener(this);
        binding.timesButton.setOnClickListener(this);
        binding.fourButton.setOnClickListener(this);
        binding.fiveButton.setOnClickListener(this);
        binding.sixButton.setOnClickListener(this);
        binding.minusButton.setOnClickListener(this);
        binding.oneButton.setOnClickListener(this);
        binding.twoButton.setOnClickListener(this);
        binding.threeButton.setOnClickListener(this);
        binding.plusButton.setOnClickListener(this);
        binding.zeroButton.setOnClickListener(this);
        binding.decimalPointButton.setOnClickListener(this);
        binding.equalsButton.setOnClickListener(this);


    }

    @Override
    public void onClick(View view) {

        int id = view.getId();

        //functional buttons
        if(id == R.id.ac_button) { currentVal = "0"; }
        if(id == R.id.plus_minus_button) {
            if(currentVal.charAt(0) == '-') { currentVal = currentVal.substring(1); }
            else { currentVal = "-" + currentVal; }
        }
        if(currentVal.length() > 1) {
            if(id == R.id.modulus_button) { currentVal += "%"; }
            if(id == R.id.division_button) { currentVal += "/"; }
            if(id == R.id.times_button) { currentVal += "x"; }
            if(id == R.id.minus_button) { currentVal += "-"; }
            if(id == R.id.plus_button) { currentVal += "+"; }
            if(id == R.id.decimal_point_button) { currentVal += "."; }
        }

        //value buttons
        if (currentVal.length() >= 1 && currentVal.charAt(0) == '0') {
            currentVal = currentVal.substring(1);
        }
        if (id == R.id.zero_button) { currentVal += "0"; }
        if(id == R.id.one_button) { currentVal += "1"; }
        if(id == R.id.two_button) { currentVal += "2"; }
        if(id == R.id.three_button) { currentVal += "3"; }
        if(id == R.id.four_button) { currentVal += "4"; }
        if(id == R.id.five_button) { currentVal += "5"; }
        if(id == R.id.six_button) { currentVal += "6"; }
        if(id == R.id.seven_button) { currentVal += "7"; }
        if(id == R.id.eight_button) { currentVal += "8"; }
        if(id == R.id.nine_button) { currentVal += "9"; }

        updateDisplay(currentVal);
    }

    public void updateDisplay(String newStr) {
        binding.calculatorScreen.setText(newStr);
    }
}