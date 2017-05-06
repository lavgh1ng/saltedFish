package com.example.administrator.spinnerdemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MotionEvent;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private static final String[] countriesStr ={ "广州", "上海", "深圳", "北京" };
    private TextView myTextView;
    private Spinner mySpinner;
    private ArrayAdapter adapter;

    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        myTextView = (TextView) findViewById(R.id.myTextView);
        mySpinner = (Spinner) findViewById(R.id.mySpinner);
        adapter = new ArrayAdapter(this, android.R.layout.simple_spinner_item,
                countriesStr);
        adapter.setDropDownViewResource(R.layout.layout);
	    mySpinner.setAdapter(adapter);
        mySpinner.setOnItemSelectedListener(new Spinner.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView arg0, View arg1,int arg2, long arg3) {
                myTextView.setText(countriesStr[arg2]);
                arg0.setVisibility(View.VISIBLE);
            }
            @Override
            public void onNothingSelected(AdapterView arg0) {
                // TODO Auto-generated method stub
            }
        });
    }
}
