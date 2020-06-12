package exception;

import exception.code.ServiceError;

/**
 * @Author Yan
 * @Description
 * @Date 2020/5/29 6:55 下午
 */
public class ServiceException extends RuntimeException{
    private Integer code;
    private String msg;
    public ServiceException(ServiceError serviceError) {
        this.code = serviceError.getCode();
        this.msg = serviceError.getMsg();
    }
    public ServiceException(ServiceError serviceError, String message) {
        this.code = serviceError.getCode();
        this.msg = message;
    }
    public ServiceException(Integer errorCode, String message) {
        this.code = errorCode;
        this.msg = message;
    }
    public ServiceException(ServiceException serviceException, Throwable throwable) {
        super(throwable);
        this.code = serviceException.code;
        this.msg = serviceException.msg;
    }
}
