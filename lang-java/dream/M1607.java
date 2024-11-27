/**
 * @ClassName Maximum
 * @Description 面试题 16.07. 最大数值
 * @Author MatthewHan
 * @Date 2020/7/29 09:19
 * @Version 1.0
 **/
public class M1607 {

    /**
     * 首先 a - b 得到差值x
     * <p>
     * 由于是long型，右移63位得到符号位，注意负号不变，那么正数右移63位就是0，负数右移63位就是-1
     * <p>
     * 那么得出我们的计算公式 (1 + k) * a - b * k
     * 当 x >= 0 的时候，k = 0, 即 a > b
     * 那么我们的计算公式为 1 * a - b * 0 = a
     * <p>
     * 当 x < 0的时候，k = -1, 即 b > a
     * 那么我们的计算公式为 0 * a - b * (-1) = b
     *
     * @param a
     * @param b
     * @return
     */
    public int maximum(int a, int b) {
        long x = (long) a - (long) b;
        int k = (int) (x >> 63);
        return (1 + k) * a - b * k;
    }

}
