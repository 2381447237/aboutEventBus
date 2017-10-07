package com.eventbut.zhengbin.eventbustest;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import org.greenrobot.eventbus.EventBus;

/**
 * Created by ZHengBin on 2017/10/7.
 */

public class SecondActivity extends Activity{

    private Button bt_message;
    private TextView tv_message;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        tv_message= (TextView) findViewById(R.id.tv_message);
        tv_message.setText("SecondActivity");
        bt_message= (Button) findViewById(R.id.bt_message);
        bt_message.setText("发送事件");
        bt_message.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EventBus.getDefault().post(new MessageEvent("欢迎关注刘望舒的博客"));
                finish();
            }
        });
    }
}
