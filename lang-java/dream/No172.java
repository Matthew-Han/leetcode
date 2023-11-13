/**
 * @ClassName FactorialTrailingZeroes
 * @Description #172 阶乘后的零
 * @Author MatthewHan
 * @Date 2020/4/23 17:44
 * @Version 1.0
 **/
public class No172 {

    /**
     * 算多少个 5
     * 但是当有个 25 时，拆分成 2 个 5 相乘，但是 30 的时候是 1 个 5
     *
     * @param n
     * @return
     */
    public int trailingZeroes(int n) {
        int count = 0;
        while (n >= 5) {
            count += n / 5;
            n /= 5;
        }
        return count;
    }

}
