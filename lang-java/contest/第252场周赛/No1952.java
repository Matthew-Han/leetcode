package 第252场周赛;

/**
 * @author <a href="https://github.com/Matthew-Han">Matthew Han</a>
 * @date 2021/8/2 09:46
 * @since 1.0
 **/
public class No1952 {

    /**
     * 三除数
     *
     * @param n
     * @return
     */
    public boolean isThree(int n) {
        int ans = 0;
        for (int i = 1; i <= n; i++) {
            if (n % i == 0) {
                ans++;
            }

        }
        return ans == 3;
    }
}
