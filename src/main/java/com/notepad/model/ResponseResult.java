package com.notepad.model;

/**
 * Created by qxg on 17-5-14.
 */
public class ResponseResult {
    private boolean success;
    private String msg;

    public ResponseResult(boolean success, String msg) {
        this.success = success;
        this.msg = msg;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
