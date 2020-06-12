package component;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * @Author Yan
 * @Description 包含了各个实现类的工厂Collection容器
 * @Date 2020/6/11 4:57 下午
 */
public class FactoryArrayList<K, E extends MatchingBean<K>> extends ArrayList<E> implements FactoryList<K, E> {

    @Override
    public E getBean(K factor) {
        Iterator<E> itr = this.iterator();

        E beanMatch;
        do {
            if (!itr.hasNext()) {
                return null;
            }
            beanMatch = itr.next();
        } while (!beanMatch.matching(factor));

        return beanMatch;
    }

    @Override
    public List<E> getBeanList(K factor) {
        removeIf(beanMatch -> !beanMatch.matching(factor));
        return this;
    }

}
