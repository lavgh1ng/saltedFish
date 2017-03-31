package com.example.administrator.intent;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;

public class MainActivity extends Activity {

    RadioButton r1 = null;
    RadioButton r2 = null;
    RadioButton r3 = null;
    RadioButton r4 = null;
    RadioGroup radioGroup = null;

    public void onCreate(Bundle savedInstanceState) { //Bundle类用作携带数据
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //获得单选按钮组
        radioGroup = (RadioGroup) findViewById(R.id.radioGroup);
        //获得单选按钮
        r1 = (RadioButton) findViewById(R.id.a);
        r2 = (RadioButton) findViewById(R.id.b);
        r3 = (RadioButton) findViewById(R.id.c);
        r4 = (RadioButton) findViewById(R.id.d);
        r1.setClickable(true);
        //监听单选按钮
        Button btn1_sure = (Button) findViewById(R.id.sure);
        Button btn2_cancel = (Button) findViewById(R.id.cancel);
        btn1_sure.setOnClickListener(new btn1_sure());
        btn2_cancel.setOnClickListener(new btn2_cancel());
    }

    class btn1_sure implements OnClickListener {
        public void onClick(View v){
            String ans = "";
            if (r1.isChecked()){
                ans = "捡一块钱";
            }else if (r2.isChecked()){
                ans = "";
            }else if (r3.isChecked()){
                ans = "";
            }else if (r4.isChecked()){
                ans = "";
            }

            Intent intent = new Intent();
            intent.setClass(MainActivity.this,OtherActivity.class);
            Bundle bundle  =  new Bundle();
            bundle.putString("ans",ans);
            intent.putExtras(bundle);
            MainActivity.this.startActivity(intent);
        }
    }

    class btn2_cancel implements OnClickListener{
        @Override
        public void onClick(View v){
            radioGroup.clearCheck();
            setTitle("");
        }
    }

    protected void onActivityResult(int requestCode,int resultCode,Intent data){
        super.onActivityResult(requestCode,resultCode,data);
        switch(resultCode){
            case RESULT_OK:
                Bundle bundle = data.getExtras();
                String ans = bundle.getString("ans");
                break;
            default:
                break;
        }
    }
}
