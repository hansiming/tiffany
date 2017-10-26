package com.cszjo.tiffany.core.codec;

import java.io.Serializable;

/**
 * Created by hansiming on 2017/10/26.
 */
public class Response implements Serializable {

    private int    code   = 0;
    private String errMsg = "";
    private Object result;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getErrMsg() {
        return errMsg;
    }

    public void setErrMsg(String errMsg) {
        this.errMsg = errMsg;
    }

    public Object getResult() {
        return result;
    }

    public void setResult(Object result) {
        this.result = result;
    }
}
