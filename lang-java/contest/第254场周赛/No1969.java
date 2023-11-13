package 第254场周赛;

/**
 * @author <a href="https://github.com/Matthew-Han">Matthew Han</a>
 * @date 2021/8/16 10:42
 * @since 1.0
 **/
public class No1969 {


    long mod = 1000000000 + 7;

    /**
     * 数组元素的最小非零乘积
     *
     * @param p
     * @return
     */
    public int minNonZeroProduct(int p) {

        long ans = ((qmi(2, p) - 2)) % mod;
        long c = 1;
        for (int i = 1; i < p; i++) {
            c <<= 1;
        }
        c--;
        ans = qmi(ans, c) % mod;
        long end = (qmi(2, p) - 1) % mod;
        ans *= end % mod;
        return (int) (ans % mod);
    }

    public long qmi(long x, long a) {
        long res = 1;
        while (a > 0) {
            if (a % 2 == 1) {
                res = (res * x) % mod;
            }
            x = x * x % mod;
            a /= 2;
        }
        return res % mod;
    }
}
