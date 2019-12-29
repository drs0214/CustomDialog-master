package com.customdialog;

import android.app.Activity;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.Button;

public class SecondActivity extends Activity implements View.OnClickListener {
    private Button button1;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        button1 = (Button) findViewById(R.id.button1);
        button1.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.button1) {
            dialog();
        }
    }

    private MyAlertDialog mDialog;

    private void dialog() {
        MyAlertDialog.Builder builder = new MyAlertDialog.Builder(this);
        builder.setTitle("本机号码已注册")//这里设置标题
                .setMessage("若忘记密码,可在登录页点击忘记密码,或用其他号码注册")//这里设置提示信息
                .setTopImage(R.drawable.icon_tanchuang_tanhao)//这里设置顶部图标
                .setPositiveButton("其他号码注册", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        mDialog.dismiss();
                    }
                }).setNegativeButton("返回登录", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                mDialog.dismiss();
            }
        });
        mDialog = builder.create();
        mDialog.show();
    }
}
