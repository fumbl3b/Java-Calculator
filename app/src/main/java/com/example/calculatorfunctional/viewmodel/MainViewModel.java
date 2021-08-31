package com.example.calculatorfunctional.viewmodel;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

public class MainViewModel {

    // Livedata is

    private MutableLiveData<String> displayString = new MutableLiveData<>();


    public LiveData<String> getDisplayString() {
        return displayString;
    }


    // Entry method to do some logic
    void calculateSomething(int num) {
        displayString.setValue("My num is " + num);
    }

}
