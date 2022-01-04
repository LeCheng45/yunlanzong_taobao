package com.yunlan.result;

import lombok.Data;

@Data
public class R {
    private Boolean flag;
    private Object data;
    private String msg;

    public R(){}

    public R(Boolean flag){
        this.flag = flag;
    }


    public R(Boolean flag, String msg){
        this.flag = flag;
        this.msg = msg;
    }


    public R(Boolean flag, String msg, Object data) {
        this.flag = flag;
        this.data = data;
        this.msg = msg;
    }
}
