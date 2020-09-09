package com.example.yuans.testapplication;

import androidx.databinding.DataBindingUtil;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;

import com.example.yuans.testapplication.databinding.DataBindActivityBinding;


public class DataBindActivity extends AppCompatActivity {

    private DataBindActivityBinding mBinding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mBinding= DataBindingUtil.setContentView(this,R.layout.activity_data_bind);
        mBinding.tvData.setText("hello data binding");
    }
}
