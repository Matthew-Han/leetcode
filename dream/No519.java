import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ThreadLocalRandom;

/**
 * @author <a href="https://github.com/Matthew-Han">Matthew Han</a>
 * @date 2021/11/29 14:32
 * @since 1.0
 **/
public class No519 {

    Map<Integer, Integer> data;
    int m;
    int n;
    int total;

    /**
     * 随机翻转矩阵
     *
     * @param m
     * @param n
     */
    public No519(int m, int n) {
        this.m = m;
        this.n = n;
        this.total = m * n;
        reset();
    }

    public int[] flip() {
        int rnd = ThreadLocalRandom.current().nextInt(total);
        total--;
        int idx = data.getOrDefault(rnd, rnd);
        data.put(rnd, data.getOrDefault(total, total));
        return fun(idx, n);
    }

    public void reset() {
        this.data = new HashMap<>();
        this.total = this.m * this.n;
    }


    public int[] fun(int c, int m) {
        return new int[]{c / m, c % m};
    }
}
