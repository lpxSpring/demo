package com.example.test.testJson;

import java.io.Serializable;

/**
 * 〈一句话功能简述〉<br>
 * 〈功能详细描述〉
 *
 * @author daiw
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */
@SuppressWarnings("all")
public class ResponseStatus implements Serializable {

    private static final Long serialVersionUID = 1L;

    private boolean  result; //成功,失败
    private int code;
    private String msg;
    private Object data;


    public ResponseStatus(boolean result, String msg, Object data) {
        this.result=result;
        this.msg=msg;
        this.data = data;
    }
    public ResponseStatus(boolean result, String msg) {
        this.result=result;
        this.msg=msg;
        this.data = null;
    }

    public ResponseStatus(boolean result, int code, String msg) {
        this.result = result;
        this.code = code;
        this.msg = msg;
    }

    public ResponseStatus(boolean result, int code, String msg, Object data) {
        this.result = result;
        this.code = code;
        this.msg = msg;
        this.data = data;
    }

    /**
     *
     */
    public ResponseStatus() {
        super();
    }
    public void setSuccess(String msg, Object data){
        this.result = true;
        this.data = data;
        this.msg = msg;
    }
    public void setFaile(String msg, Object data){
        this.result = false;
        this.data = data;
        this.msg = msg;
    }

    /**
     * @return the data
     */
    public Object getData() {
        return data;
    }
    /**
     * @param data the data to set
     */
    public void setData(Object data) {
        this.data = data;
    }
    /**
     * @return the result
     */
    public boolean getResult() {
        return result;
    }
    /**
     * @param result the result to set
     */
    public void setResult(boolean result) {
        this.result = result;
    }
    /**
     * @return the msg
     */
    public String getMsg() {
        return msg;
    }
    /**
     * @param msg the msg to set
     */
    public void setMsg(String msg) {
        this.msg = msg;
    }

    public boolean isResult() {
        return result;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    @Override
    public String toString() {
        return "ResponseStatus{" +
                "result=" + result +
                ", code=" + code +
                ", msg='" + msg + '\'' +
                ", data=" + data +
                '}';
    }
}
