package com.alyndroid.architecturepatternstutorialshomework.ui;

import android.app.Activity;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import com.alyndroid.architecturepatternstutorialshomework.R;
import com.alyndroid.architecturepatternstutorialshomework.databinding.ActivityMainBinding;
import com.alyndroid.architecturepatternstutorialshomework.pojo.DataBase;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity implements View.OnClickListener, DivNumber {
    ActivityMainBinding activityMainBinding;
    PresenterModel presenterModel;
    ViewModelMulti viewModelMulti;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        activityMainBinding= DataBindingUtil.setContentView(this,R.layout.activity_main);
        activityMainBinding.plusButton.setOnClickListener(this);
        activityMainBinding.divButton.setOnClickListener(this);
         presenterModel = new PresenterModel(this);
        viewModelMulti = ViewModelProviders.of(this).get(ViewModelMulti.class);
        activityMainBinding.setViewModel(viewModelMulti);
        activityMainBinding.setLifecycleOwner(this);
    }

    public int getSumNumbers() {
        DataBase dataBase = new DataBase();
        int num1 = dataBase.getNumbers().getFirstNum();
        int num2 = dataBase.getNumbers().getSecondNum();
        return num1 + num2;

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.plus_button:
                activityMainBinding.plusResultTextView.setText(String.valueOf(getSumNumbers()));
                break;
            case R.id.div_button:
                presenterModel.getDivNumber();
                break;

        }
    }


    @Override
    public void getOnDivNumbers(int result) {
        activityMainBinding.divResultTextView.setText(String.valueOf(result));
    }
}
