package com.eventbut.zhengbin.eventbustest;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

public class MainActivity extends Activity {

    private TextView tv_message;
    private Button bt_message;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tv_message= (TextView) findViewById(R.id.tv_message);
        tv_message.setText("MainActivity");
        bt_message= (Button) findViewById(R.id.bt_message);
        bt_message.setText("跳转到SecondActivity");
        bt_message.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this,SecondActivity.class));
            }
        });
        //注册事件
        EventBus.getDefault().register(this);

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
       //取消注册事件
        EventBus.getDefault().unregister(this);
    }

    //这里我们的ThreadMode设置为MAIN，事件的处理会在UI线程中执行，用TextView来展示收到的事件消息
    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onMoonEvent(MessageEvent messageEvent){

        tv_message.setText(messageEvent.getMessage());

    }

}
