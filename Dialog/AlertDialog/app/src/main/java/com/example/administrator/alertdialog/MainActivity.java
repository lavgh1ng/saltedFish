package com.example.administrator.alertdialog;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.app.AlertDialog;
import android.app.AlertDialog.Builder;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Builder dialog = new AlertDialog.Builder(MainActivity.this);           //MainActivity.this
        dialog.setIcon(android.R.drawable.ic_dialog_info);           //为对话框设置图标
        dialog.setTitle("欢迎");              //为对话框设置标题
        dialog.setMessage("欢迎使用本程序");          //为对话框设置内容
        //给对话框添加"肯定"按钮
        dialog.setPositiveButton("肯定", new OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                //确认操作
            }
        });
        //给对话框添加"否定"按钮
        dialog.setNegativeButton("否定", new OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                //否定操作
            }
        });
        dialog.create();
        dialog.show();
    }
}
