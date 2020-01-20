package com.alyndroid.architecturepatternstutorialshomework.ui;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.alyndroid.architecturepatternstutorialshomework.pojo.DataBase;

public class ViewModelMulti extends ViewModel {
    public MutableLiveData<String> mutableLiveData = new MutableLiveData<>();

    public void getMultiNumber() {
        mutableLiveData.setValue(String.valueOf(getMultiNumbers()));
    }

    private int getMultiNumbers() {
        DataBase dataBase = new DataBase();
        int num1 = dataBase.getNumbers().getFirstNum();
        int num2 = dataBase.getNumbers().getSecondNum();
        return num1 * num2;

    }

}
