package config;

/**
 * @Author Yan
 * @Description 配置中心常量的key
 * @Date 2020/5/29 6:53 下午
 */
public class CacheGuardConstant {
    /**
     * 刷新时间key
     */
    public static final String REFRESH_AFTER_WRITE_TIME_KEY = "cache.guard.refresh.after.write.time.key";

    /**
     * 多少分钟内未访问的过期时间key
     */
    public static final String EXPIRE_AFTER_ACCESS_TIME_KEY = "cache.guard.expire.after.access.time.key";

    /**
     * 过期时间配置key
     */
    public static final String EXPIRE_TIME_KEY = "cache.guard.expire.time.key";

    /**
     * 并发线程数
     */
    public static final String CONCURRENCY_LEVEL_KEY = "cache.guard.concurrency.level.key";

    /**
     * 最大容量
     */
    public static final String MAXIMUM_SIZE = "cache.guard.maximum.size.key";

    /**
     *
     */
    public static final String MAXIMUM_WEIGHT = "cache.guard.maximum.weight.key";

    /**
     * 是否开启错误日志
     */
    public static final String OPEN_ERROR_LOG = "cache.guard.open.error.log";
}
