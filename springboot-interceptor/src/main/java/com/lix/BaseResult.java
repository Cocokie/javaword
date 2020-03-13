package com.lix;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;

import java.io.Serializable;

/**
 * @author CYJ
 * @VERSION 1.0
 * @CREATE 2019/12/19
 */
public class BaseResult implements Serializable {

    private static final long serialVersionUID = 8629089293762251272L;

    /**
     * 状态码
     */
    private String code;
    /**
     * 状态信息
     */
    private String msg;
    /**
     * 数据结果集
     */
    private Object data = new JSONObject();

    private Object dataExt;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        if (data != null) {
            this.data = data;
        }
    }

    public Object getDataExt() {
        return dataExt;
    }

    public void setDataExt(Object dataExt) {
        if (data != null) {
            this.dataExt = dataExt;
        }
    }

    @Override
    public String toString() {
        return JSON.toJSONString(this);
    }
}
