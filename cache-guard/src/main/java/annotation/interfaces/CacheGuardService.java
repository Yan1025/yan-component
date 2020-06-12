package annotation.interfaces;

/**
 * @Author Yan
 * @Description 用于业务较为复杂的接口
 * @Date 2020/5/29 6:48 下午
 */
public interface CacheGuardService<K, V> {

    /**
     * 获取cache(NoSQL)
     * @param param
     * @return
     */
    V getCache(K param);

    /**
     * 回源方法
     * @param param
     * @return
     */
    V backToSource(K param);
}
