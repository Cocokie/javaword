package com.lix;

/**
 * @author CYJ
 * @version 1.0
 * @create 2019/12/19
 */

public class DataResult extends BaseResult {

    public DataResult() {

    }

    public DataResult(String code, String msg) {
        setCode(code);
        setMsg(msg);
    }

    public DataResult(String code, String msg, Object data) {
        setCode(code);
        setMsg(msg);
        setData(data);
    }

    public static DataResult error(String code, String msg) {
        return new DataResult(code, msg);
    }

    public static DataResult error(ReturnCode returnCode) {
        return new DataResult(returnCode.getCode(), returnCode.getMsg());
    }

    public static DataResult resp(ReturnCode returnCode, Object obj) {
        return new DataResult(returnCode.getCode(), returnCode.getMsg(), obj);
    }


    /**
     * 系统错误
     *
     * @return
     */
    public static DataResult sysError() {
        return error(ReturnCode.SYSTEM_ERROR);
    }

    /**
     * 系统错误
     *
     * @return
     */
    public static DataResult sysError(String msg) {
        return error(ReturnCode.SYSTEM_ERROR.getCode(), msg);
    }

    /**
     * 参数错误
     *
     * @param msg
     * @return
     */
    public static DataResult paramError(String msg) {
        return error(ReturnCode.PARAM_ERROR.getCode(), msg);
    }

    /**
     * 没有数据更新
     *
     * @return
     */
    public static DataResult noData() {
        return error(ReturnCode.NO_DATA_UPDATE);
    }

    /**
     * 数据已存在
     *
     * @return
     */
    public static DataResult dataExists() {
        return error(ReturnCode.DATA_EXISTS);
    }


    public static DataResult ok() {
        return error(ReturnCode.SUCCESS);
    }

    public static DataResult ok(String msg) {
        return error(ReturnCode.SUCCESS.getCode(), msg);
    }

    public static DataResult ok(Object obj) {
        return resp(ReturnCode.SUCCESS, obj);
    }

    public static DataResult ok(String msg, Object obj) {
        return new DataResult(ReturnCode.SUCCESS.getCode(), msg, obj);
    }

}