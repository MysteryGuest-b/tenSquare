package entity;

import java.io.Serializable;

/**
 * @author Irving.Lu
 * @create 2018-12-02 18:51
 */
public class Result implements Serializable {
    private boolean flag;//是否成功
    private Integer code;//状态码
    private String message;//响应信息
    private Object data;//响应数据
    public Result(){

    }
    //增删改使用
    public Result(boolean flag, Integer code, String message) {
        this.flag = flag;
        this.code = code;
        this.message = message;
    }
    //查询使用
    public Result(boolean flag, Integer code, String message, Object data) {
        this.flag = flag;
        this.code = code;
        this.message = message;
        this.data = data;
    }

    public boolean isFlag() {
        return flag;
    }

    public void setFlag(boolean flag) {
        this.flag = flag;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }
}
