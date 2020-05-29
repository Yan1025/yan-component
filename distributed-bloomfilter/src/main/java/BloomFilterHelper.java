import com.google.common.base.Preconditions;
import com.google.common.hash.Funnel;
import com.google.common.hash.Funnels;
import com.google.common.hash.Hashing;

import java.nio.charset.Charset;

/**
 * @Author Yan
 * @Description 布隆过滤器辅助器 用于计算布隆过滤器的桶数 每次散列操作的次数和具体算法
 * @Date 2020/5/16 10:47 下午
 */
public class BloomFilterHelper<T> {
    /**
     * hash循环次数
     */
    private int numHashFunctions;
    /**
     * bitSize长度
     */
    private int bitSize;
    /**
     * 针对不同类型的数据的辅助hash的接口
     */
    private Funnel<T> funnel;

    public BloomFilterHelper(Funnel<T> funnel, int expectedInsertions, double fpp) {
        Preconditions.checkArgument(funnel != null, "funnel不能为空");
        this.funnel = funnel;
        bitSize = optimalNumOfBits(expectedInsertions, fpp);
        numHashFunctions = optimalNumOfHashFunctions(expectedInsertions, bitSize);
    }

    /**
     * 计算bit数组长度
     * @param n 要插入的数量
     * @param p 要求的精度
     * @return
     */
    private int optimalNumOfBits(long n, double p) {
        if (p == 0) {
            p = Double.MIN_VALUE;
        }
        return (int) (-n * Math.log(p) / Math.log(2) * Math.log(2));
    }

    /**
     * 计算hash方法执行次数
     * @param n
     * @param m
     * @return
     */
    private int optimalNumOfHashFunctions(long n, long m) {
        return Math.max(1, (int) Math.round((double) m / n * Math.log(2)));
    }

    /**
     * @Description 将输入的值通过numHashFunctions次的hash运算后 计算出要存入bloom过滤器的hash值数组
     * @param value 要存入bloom过滤器的值
     * @return
     */
    public int[] murmurHashOffset(T value) {
        int[] offset = new int[numHashFunctions];

        long hash64 = Hashing.murmur3_128().hashObject(value, funnel).asLong();
        int hash1 = (int) hash64;
        int hash2 = (int) (hash64 >>> 32);
        for (int i = 1; i <= numHashFunctions; i++) {
            int nextHash = hash1 + i * hash2;
            if (nextHash < 0 ) {
                nextHash = ~nextHash;
            }
            offset[i-1] = nextHash % bitSize;
        }

        return offset;
    }

    public static void main(String[] args) {
        //要插入的数据量
        int expectedInsertions = 200000000;
        //Bloom过滤器的判断错误率
        double fpp = 0.01;

        BloomFilterHelper<String> bloomFilterHelper =
                new BloomFilterHelper(Funnels.stringFunnel(Charset.defaultCharset()), expectedInsertions, fpp);
    }

}
