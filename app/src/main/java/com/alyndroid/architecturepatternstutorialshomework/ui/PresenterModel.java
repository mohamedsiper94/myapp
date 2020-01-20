package com.alyndroid.architecturepatternstutorialshomework.ui;

import com.alyndroid.architecturepatternstutorialshomework.pojo.DataBase;

public class PresenterModel  {
            DivNumber view;

    public PresenterModel(DivNumber view) {
        this.view = view;
    }


    public int getDivNumbers() {
        DataBase dataBase = new DataBase();
        int num1 = dataBase.getNumbers().getFirstNum();
        int num2 = dataBase.getNumbers().getSecondNum();
        return num1 / num2;

    }
    public void getDivNumber(){
        view.getOnDivNumbers(getDivNumbers());
    }

}
