package com.example.calculatorfunctional.viewmodel;

import android.util.Log;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import java.lang.reflect.Array;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Stack;

public class MainViewModel extends ViewModel {

    private boolean lastPressIsNum = false;
    private boolean isNeg = false;
    private boolean isDecimalPoint = false;
    private final LinkedList<String> calcList = new LinkedList<>();
    private final MutableLiveData<String> displayString = new MutableLiveData<>();
    private final ArrayList<String> operators = new ArrayList<>(
            Arrays.asList( "%", "/", "x", "-", "+" )
    );
    private final ArrayList<String> numbers = new ArrayList<>(
            Arrays.asList("0","1","2","3","4","5","6","7","8","9")
    );


    // takes btn val and adjusts stack
    public void buttonPressHandler(String btn) {

        Log.d("button pressed",btn);

        //buttons you can press with an empty list
        if (btn == "AC") {
            calcList.clear();
            isNeg = false;
            lastPressIsNum = false;
            isDecimalPoint = false;
        }

        if (btn == "." && !isDecimalPoint && calcList.size() % 2 != 0) {
            if (lastPressIsNum) {
                calcList.add(calcList.removeLast() + ".");
            } else {
                calcList.add("0.");
            }
            isDecimalPoint = true;
            lastPressIsNum = true;
        }

        if (numbers.contains(btn)) {
            if(lastPressIsNum) { calcList.add(calcList.removeLast() + btn); }
            else if(btn != "0") {
                calcList.add(btn);
                lastPressIsNum = true;
            }
        }

        // buttons that require there to be something already
        if (calcList.size() > 0) {

            if (btn == "+/-" && lastPressIsNum) {
                    if (isNeg) { calcList.add(calcList.removeLast().substring(1)); }
                    else { calcList.add("-" + calcList.removeLast()); }
                    isNeg = !isNeg;
            }

            else if (operators.contains(btn)) {
                calcList.add(btn);
                isNeg = false;
                isDecimalPoint = false;
                lastPressIsNum = false;
            }
        }

        if (btn == "=" && calcList.size() % 2 != 0) {
            calculateTotal();
            isNeg = calcList.peek().charAt(0) == '-' ? true : false;
            isDecimalPoint = true;
            lastPressIsNum = false;
        }

        updateDisplayString();
    }

    // process LL into string
    private void updateDisplayString() {
        StringBuilder sb = new StringBuilder();

        if (calcList.size() == 0) {
            sb.append("0");
        }
        for(int i = 0; i < calcList.size(); i++) {
            sb.append(calcList.get(i));
        }
        Log.d("CalcList size", String.valueOf(calcList.size()));
        Log.d("displayString",sb.toString());
        displayString.setValue(sb.toString());
    }

    // calc
    public void calculateTotal() {
        while(calcList.size() >= 3) {
            BigDecimal a = new BigDecimal(calcList.removeFirst());
            // double a = Double.valueOf(calcList.removeFirst());
            String op = calcList.removeFirst();
            BigDecimal b = new BigDecimal(calcList.removeFirst());
            //double b = Double.valueOf(calcList.removeFirst());
            BigDecimal res = new BigDecimal("0");
            switch (op) {
                case "+":
                    res = a.add(b);
                    // res = a + b;
                    break;
                case "-":
                    res = a.subtract(b);
                    //res = a - b;
                    break;
                case "/":
                    res = a.divide(b);
                    // res = a / b;
                    break;
                case "x":
                    res = a.multiply(b);
                    // res = a * b;
                    break;
                case "%":
                    res = a.remainder(b);
                    // res = a % b;
                    break;
            }
            calcList.addFirst(res.toString());
        }

    }

    public LiveData<String> getDisplayString() {
        return displayString;
    }

}
