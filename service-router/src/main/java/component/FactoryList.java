package component;

import java.util.List;

/**
 * @Author Yan
 * @Description 业务路由接口
 * @Date 2020/6/11 4:54 下午
 */
public interface FactoryList<K, E extends MatchingBean<K>> extends List<E> {

    E getBean(K factor);

    List<E> getBeanList(K factor);

}
