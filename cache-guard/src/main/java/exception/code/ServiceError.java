package exception.code;

/**
 * @Author Yan
 * @Description
 * @Date 2020/5/29 6:55 下午
 */
public enum ServiceError {
    /**
     *
     */
    SERVER_ERROR(10000, "服务器内部错误"),
    PARAMS_ERROR(20400, "请求参数错误");
    private Integer code;
    private String msg;

    ServiceError(Integer code, String msg){
        this.code = code;
        this.msg = msg;
    }

    public Integer getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }
}
