package annotation;

import java.lang.annotation.*;

/**
 * @Author Yan
 * @Description 缓存守卫 回源方法注解 用于主动出发
 * @Date 2020/5/29 6:49 下午
 */
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.METHOD})
@Documented
public @interface BackToSource {
}
