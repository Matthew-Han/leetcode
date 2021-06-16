/**
 * @ClassName FactorialTrailingZeroes
 * @Description #172 阶乘后的零
 * @Author MatthewHan
 * @Date 2020/4/23 17:44
 * @Version 1.0
 **/
public class No172 {

    /**
     * 算多少个5
     * 但是当有个25时，拆分成2个5相乘，所以30的时候是7个5
     *
     * @param n
     * @return
     */
    public static int trailingZeroes(int n) {

        int count = 0;
        while (n >= 5) {
            count += n / 5;
            n /= 5;
        }
        return count;
    }

    public static void main(String[] args) {
        System.out.println(trailingZeroes(20));
    }
}
