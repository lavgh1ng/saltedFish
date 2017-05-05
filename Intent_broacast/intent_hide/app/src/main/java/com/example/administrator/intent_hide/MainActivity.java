package com.example.administrator.intent_hide;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.telephony.PhoneNumberUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import android.content.Intent;
import android.net.Uri;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final EditText phoneNum = (EditText)findViewById(R.id.phoneNum);
        final Button button = (Button)findViewById(R.id.myButton);
        button.setOnClickListener(new Button.OnClickListener(){
            public void onClick(View v){
                String call = phoneNum.getText().toString();
                if(PhoneNumberUtils.isGlobalPhoneNumber(call)){
                    Intent I=new Intent(Intent.ACTION_DIAL,Uri.parse("tel://"+call));
                    startActivity(I);
                    /*Intent i = new Intent();
                    i.setAction(Intent.ACTION_CALL);
                    i.setData(Uri.parse("tel://" + call));
                    startActivity(i);*/
                }
                else{
                    Toast.makeText(MainActivity.this,R.string.error,Toast.LENGTH_LONG).show();;
                }
            }
        });
    }
}
