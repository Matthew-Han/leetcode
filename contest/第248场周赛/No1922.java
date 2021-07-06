package 第248场周赛;

/**
 * @author <a href="https://github.com/Matthew-Han">Matthew Han</a>
 * @date 2021/7/4 10:29
 * @since 1.0
 **/
public class No1922 {


    long mod = 1000000000 + 7;

    /**
     * 统计好数字的数目
     *
     * @param n
     * @return
     */
    public int countGoodNumbers(long n) {
        long right = n / 2;
        long left = n - right;
        long tmp1 = qmi(5L, left);
        long tmp2 = qmi(4L, right);
        long ans = tmp1 * tmp2 % mod;
        return (int) ans;
    }

    /**
     * 快速幂
     *
     * @param x
     * @param a
     * @return
     */
    public long qmi(long x, long a) {
        long res = 1;
        while (a > 0) {
            if (a % 2 == 1) {
                res = (res * x) % mod;
            }
            x = x * x % mod;
            a /= 2;
        }
        return res;
    }


}
