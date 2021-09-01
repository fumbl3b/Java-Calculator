package com.example.calculatorfunctional.view;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.example.calculatorfunctional.R;
import com.example.calculatorfunctional.databinding.ActivityMainBinding;
import com.example.calculatorfunctional.databinding.CalculatorBinding;
import com.example.calculatorfunctional.viewmodel.MainViewModel;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private CalculatorBinding binding;
    private MainViewModel viewModel;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = CalculatorBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        // initialize viewModel
        viewModel = new ViewModelProvider(this).get(MainViewModel.class);

        //viewModel.getDisplayString().observe(this, s -> binding.calculatorScreen.setText());
        viewModel.getDisplayString().observe(this, s -> binding.calculatorScreen.setText(s));


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
        String buttonText = null;

        // function buttons
        if(id == R.id.ac_button) { buttonText = "AC"; }
        if(id == R.id.plus_minus_button) { buttonText = "+/-";}
        if(id == R.id.modulus_button) { buttonText = "%"; }
        if(id == R.id.division_button) { buttonText = "/"; }
        if(id == R.id.times_button) { buttonText = "x"; }
        if(id == R.id.minus_button) { buttonText = "-"; }
        if(id == R.id.plus_button) { buttonText = "+"; }
        if(id == R.id.decimal_point_button) { buttonText = "."; }
        if(id == R.id.equals_button) { buttonText = "="; }

        //value buttons
        if (id == R.id.zero_button) { buttonText = "0"; }
        if(id == R.id.one_button) { buttonText = "1"; }
        if(id == R.id.two_button) { buttonText = "2"; }
        if(id == R.id.three_button) { buttonText = "3"; }
        if(id == R.id.four_button) { buttonText = "4"; }
        if(id == R.id.five_button) { buttonText = "5"; }
        if(id == R.id.six_button) { buttonText = "6"; }
        if(id == R.id.seven_button) { buttonText = "7"; }
        if(id == R.id.eight_button) { buttonText = "8"; }
        if(id == R.id.nine_button) { buttonText = "9"; }

        if(buttonText != null) { viewModel.buttonPressHandler(buttonText); };
    }

    public void updateDisplay(String newStr) {
        binding.calculatorScreen.setText(newStr);
    }
}