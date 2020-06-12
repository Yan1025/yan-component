package aop.enums;

/**
 * @Author Yan
 * @Description 缓存守卫的类型
 * @Date 2020/5/29 6:53 下午
 */
public enum CacheGuardType {
    GUARD(1, "容灾缓存"),
    RESULT(2, "结果集缓存");
    private Integer type;
    private String msg;
    CacheGuardType(Integer type, String msg) {
        this.type = type;
        this.msg = msg;
    }
    public Integer getType() {
        return type;
    }
    public String getMsg() {
        return msg;
    }
}
