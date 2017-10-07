package com.eventbut.zhengbin.eventbustest;

/**
 * Created by ZHengBin on 2017/10/7.
 */

public class MessageEvent {

    private String message;

    public MessageEvent(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
