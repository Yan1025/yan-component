/**
 * @Author Yan
 * @Description
 * @Date 2020/5/16 10:44 下午
 */
public interface BloomOperate<K,V> {
    void add(K key, V value);
    boolean exists(K key, V value);
}
