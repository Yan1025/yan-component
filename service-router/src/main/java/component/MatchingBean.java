package component;

/**
 * @Author Yan
 * @Description 匹配规则
 * @Date 2020/6/11 4:52 下午
 */
@FunctionalInterface
public interface MatchingBean<T> {
    boolean matching(T param);
}
