import com.google.common.base.Preconditions;
import com.google.common.hash.Funnels;

import java.nio.charset.Charset;
import java.util.Objects;

/**
 * @Author Yan
 * @Description 布隆过滤器
 * @Date 2020/5/20 12:10 上午
 */
public class BloomFilter<T> {
    private BloomOperate bloomOperate;
    private BloomFilterHelper bloomFilterHelper;
    private String key;

    /**
     * 默认的误差率
     */
    private Double defaultFpp = 0.01;

    /**
     * 使用默认误差率defaultFpp
     * @param bloomOperate
     * @param expectedInsertions
     * @param key
     */
    public BloomFilter(BloomOperate bloomOperate, Integer expectedInsertions, String key) {
        this(bloomOperate, expectedInsertions, null, key);
    }

    /**
     * 指定误差率
     * @param bloomOperate
     * @param expectedInsertions
     * @param fpp
     * @param key
     */
    public BloomFilter(BloomOperate bloomOperate, Integer expectedInsertions, Double fpp, String key) {
        if (Objects.isNull(fpp)) {
            fpp = defaultFpp;
        }
        this.bloomOperate = bloomOperate;
        this.bloomFilterHelper =
                new BloomFilterHelper(Funnels.stringFunnel(Charset.defaultCharset()), expectedInsertions, fpp);
        this.key = key;
    }

    /**
     * 用指定的布隆过滤器方法添加新值
     * @param value
     * @param <T>
     */
    public <T> void addByBloomFilter(T value) {
        Preconditions.checkArgument(bloomFilterHelper != null, "bloomFilterHelper不能为空");
        int[] offset = bloomFilterHelper.murmurHashOffset(value);
        for (int i : offset) {
            bloomOperate.add(key, i);
        }
    }

    /**
     * 用指定的布隆过滤器方法判断值是否存在于布隆过滤器中
     * @param value
     * @param <T>
     * @return
     */
    public <T> boolean includeByBloomFilter(T value) {
        Preconditions.checkArgument(bloomFilterHelper != null, "bloomFilterHelper不能为空");
        int[] offset = bloomFilterHelper.murmurHashOffset(value);
        for (int i : offset) {
            if (!bloomOperate.exists(key, i)) {
                return false;
            }
        }
        return true;
    }

}
