package annotation;

import aop.enums.CacheGuardType;

import java.lang.annotation.*;

/**
 * @Author Yan
 * @Description
 * @Date 2020/5/29 6:50 下午
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@Documented
public @interface CacheGuard {
    /**
     * 缓存守卫的类型 默认为容灾缓存
     * @return
     */
    CacheGuardType type() default CacheGuardType.GUARD;

    /**
     * 回源方法
     * 入参要与注解方法一致
     * 该参数不指定时 自动获取被@BackToSource注解的方法
     * 不指定且当前类中无@BackToSource注解时，默认获取方法名为：backToSource(..)的方法
     * 尽量保证该方法拥有返回值，如返回值为null，则每次调用都会回源
     * @return
     */
    String backToSourceMethod() default "";

    /**
     * 生成缓存key的方法
     * 参数需要与注解方法一致
     * @return
     */
    String generateKey() default "";

    /**
     * 缓存过期时间 单位min
     * @return
     */
    long expireTime() default 5L;

    /**
     * 并发级别 默认8个线程
     * @return
     */
    int concurrencyLevel() default 8;

    /**
     * 最大缓存容量(M) 默认2M
     * @return
     */
    int maximumWeight() default 2;

    /**
     * 开启日志
     * @return
     */
    boolean openLog() default true;

}
