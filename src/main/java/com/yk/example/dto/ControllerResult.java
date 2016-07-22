package com.yk.example.dto;

/**
 * Created by yukui on 2016/7/22.
 */
public class ControllerResult<RESULTOBJECT> {

    private Integer ret_code;
    /** 返回实际内容（泛型返回对象） */
    private RESULTOBJECT ret_values;

    private String message;

    public Integer getRet_code() {
        return ret_code;
    }

    public void setRet_code(Integer ret_code) {
        this.ret_code = ret_code;
    }

    public RESULTOBJECT getRet_values() {
        return ret_values;
    }

    public void setRet_values(RESULTOBJECT ret_values) {
        this.ret_values = ret_values;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
