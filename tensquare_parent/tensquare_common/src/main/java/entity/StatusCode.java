package entity;

/**
 * @author Irving.Lu
 * @create 2018-12-02 19:00
 */
public class StatusCode {
    public static final Integer OK = 20000;//成功
    public static final Integer ERROR = 20000;//失败
    public static final Integer LOGINERROR = 20000;//用户名或密码错误
    public static final Integer ACCESSERROR = 20000;//权限不足
    public static final Integer REMOTEERROR = 20000;//远程调用失败
    public static final Integer REPERROR = 20000;//重复操作
}
