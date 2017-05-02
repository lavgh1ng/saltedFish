package com.example.administrator.datepickerdialog;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.method.DateKeyListener;
import android.widget.TextView;
import android.view.View;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import android.widget.Button;
import android.widget.DatePicker;
import android.view.View.OnClickListener;
import android.app.DatePickerDialog;

public class MainActivity extends AppCompatActivity {

    private TextView showdate;
    private Button setdate;
    private int year;
    private int month;
    private int day;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        showdate = (TextView)this.findViewById(R.id.showtime);
        setdate = (Button)this.findViewById(R.id.setdate);
        Calendar c = Calendar.getInstance(Locale.CHINA);     //初始化Calendar日历对象
        Date mydate = new Date();   //获取当前日期Date对象
        c.setTime(mydate);  //设置时间为当前日期
        //获取年月日
        year = c.get(Calendar.YEAR);
        month = c.get(Calendar.MONTH);
        day = c.get(Calendar.DAY_OF_MONTH);
        showdate.setText("当前日期:"+year+"-"+(month+1)+"-"+day);

        //添加单击事件--设置日期
        setdate.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                //创建DatePickerDialog对象
                DatePickerDialog my_datePickerDialog = new DatePickerDialog(MainActivity.this,myDatelistener ,year,month,day);
                my_datePickerDialog.show();
            }
        });
    }

    private DatePickerDialog.OnDateSetListener myDatelistener = new DatePickerDialog.OnDateSetListener(){
        @Override
        public void onDateSet(DatePicker v, int y, int m,int d) {
            //修改year、month、day的变量值，以便以后单击按钮时，DatePickerDialog上显示上一次修改后的值
            year=y;
            month=m;
            day=d;
            //更新日期
            updateDate();
        }
        //当DatePickerDialog关闭时，更新日期显示
        private void updateDate()
        {
            //在TextView上显示日期
            showdate.setText("当前日期："+year+"-"+(month+1)+"-"+day);
        }
    };
}
