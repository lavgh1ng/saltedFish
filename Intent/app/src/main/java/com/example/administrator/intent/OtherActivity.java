package com.example.administrator.intent;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class OtherActivity extends Activity{
    private Intent intent;
    private Bundle bundle;

    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.other_activity);
        Bundle bundle = this.getIntent().getExtras();
        String ans =  bundle.getString("ans");
        String sexText = "";
        if(ans.equals("in")){
            sexText = "";
        }else {
            sexText = "";
        }
        TextView tv1 = (TextView)findViewById(R.id.text1);
        tv1.setText("你选择的答案是："+sexText);

        Button btn3_back = (Button)findViewById(R.id.button_back);
        btn3_back.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View v) {
                OtherActivity.this.setResult(RESULT_OK, intent);
                OtherActivity.this.finish();
            }
        });
    }
}
