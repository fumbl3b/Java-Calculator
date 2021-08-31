package com.example.calculatorfunctional.view;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.example.calculatorfunctional.R;
import com.example.calculatorfunctional.databinding.ActivityMainBinding;
import com.example.calculatorfunctional.databinding.ButtonsBinding;
import com.example.calculatorfunctional.databinding.CalculatorBinding;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private CalculatorBinding binding;
    private ButtonsBinding buttonBinding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = CalculatorBinding.inflate(getLayoutInflater());
        buttonBinding = ButtonsBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());


        binding.calculatorScreen.setText("onCreate working ;)");
        buttonBinding.oneButton.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {
        updateDisplay("1");
    }

    public void updateDisplay(String newStr) {
        binding.calculatorScreen.setText(newStr);
    }
}