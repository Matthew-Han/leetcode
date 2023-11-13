package 动态规划;

/**
 * @author <a href="https://github.com/Matthew-Han">Matthew Han</a>
 * @date 2022/4/22 10:14 22
 * @since 1.0
 **/
public class No357 {

    /**
     * 统计各位数字都不同的数字个数
     *
     * @param n
     * @return
     */
    public int countNumbersWithUniqueDigits(int n) {
        int ans = 1;
        for (int i = 1; i <= n; i++) {
            int t = 1;
            int c = 9;
            boolean flag = false;
            for (int j = 1; j <= i; j++) {
                t *= c;
                if (flag) {
                    c--;
                }
                flag = true;
            }
            ans += t;
        }
        return ans;
    }
}
